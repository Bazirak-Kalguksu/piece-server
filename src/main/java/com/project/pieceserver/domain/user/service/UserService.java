package com.project.pieceserver.domain.user.service;

import com.project.pieceserver.domain.user.client.dto.User;
import com.project.pieceserver.domain.user.domain.repository.jpa.UserRepository;
import com.project.pieceserver.domain.user.exception.NotEnoughMoneyException;
import com.project.pieceserver.domain.user.exception.NotEnoughPointException;
import com.project.pieceserver.domain.user.exception.PasswordWrongException;
import com.project.pieceserver.domain.user.exception.UserExistException;
import com.project.pieceserver.domain.user.exception.UserNotFoundException;
import com.project.pieceserver.global.common.repository.UserSecurity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserSecurity userSecurity;
    private final PasswordEncoder encoder;
    private final User userDTO;

    public void editUserName(String name) {
        User user = getUser();
        user.setName(name);
        userRepository.save(user.toEntity(user));
    }

    public void save(User user) {
        existUserCheck(user.getEmail());
        userRepository.save(user.toEntity(user));
    }

    public void existUserCheck(String email){
        if (userRepository.findByEmail(email).isPresent())
            throw UserExistException.EXCEPTION;
    }

    public void checkPassword(String password, User user) {
        if(!encoder.matches(password, user.getPassword())){
            throw PasswordWrongException.EXCEPTION;
        }
    }

    public User getUserByEmail(String email) {
        return userRepository
                .findByEmail(email)
                .map(userDTO::toUser)
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);
    }

    public User getUser(){
        return userRepository
                .findByEmail(userSecurity.getUser().getEmail())
                .map(userDTO::toUser)
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);
    }

    public int donateMoney(int money){
        User user = getUser();
        int oldBalance = user.getBalance();
        int currentBalance = oldBalance - money;
        if(currentBalance < 0)
            throw NotEnoughMoneyException.EXCEPTION;
        user.setBalance(currentBalance);
        userDTO.toEntity(user);
        return currentBalance;
    }

    public int donatePoint(int point){
        User user = getUser();
        int oldPoint = user.getPoint();
        int currentPoint = oldPoint - point;
        if(currentPoint < 0)
            throw NotEnoughPointException.EXCEPTION;
        user.setPoint(currentPoint);
        userDTO.toEntity(user);
        return currentPoint;
    }

    public int chargeMoney(int money){
        User user = getUser();
        int oldBalance = user.getBalance();
        int currentBalance = oldBalance + money;
        user.setBalance(currentBalance);
        userDTO.toEntity(user);
        return currentBalance;
    }

    public int chargePoint(int point){
        User user = getUser();
        int oldPoint = user.getPoint();
        int currentPoint = oldPoint + point;
        user.setPoint(currentPoint);
        userDTO.toEntity(user);
        return currentPoint;
    }

}

package com.project.pieceserver.domain.user.application.service;

import com.project.pieceserver.domain.user.client.dto.User;
import com.project.pieceserver.domain.user.client.dto.request.NameEditRequest;
import com.project.pieceserver.domain.user.domain.repository.jpa.UserRepository;
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

    public void editUserName(NameEditRequest request) {
        User user = getUser();
        user.setName(request.getName());
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


}

package com.project.pieceserver.domain.user.application.service;

import com.project.pieceserver.domain.user.client.dto.User;
import com.project.pieceserver.domain.user.client.dto.request.NameEditRequest;
import com.project.pieceserver.domain.user.domain.repository.jpa.UserRepository;
import com.project.pieceserver.domain.user.domain.repository.jpa.UserSecurity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserSecurity userSecurity;
    private final User userDTO;

    public void editUserName(NameEditRequest request) {

//        User user = new User();
//        User user = userUtil.
        User user = userRepository
                .findByEmail(userSecurity.getUser().getEmail())
                .map(userDTO::toUser)
                .orElseThrow(null);
        user.setName(request.getName());
        userRepository.save(user.toEntity(user));
    }


}

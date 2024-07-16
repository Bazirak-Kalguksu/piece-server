package com.project.pieceserver.domain.user.application.service;

import com.project.pieceserver.domain.user.application.util.UserUtil;
import com.project.pieceserver.domain.user.client.dto.User;
import com.project.pieceserver.domain.user.client.dto.request.NameEditRequest;
import com.project.pieceserver.domain.user.domain.entity.UserEntity;
import com.project.pieceserver.domain.user.domain.mapper.UserMapper;
import com.project.pieceserver.domain.user.domain.repository.jpa.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserUtil userUtil;
    private final UserMapper userMapper;

    public void editUserName(NameEditRequest request) {
        User user = new User();
        user.setName(request.getName());
        userRepository.save(userMapper.toEdit(user));
    }


}

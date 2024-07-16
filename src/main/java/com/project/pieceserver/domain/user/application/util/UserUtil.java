package com.project.pieceserver.domain.user.application.util;


import com.project.pieceserver.domain.user.client.dto.User;
import com.project.pieceserver.domain.user.domain.mapper.UserMapper;
import com.project.pieceserver.domain.user.domain.repository.jpa.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserUtil {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

}

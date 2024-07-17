package com.project.pieceserver.domain.user.usecase;

import com.project.pieceserver.domain.user.application.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserUseCase {

    private final UserService userService;

}

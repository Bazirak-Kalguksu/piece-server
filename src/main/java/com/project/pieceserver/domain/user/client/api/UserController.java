package com.project.pieceserver.domain.user.client.api;

import com.project.pieceserver.domain.user.application.service.UserService;
import com.project.pieceserver.domain.user.client.dto.request.NameEditRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    @PatchMapping("/user")
    public void editUser(@Validated @RequestBody NameEditRequest request) {
        userService.editUserName(request);
    }
}

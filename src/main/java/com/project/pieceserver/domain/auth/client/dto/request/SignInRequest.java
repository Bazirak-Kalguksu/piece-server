package com.project.pieceserver.domain.auth.client.dto.request;

public record SignInRequest(
        String email,
        String password
){}

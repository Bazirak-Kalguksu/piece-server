package com.project.pieceserver.domain.auth.client.request;

public record SignInRequest(
        String email,
        String password
){}

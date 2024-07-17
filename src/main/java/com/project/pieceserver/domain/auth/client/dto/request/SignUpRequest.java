package com.project.pieceserver.domain.auth.client.dto.request;

public record SignUpRequest(
        String email,
        String password,
        String name,
        String birth
){}

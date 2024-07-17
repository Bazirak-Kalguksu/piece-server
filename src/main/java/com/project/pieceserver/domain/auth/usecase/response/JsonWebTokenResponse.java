package com.project.pieceserver.domain.auth.usecase.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.pieceserver.domain.user.domain.enums.UserRole;
import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record JsonWebTokenResponse(
        String accessToken,
        String refreshToken,
        UserRole userRole
){}
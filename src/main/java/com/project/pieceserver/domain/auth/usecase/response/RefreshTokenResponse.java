package com.project.pieceserver.domain.auth.usecase.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record RefreshTokenResponse(
        String accessToken
){}

package com.project.pieceserver.domain.donate.usecase.response;

import lombok.Builder;

@Builder
public record DonateResponse(
        int balance
){}
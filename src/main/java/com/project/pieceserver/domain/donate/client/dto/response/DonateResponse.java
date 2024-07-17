package com.project.pieceserver.domain.donate.client.dto.response;

import lombok.Builder;

@Builder
public record DonateResponse(
        int balance
){}
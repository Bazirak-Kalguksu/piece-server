package com.project.pieceserver.domain.campaign.client.dto.request;

public record CampaignRegisterRequest(
        String title,
        String description,
        String imageUrl
) {
}

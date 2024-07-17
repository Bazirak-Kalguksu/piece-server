package com.project.pieceserver.domain.campaign.usecase;

import com.project.pieceserver.domain.campaign.application.service.CampaignService;
import com.project.pieceserver.domain.campaign.client.dto.Campaign;
import com.project.pieceserver.domain.campaign.client.dto.request.CampaignRegisterRequest;
import com.project.pieceserver.global.common.dto.request.PageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CampaignUseCase {

    private final CampaignService campaignService;

    public void registerCampaign(CampaignRegisterRequest campaignRegisterRequest) {
        campaignService.save(Campaign.builder()
                        .title(campaignRegisterRequest.title())
                        .description(campaignRegisterRequest.description())
                        .imageUrl(campaignRegisterRequest.imageUrl())
                .build());
    }

    public List<Campaign> campaignList(PageRequest pageRequest) {
        return campaignService.CampaignList(pageRequest);
    }

}

package com.project.pieceserver.domain.campaign.usecase;

import com.project.pieceserver.domain.campaign.client.dto.request.CampaignSearchRequest;
import com.project.pieceserver.domain.campaign.service.CampaignService;
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
        campaignService.save(campaignRegisterRequest);
    }

    public List<Campaign> campaignList(PageRequest pageRequest) {
        return campaignService.campaignList(pageRequest);
    }

    public List<Campaign> campaignSearch(CampaignSearchRequest campaignSearchRequest) {
        return campaignService.campaignSearch(campaignSearchRequest);
    }

}

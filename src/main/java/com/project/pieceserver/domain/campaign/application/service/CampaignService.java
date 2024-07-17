package com.project.pieceserver.domain.campaign.application.service;

import com.project.pieceserver.domain.campaign.client.dto.Campaign;
import com.project.pieceserver.domain.campaign.domain.repository.jpa.CampaignRepository;
import com.project.pieceserver.domain.campaign.domain.repository.query.CampaignQueryRepository;
import com.project.pieceserver.global.common.dto.request.PageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CampaignService {

    private final CampaignRepository campaignRepository;
    private final CampaignQueryRepository campaignQueryRepository;
    private final Campaign campaignDTO;

    public void save(Campaign campaign) {
        campaignRepository.save(campaignDTO.toEntity(campaign));
    }

    public List<Campaign> CampaignList(PageRequest pageRequest) {
        return campaignQueryRepository.campaignList(pageRequest);
    }

}

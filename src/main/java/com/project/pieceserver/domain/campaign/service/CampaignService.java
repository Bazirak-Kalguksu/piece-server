package com.project.pieceserver.domain.campaign.service;

import com.project.pieceserver.domain.campaign.client.dto.Campaign;
import com.project.pieceserver.domain.campaign.client.dto.request.CampaignRegisterRequest;
import com.project.pieceserver.domain.campaign.client.dto.request.CampaignSearchRequest;
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

    public void save(CampaignRegisterRequest campaignRegisterRequest) {
        campaignRepository.save(campaignDTO.toEntity(Campaign.builder()
                .title(campaignRegisterRequest.title())
                .description(campaignRegisterRequest.description())
                .imageUrl(campaignRegisterRequest.imageUrl())
                .build()));
    }

    public List<Campaign> campaignList(PageRequest pageRequest) {
        return campaignQueryRepository.campaignList(
                pageRequest.getPage(),
                pageRequest.getSize());
    }

    public List<Campaign> campaignSearch(CampaignSearchRequest campaignSearchRequest) {
        return campaignQueryRepository.campaignSearch(
                campaignSearchRequest.getPage(),
                campaignSearchRequest.getSize(),
                campaignSearchRequest.getTitle());
    }

}

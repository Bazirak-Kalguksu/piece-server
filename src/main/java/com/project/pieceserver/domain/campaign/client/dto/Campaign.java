package com.project.pieceserver.domain.campaign.client.dto;

import com.project.pieceserver.domain.campaign.domain.entity.CampaignEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Campaign {

    private Long idx;
    private String title;
    private String description;
    private String imageUrl;

    public CampaignEntity toEntity(Campaign campaign) {
        return CampaignEntity.builder()
                .idx(campaign.getIdx())
                .title(campaign.getTitle())
                .description(campaign.getDescription())
                .imageUrl(campaign.getImageUrl())
                .build();
    }

}

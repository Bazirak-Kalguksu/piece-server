package com.project.pieceserver.domain.campaign.domain.repository.jpa;

import com.project.pieceserver.domain.campaign.domain.entity.CampaignEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<CampaignEntity, Long> {
}

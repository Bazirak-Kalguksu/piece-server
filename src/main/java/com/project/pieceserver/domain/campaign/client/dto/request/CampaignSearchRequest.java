package com.project.pieceserver.domain.campaign.client.dto.request;

import com.project.pieceserver.global.common.dto.request.PageRequest;
import lombok.Getter;

@Getter
public class CampaignSearchRequest extends PageRequest {

    private String title;

}

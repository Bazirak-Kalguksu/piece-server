package com.project.pieceserver.domain.campaign.client.api;

import com.project.pieceserver.domain.campaign.client.dto.Campaign;
import com.project.pieceserver.domain.campaign.client.dto.request.CampaignRegisterRequest;
import com.project.pieceserver.domain.campaign.usecase.CampaignUseCase;
import com.project.pieceserver.global.common.dto.request.PageRequest;
import com.project.pieceserver.global.common.dto.response.BaseResponse;
import com.project.pieceserver.global.common.dto.response.BaseResponseData;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/campaign")
@RequiredArgsConstructor
@Tag(name = "캠페인 API")
public class CampaignController {

    private final CampaignUseCase campaignUseCase;

    @PostMapping("")
    public BaseResponse registerCampaign(@RequestBody CampaignRegisterRequest campaignRegisterRequest) {
        campaignUseCase.registerCampaign(campaignRegisterRequest);
        return BaseResponse.created("등록되었습니다.");
    }

    @GetMapping("")
    public BaseResponseData<List<Campaign>> campaignList(@ModelAttribute PageRequest pageRequest){
        return BaseResponseData.ok(
                "캠페인 리스트를 성공적으로 불러왔습니다.",
                campaignUseCase.campaignList(pageRequest));
    }

}

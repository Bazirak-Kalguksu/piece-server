package com.project.pieceserver.domain.donate.client.api;

import com.project.pieceserver.domain.donate.client.dto.request.DonateMoneyRequest;
import com.project.pieceserver.domain.donate.client.dto.request.DonatePointRequest;
import com.project.pieceserver.domain.donate.client.dto.response.DonateResponse;
import com.project.pieceserver.domain.donate.usecase.DonateUseCase;
import com.project.pieceserver.global.common.dto.response.BaseResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/donate")
@RequiredArgsConstructor
@Tag(name = "후원 API")
public class DonateController {

    private final DonateUseCase donateUseCase;

    @PatchMapping("/money")
    @Operation(summary = "계좌 후원")
    public BaseResponseData<DonateResponse> donateMoney(@Valid @RequestBody DonateMoneyRequest donateMoneyRequest) {
        return BaseResponseData.ok(
                "후원 성공",
                donateUseCase.saveBankLog(donateMoneyRequest));
    }

    @PatchMapping("/point")
    @Operation(summary = "포인트 후원")
    public BaseResponseData<DonateResponse> donatePoint(@Valid @RequestBody DonatePointRequest donatePointRequest) {
        return BaseResponseData.ok(
                "후원 성공",
                donateUseCase.savePointLog(donatePointRequest));
    }

}

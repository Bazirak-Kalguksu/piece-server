package com.project.pieceserver.domain.donate.usecase;

import com.project.pieceserver.domain.donate.client.dto.BankLog;
import com.project.pieceserver.domain.donate.client.dto.PointLog;
import com.project.pieceserver.domain.donate.client.dto.request.DonateMoneyRequest;
import com.project.pieceserver.domain.donate.client.dto.request.DonatePointRequest;
import com.project.pieceserver.domain.donate.usecase.response.DonateResponse;
import com.project.pieceserver.domain.donate.service.BankLogService;
import com.project.pieceserver.domain.donate.service.PointLogService;
import com.project.pieceserver.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DonateUseCase {

    private final BankLogService bankLogService;
    private final PointLogService pointLogService;
    private final UserService userService;

    public DonateResponse saveBankLog(DonateMoneyRequest donateMoneyRequest) {
        int currentMoney = userService.donateMoney(donateMoneyRequest.money());
        bankLogService.saveBankLog(BankLog.builder()
                        .email(userService.getUser().getEmail())
                        .money(donateMoneyRequest.money())
                .build());
        return DonateResponse.builder()
                .balance(currentMoney)
                .build();
    }

    public DonateResponse savePointLog(DonatePointRequest donatePointRequest) {
        int currentPoint = userService.donatePoint(donatePointRequest.point());
        pointLogService.savePointLog(PointLog.builder()
                        .email(userService.getUser().getEmail())
                        .name(userService.getUser().getName())
                        .point(donatePointRequest.point())
                .build());
        return DonateResponse.builder()
                .balance(currentPoint)
                .build();
    }

}

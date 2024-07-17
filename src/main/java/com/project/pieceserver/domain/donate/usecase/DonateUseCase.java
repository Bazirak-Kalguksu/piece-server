package com.project.pieceserver.domain.donate.usecase;

import com.project.pieceserver.domain.donate.client.dto.BankLog;
import com.project.pieceserver.domain.donate.client.dto.PointLog;
import com.project.pieceserver.domain.donate.client.dto.request.DonateMoneyRequest;
import com.project.pieceserver.domain.donate.client.dto.request.DonatePointRequest;
import com.project.pieceserver.domain.donate.service.BankLogService;
import com.project.pieceserver.domain.donate.service.PointLogService;
import com.project.pieceserver.domain.user.application.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DonateUseCase {

    private final BankLogService bankLogService;
    private final PointLogService pointLogService;
    private final UserService userService;

    public void saveBankLog(DonateMoneyRequest donateMoneyRequest) {
        bankLogService.saveBankLog(BankLog.builder()
                        .email(userService.getUser().getEmail())
                        .money(donateMoneyRequest.money())
                .build());
    }

    public void savePointLog(DonatePointRequest donatePointRequest) {
        pointLogService.savePointLog(PointLog.builder()
                        .email(userService.getUser().getEmail())
                        .point(donatePointRequest.point())
                .build());
    }

}

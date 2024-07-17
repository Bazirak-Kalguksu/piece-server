package com.project.pieceserver.domain.user.usecase;

import com.project.pieceserver.domain.user.application.service.UserService;
import com.project.pieceserver.domain.user.client.dto.response.ChargeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserUseCase {

    private final UserService userService;

    public ChargeResponse chargeMoney (int money){
        int currentMoney = userService.chargeMoney(money);
        return ChargeResponse.builder()
                .currentBalance(currentMoney)
                .build();
    }

    public ChargeResponse chargePoint (int point){
        int currentPoint = userService.chargePoint(point);
        return ChargeResponse.builder()
                .currentBalance(currentPoint)
                .build();
    }

    public void editName(String name){
        userService.editUserName(name);
    }

}

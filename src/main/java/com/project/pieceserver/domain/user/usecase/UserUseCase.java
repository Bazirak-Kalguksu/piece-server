package com.project.pieceserver.domain.user.usecase;

import com.project.pieceserver.domain.donate.client.dto.response.UserRankingResponse;
import com.project.pieceserver.domain.user.client.dto.User;
import com.project.pieceserver.domain.user.service.UserService;
import com.project.pieceserver.domain.user.usecase.response.ChargeResponse;
import com.project.pieceserver.global.common.dto.request.PageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserUseCase {

    private final UserService userService;

    public User getUser(){
        return userService.getUser();
    }

    public List<UserRankingResponse> userRanking(PageRequest pageRequest){
        return userService.userRanking(pageRequest.getPage(),pageRequest.getSize());
    }

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

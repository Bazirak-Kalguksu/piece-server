package com.project.pieceserver.domain.user.client.api;

import com.project.pieceserver.domain.donate.client.dto.response.UserRankingResponse;
import com.project.pieceserver.domain.user.client.dto.User;
import com.project.pieceserver.domain.user.usecase.UserUseCase;
import com.project.pieceserver.domain.user.usecase.response.ChargeResponse;
import com.project.pieceserver.global.common.dto.request.PageRequest;
import com.project.pieceserver.global.common.dto.response.BaseResponse;
import com.project.pieceserver.global.common.dto.response.BaseResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "유저 API")
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserUseCase userUseCase;

    @GetMapping("")
    @Operation(summary = "유저 프로필")
    public BaseResponseData<User> getUser() {
        return BaseResponseData.ok(
                "유저 프로필 불러오기 성공",
                userUseCase.getUser());
    }

    @GetMapping("/ranking")
    @Operation(summary = "유저 랭킹")
    public BaseResponseData<List<UserRankingResponse>> userRanking(PageRequest pageRequest) {
        return BaseResponseData.ok(
                "유저 랭킹 불러오기 성공",
                userUseCase.userRanking(pageRequest));
    }

    @PatchMapping("/charge-money")
    @Operation(summary = "유저 계좌 잔액 충전")
    public BaseResponseData<ChargeResponse> chargeMoney(@RequestParam int money) {
        return BaseResponseData.ok(
                "충전 성공",
                userUseCase.chargeMoney(money));
    }

    @PatchMapping("/charge-point")
    @Operation(summary = "유저 포인트 충전")
    public BaseResponseData<ChargeResponse> chergePoint(@RequestParam int point) {
        return BaseResponseData.ok(
                "충전 성공",
                userUseCase.chargePoint(point));
    }

    @PatchMapping("/name")
    @Operation(summary = "유저 이름 변경")
    public BaseResponse editUser(@Validated @RequestBody String name) {
        userUseCase.editName(name);
        return BaseResponse.ok("이름 변경이 완료되었습니다 ㅋ");
    }

}

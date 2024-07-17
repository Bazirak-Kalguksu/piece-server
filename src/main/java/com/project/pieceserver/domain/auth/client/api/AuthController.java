package com.project.pieceserver.domain.auth.client.api;

import com.project.pieceserver.domain.auth.client.dto.request.RefreshTokenRequest;
import com.project.pieceserver.domain.auth.client.dto.request.SignInRequest;
import com.project.pieceserver.domain.auth.client.dto.request.SignUpRequest;
import com.project.pieceserver.domain.auth.client.dto.response.JsonWebTokenResponse;
import com.project.pieceserver.domain.auth.client.dto.response.RefreshTokenResponse;
import com.project.pieceserver.domain.auth.usecase.AuthUseCase;
import com.project.pieceserver.domain.user.usecase.UserUseCase;
import com.project.pieceserver.global.common.dto.response.BaseResponse;
import com.project.pieceserver.global.common.dto.response.BaseResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "인증 API")
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthUseCase authUseCase;

    @PostMapping("/sign-up")
    @Operation(summary = "유저 회원가입")
    public BaseResponse signUp(@Validated @RequestBody SignUpRequest signUpRequest){
        authUseCase.signUp(signUpRequest);
        return BaseResponse.created("회원가입이 완료되었습니다.");
    }

    @PostMapping("/sign-in")
    @Operation(summary = "로그인")
    public BaseResponseData<JsonWebTokenResponse> signIn(@Validated @RequestBody SignInRequest signInRequest){
        return BaseResponseData.ok(
                "로그인 성공",
                authUseCase.signIn(signInRequest));
    }

    @PostMapping("/refresh")
    @Operation(summary = "토큰 재발급", description = "access 토큰을 재발급 합니다")
    public BaseResponseData<RefreshTokenResponse> refresh(RefreshTokenRequest request){
        return BaseResponseData.ok(
                "토큰 재발급 성공",
                authUseCase.refresh(request.refreshToken()));
    }

}

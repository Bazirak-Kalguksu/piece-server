package com.project.pieceserver.domain.auth.usecase;

import com.project.pieceserver.domain.auth.client.request.SignInRequest;
import com.project.pieceserver.domain.auth.client.request.SignUpRequest;
import com.project.pieceserver.domain.auth.usecase.response.JsonWebTokenResponse;
import com.project.pieceserver.domain.auth.usecase.response.RefreshTokenResponse;
import com.project.pieceserver.domain.user.application.service.UserService;
import com.project.pieceserver.domain.user.client.dto.User;
import com.project.pieceserver.domain.user.domain.enums.UserRole;
import com.project.pieceserver.global.security.jwt.JwtExtract;
import com.project.pieceserver.global.security.jwt.JwtProvider;
import com.project.pieceserver.global.security.jwt.enums.JwtType;
import com.project.pieceserver.global.security.jwt.exception.TokenTypeException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthUseCase {

    private final UserService userService;
    private final PasswordEncoder encoder;
    private final JwtProvider jwtProvider;
    private final JwtExtract jwtExtract;

    public void signUp(SignUpRequest signUpRequest) {
        userService.save(User.builder()
                        .email(signUpRequest.email())
                        .password(encoder.encode(signUpRequest.password()))
                        .name(signUpRequest.name())
                        .point(0)
                        .balance(0)
                        .birth(signUpRequest.birth()).build());
    }

    public JsonWebTokenResponse signIn(SignInRequest signInRequest) {
        User user = userService.getUserByEmail(signInRequest.email());
        userService.checkPassword(signInRequest.password(),user);
        return JsonWebTokenResponse.builder()
                .accessToken(jwtProvider.generateAccessToken(signInRequest.email(),user.getUserRole()))
                .refreshToken(jwtProvider.generateRefreshToken(signInRequest.email(), user.getUserRole()))
                .userRole(user.getUserRole())
                .build();
    }

    public RefreshTokenResponse refresh(String token) {
        Jws<Claims> claims = jwtExtract.getClaims(jwtExtract.extractToken(token));
        if (jwtExtract.isWrongType(claims, JwtType.REFRESH)) {
            throw TokenTypeException.EXCEPTION;
        }
        return RefreshTokenResponse.builder()
                .accessToken(jwtProvider.generateAccessToken(claims.getBody().getSubject(),
                        (UserRole) claims.getHeader().get("authority"))).build();
    }

}

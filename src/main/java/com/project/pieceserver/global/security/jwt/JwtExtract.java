package com.project.pieceserver.global.security.jwt;

import com.project.pieceserver.domain.user.client.dto.User;
import com.project.pieceserver.domain.user.domain.repository.jpa.UserRepository;
import com.project.pieceserver.domain.user.exception.UserNotFoundException;
import com.project.pieceserver.global.security.auth.CustomUserDetails;
import com.project.pieceserver.global.security.jwt.config.JwtProperties;
import com.project.pieceserver.global.security.jwt.enums.JwtType;
import com.project.pieceserver.global.security.jwt.exception.TokenErrorException;
import com.project.pieceserver.global.security.jwt.exception.TokenExpiredException;
import com.project.pieceserver.global.security.jwt.exception.TokenNotSupportException;
import com.project.pieceserver.global.security.jwt.exception.TokenTypeException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.UnsupportedJwtException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
public class JwtExtract {

    private final JwtProperties jwtProperties;
    private final UserRepository userRepository;
    private final User userDTO;

    public Jws<Claims> getClaims(final String token) {
        try {
            return Jwts.parser().setSigningKey(jwtProperties.getSecretKey()).parseClaimsJws(token);
        } catch (ExpiredJwtException e) {
            throw TokenExpiredException.EXCEPTION;
        } catch (UnsupportedJwtException e) {
            throw TokenNotSupportException.EXCEPTION;
        } catch (IllegalArgumentException e) {
            throw TokenErrorException.EXCEPTION;
        }
    }

    public Authentication getAuthentication(final String token) {
        final Jws<Claims> claims = getClaims(token);

        if (isWrongType(claims, JwtType.ACCESS)) {
            throw TokenTypeException.EXCEPTION;
        }

        User user = userRepository.findByEmail(claims
                .getBody()
                .getSubject())
                .map(userDTO::toUser)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        final CustomUserDetails details = new CustomUserDetails(user);

        return new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities());
    }

    public String extractTokenFromRequest(HttpServletRequest request) {
        return extractToken(request.getHeader(HttpHeaders.AUTHORIZATION));
    }

    public String extractToken(final String token) {
        if (StringUtils.hasText(token) && token.startsWith("Bearer ")) {
            return token.substring(7);
        }
        return token;
    }

    public boolean isWrongType(final Jws<Claims> claims, final JwtType jwtType) {
        return !(claims.getHeader().get(Header.JWT_TYPE).equals(jwtType.toString()));
    }

}

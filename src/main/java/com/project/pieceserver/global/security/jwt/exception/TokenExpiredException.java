package com.project.pieceserver.global.security.jwt.exception;

import com.project.pieceserver.global.exception.BusinessException;
import com.project.pieceserver.global.security.jwt.exception.error.JwtTokenError;

public class TokenExpiredException extends BusinessException {

    public static final TokenExpiredException EXCEPTION = new TokenExpiredException();

    private TokenExpiredException() {
        super(JwtTokenError.JWT_EXPIRED);
    }

}

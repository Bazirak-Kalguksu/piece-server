package com.project.pieceserver.global.security.jwt.exception;

import com.project.pieceserver.global.exception.BusinessException;
import com.project.pieceserver.global.security.jwt.exception.error.JwtTokenError;

public class TokenNotSupportException extends BusinessException {

    public static final TokenNotSupportException EXCEPTION = new TokenNotSupportException();

    private TokenNotSupportException() {
        super(JwtTokenError.JWT_NOT_SUPPORT);
    }


}

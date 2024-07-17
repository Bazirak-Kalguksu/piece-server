package com.project.pieceserver.global.security.jwt.exception;

import com.project.pieceserver.global.exception.BusinessException;
import com.project.pieceserver.global.security.jwt.exception.error.JwtTokenError;

public class TokenTypeException extends BusinessException {

    public static final TokenTypeException EXCEPTION = new TokenTypeException();

    private TokenTypeException() {
        super(JwtTokenError.JWT_TOKEN_ERROR);
    }

}

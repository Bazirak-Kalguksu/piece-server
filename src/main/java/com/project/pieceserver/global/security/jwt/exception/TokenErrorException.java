package com.project.pieceserver.global.security.jwt.exception;

import com.project.pieceserver.global.exception.BusinessException;
import com.project.pieceserver.global.security.jwt.exception.error.JwtTokenError;

public class TokenErrorException extends BusinessException {

    public static final TokenErrorException EXCEPTION = new TokenErrorException();

    private TokenErrorException() {
        super(JwtTokenError.JWT_TOKEN_ERROR);
    }


}

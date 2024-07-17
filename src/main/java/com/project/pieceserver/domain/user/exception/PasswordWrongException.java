package com.project.pieceserver.domain.user.exception;

import com.project.pieceserver.domain.user.exception.error.UserError;
import com.project.pieceserver.global.exception.BusinessException;

public class PasswordWrongException extends BusinessException {

    public static final PasswordWrongException EXCEPTION = new PasswordWrongException();

    private PasswordWrongException() {
        super(UserError.PASSWORD_WRONG);
    }

}

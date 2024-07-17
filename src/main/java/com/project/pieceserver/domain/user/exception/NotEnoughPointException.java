package com.project.pieceserver.domain.user.exception;

import com.project.pieceserver.domain.user.exception.error.UserError;
import com.project.pieceserver.global.exception.BusinessException;

public class NotEnoughPointException extends BusinessException {

    public static final NotEnoughPointException EXCEPTION = new NotEnoughPointException();

    private NotEnoughPointException() {
        super(UserError.NOT_ENOUGH_POINT);
    }

}

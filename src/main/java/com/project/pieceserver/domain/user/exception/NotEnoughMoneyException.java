package com.project.pieceserver.domain.user.exception;

import com.project.pieceserver.domain.user.exception.error.UserError;
import com.project.pieceserver.global.exception.BusinessException;

public class NotEnoughMoneyException extends BusinessException {

    public static final NotEnoughMoneyException EXCEPTION = new NotEnoughMoneyException();

    private NotEnoughMoneyException() {
        super(UserError.NOT_ENOUGH_MONEY);
    }

}

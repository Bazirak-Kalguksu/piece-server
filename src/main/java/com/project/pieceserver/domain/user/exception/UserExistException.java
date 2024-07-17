package com.project.pieceserver.domain.user.exception;

import com.project.pieceserver.domain.user.exception.error.UserError;
import com.project.pieceserver.global.exception.BusinessException;

public class UserExistException extends BusinessException {

    public static final UserExistException EXCEPTION = new UserExistException();

    private UserExistException(){
        super(UserError.USER_EXIST);
    }

}

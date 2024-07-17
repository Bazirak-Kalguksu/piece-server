package com.project.pieceserver.domain.user.exception;

import com.project.pieceserver.domain.user.exception.error.UserError;
import com.project.pieceserver.global.exception.BusinessException;

public class UserNotFoundException extends BusinessException {

    public static final UserNotFoundException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException(){
        super(UserError.USER_NOT_FOUND);
    }

}

package com.dct.model.exception;

import com.dct.model.constants.BaseHttpStatusConstants;

@SuppressWarnings("unused")
public class BaseBadRequestException extends BaseException {

    public BaseBadRequestException(String entityName, String errorKey) {
        super(BaseHttpStatusConstants.BAD_REQUEST, entityName, errorKey, null, null);
    }

    public BaseBadRequestException(Integer code, String entityName, String errorKey) {
        super(code, entityName, errorKey, null, null);
    }

    public BaseBadRequestException(Integer code, String entityName, String errorKey, Object[] args, Throwable error) {
        super(code, entityName, errorKey, args, error);
    }
}

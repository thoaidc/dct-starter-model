package com.dct.model.exception;

import com.dct.model.constants.BaseHttpStatusConstants;

@SuppressWarnings("unused")
public class BaseAuthenticationException extends BaseException {

    public BaseAuthenticationException(String entityName, String errorKey) {
        super(BaseHttpStatusConstants.UNAUTHORIZED, entityName, errorKey, null, null);
    }

    public BaseAuthenticationException(Integer code, String entityName, String errorKey) {
        super(code, entityName, errorKey, null, null);
    }

    public BaseAuthenticationException(Integer code, String entityName, String errorKey, Object[] args, Throwable error) {
        super(code, entityName, errorKey, args, error);
    }
}

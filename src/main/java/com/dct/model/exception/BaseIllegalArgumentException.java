package com.dct.model.exception;

import com.dct.model.constants.BaseHttpStatusConstants;

@SuppressWarnings("unused")
public class BaseIllegalArgumentException extends BaseException {

    public BaseIllegalArgumentException(String entityName, String errorKey) {
        super(BaseHttpStatusConstants.INTERNAL_SERVER_ERROR, entityName, errorKey, null, null);
    }

    public BaseIllegalArgumentException(Integer code, String entityName, String errorKey) {
        super(code, entityName, errorKey, null, null);
    }

    public BaseIllegalArgumentException(Integer code, String entityName, String errorKey, Object[] args, Throwable error) {
        super(code, entityName, errorKey, args, error);
    }
}

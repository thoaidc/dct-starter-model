package com.dct.model.exception;

import com.dct.model.constants.BaseHttpStatusConstants;

@SuppressWarnings("unused")
public class BaseBadRequestAlertException extends BaseException {

    public BaseBadRequestAlertException(String entityName, String errorKey) {
        super(BaseHttpStatusConstants.INTERNAL_SERVER_ERROR, entityName, errorKey, null, null);
    }

    public BaseBadRequestAlertException(Integer code, String entityName, String errorKey) {
        super(code, entityName, errorKey, null, null);
    }

    public BaseBadRequestAlertException(Integer code, String entityName, String errorKey, Object[] args, Throwable error) {
        super(code, entityName, errorKey, args, error);
    }
}

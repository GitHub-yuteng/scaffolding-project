package com.scaffolding.response;

import com.scaffolding.enums.ResponseStatusEnum;

/**
 * @author whh-yt
 * @Date 2021/10/11
 * @Desc
 */
public class ResponseStatus {

    public static final ResponseStatus SUCCESS      = new ResponseStatus(ResponseStatusEnum.SUCCESS.getType(), ResponseStatusEnum.SUCCESS.getTypeDesc());
    public static final ResponseStatus FAIL         = new ResponseStatus(ResponseStatusEnum.FAIL.getType(), ResponseStatusEnum.FAIL.getTypeDesc());
    public static final ResponseStatus SERVER_ERROR = new ResponseStatus(ResponseStatusEnum.SERVER_ERROR.getType(), ResponseStatusEnum.SERVER_ERROR.getTypeDesc());

    private final Integer status;
    private final String message;

    public ResponseStatus(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}

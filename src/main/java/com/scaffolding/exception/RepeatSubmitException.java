package com.scaffolding.exception;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/2/18 9:48 上午
 */
public class RepeatSubmitException extends AppException{

    private static final long serialVersionUID = 5413623596532521806L;

    public RepeatSubmitException(String string) {
        super(string);
    }
}

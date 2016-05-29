package com.doppler.blog.exception;

/**
 * Created by doppler on 2016/5/29.
 */
public final class NotFoundException extends RuntimeException{
    private String errMsg;
    public NotFoundException(){};
    public NotFoundException(String message){ this.errMsg = message; }

    @Override
    public String getMessage() {
        return this.errMsg;
    }
}

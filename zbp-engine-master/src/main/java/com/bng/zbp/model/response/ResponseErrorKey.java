package com.bng.zbp.model.response;

/**
 * @Author Mansi Rajora
 */
public enum ResponseErrorKey {

    SUCCESS("SUCCESS"),
    ERROR("ERROR"),
    FAILED("FAILED"),
    INVALID("INVALID"),
    UNAUTHENTICATED("UNAUTHENTICATED");
    public String value;

    ResponseErrorKey(String value) {
        this.value = value;
    }
}

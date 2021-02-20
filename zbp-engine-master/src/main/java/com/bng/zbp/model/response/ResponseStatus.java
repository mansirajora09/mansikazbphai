package com.bng.zbp.model.response;

/**
 * @Author Mansi Rajora
 */
public enum ResponseStatus {

    SUCCESS(200),
    FAILED(400),
    INVALID(401),
    UNAUTHENTICATED(403);
    public int value;

    ResponseStatus(int value) {
        this.value = value;
    }
}

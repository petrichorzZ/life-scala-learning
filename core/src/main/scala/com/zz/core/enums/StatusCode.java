package com.zz.core.enums;

/**
 * Created by tao.zeng on 2018/10/8.
 */
public enum StatusCode {

    CODE_200(200, "successful!"),
    CODE_400(400, "parameter failure."),
    CODE_404(404, "resources not found."),
    CODE_500(500, "failure.");

    int code;
    String message;

    StatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

package com.yuxinsheng.demotest.common;

/**
 * @author yuxinsheng
 * @date 2018/10/24 10:22
 */
public class ReplyResult<T> {


    public final static int SUCCESS = 200;

    public final static int ERROR = 0;

    public final static int NOT_FOUND = 404;

    private int code;
    private String message;
    private T data;

    public ReplyResult() {
        this.code = SUCCESS;
    }

    public ReplyResult(T data) {
        this.code = SUCCESS;
        this.message = "SUCCESS";
        this.data = data;
    }

    public ReplyResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}

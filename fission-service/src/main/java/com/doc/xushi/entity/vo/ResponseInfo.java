package com.doc.xushi.entity.vo;

import java.io.Serializable;

/**
 * Created by 5000 on 2018/4/1.
 */
public class ResponseInfo<T> implements Serializable {

    private static final long serialVersionUID = 5819597210639658899L;

    private boolean success;

    private int code;

    private String message;

    private T model;

    public ResponseInfo() {
        this.code = 200;
        this.message = "操作成功";
        this.success = true;
    }

    public ResponseInfo(boolean success ,int code ,String message,T data) {
        this.code = code;
        this.message = message;
        this.success = success;
        this.model = data;
    }

    public ResponseInfo(boolean success ,int code ,String message) {
        this.code = code;
        this.message = message;
        this.success = success;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }
}

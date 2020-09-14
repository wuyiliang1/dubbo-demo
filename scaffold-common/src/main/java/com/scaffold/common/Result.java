package com.scaffold.common;

import com.scaffold.common.exception.SysStatusCode;

import java.io.Serializable;

/**
 * 响应数据
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 状态码
     */
    private int code = 100000;
    /**
     * 消息内容
     */
    private String msg = "SUCCESS";
    /**
     * 响应数据
     */
    private T data;

    public Result<T> ok(T data) {
        this.setData(data);
        return this;
    }

    public boolean success(){
        return code == 0;
    }

    public Result<T> error() {
        this.code = SysStatusCode.SYS_ERROR.getCode();
        this.msg = SysStatusCode.SYS_ERROR.getMsg();
        return this;
    }

    public Result<T> error(int code) {
        this.code = code;
        this.msg = SysStatusCode.SYS_ERROR.getMsg();
        return this;
    }

    public Result<T> error(int code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }

    public Result<T> error(String msg) {
        this.code = SysStatusCode.SYS_ERROR.getCode();
        this.msg = msg;
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

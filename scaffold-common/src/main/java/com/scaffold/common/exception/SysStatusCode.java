package com.scaffold.common.exception;

import lombok.Getter;

/**
 *  系统状态码（100000 ~ 999999）
 *   前3位为模块编码，后3位为具体业务编码
 *
 * @author wuyiliang
 * @date 2020/9/14 9:13
 */
@Getter
public enum SysStatusCode {
    /**
     *  成功
     */
    SYS_SUCCESS(100000, "SUCCESS"),
    /**
     *  系统默认错误编码
     */
    SYS_ERROR(100001, "服务繁忙,请稍候再试"),
    TOKEN_NOT_BLANK(100002, "token不能为空");

    private final int code;

    private final String msg;

    public static SysStatusCode of(int code) {
        for (SysStatusCode status : SysStatusCode.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        return SYS_ERROR;
    }

    SysStatusCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

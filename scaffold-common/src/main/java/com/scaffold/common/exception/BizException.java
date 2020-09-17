package com.scaffold.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 *  业务异常
 *
 * @author wuyiliang
 * @date 2020/9/14 9:09
 */
@Getter
@Setter
public class BizException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private int code;

    private String msg;

    public BizException(int code) {
        this(SysStatusCode.of(code));
    }

    public BizException(String msg) {
        this(SysStatusCode.SYS_ERROR.getCode(), msg);
    }

    public BizException(SysStatusCode status) {
        super(status.getMsg());
        this.code = status.getCode();
        this.msg = status.getMsg();
    }

    public BizException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}

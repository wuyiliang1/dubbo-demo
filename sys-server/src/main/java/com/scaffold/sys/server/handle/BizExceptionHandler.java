package com.scaffold.sys.server.handle;

import com.scaffold.common.Result;
import com.scaffold.common.exception.BizException;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author wuyiliang
 * @date 2020/9/14 16:39
 */
@Slf4j
@RestControllerAdvice
public class BizExceptionHandler {

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(BizException.class)
    public Result handleRenException(BizException ex){
        log.error(ex.getMsg());
        Result result = new Result();
        result.error(ex.getCode(), ex.getMsg());
        return result;
    }

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception ex){
        log.error(ex.getMessage());
        return new Result().error();
    }
}
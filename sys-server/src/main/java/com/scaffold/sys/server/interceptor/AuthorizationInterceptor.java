package com.scaffold.sys.server.interceptor;

import cn.hutool.core.util.StrUtil;
import com.scaffold.common.exception.BizException;
import com.scaffold.common.exception.SysStatusCode;
import com.scaffold.sys.server.annotation.Login;
import com.scaffold.sys.server.service.TokenService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wuyiliang
 * @date 2020/9/15 10:31
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Login annotation;
        if (handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(Login.class);
            if (annotation == null){
                return true;
            }
        } else {
            return true;
        }

        //从header中获取token
        String token = request.getHeader("token");
        //如果header中不存在token，则从参数中获取token
        if(StrUtil.isBlank(token)){
            token = request.getParameter("token");
        }

        //token为空
        if(StrUtil.isBlank(token)){
            throw new BizException(SysStatusCode.TOKEN_NOT_BLANK);
        }

        // 校验token
        Claims claims = tokenService.validateToken(token);
        //设置userId到request里，后续根据userId，获取用户信息
        request.setAttribute("userId", claims.getId());

        return true;
    }
}

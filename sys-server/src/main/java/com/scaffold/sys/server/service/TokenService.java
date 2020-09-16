package com.scaffold.sys.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.scaffold.sys.server.entity.TokenEntity;
import io.jsonwebtoken.Claims;

/**
 * @author wuyiliang
 * @date 2020/9/14 17:20
 */
public interface TokenService extends IService<TokenEntity> {

    /**
     *  生成唯一token
     *
     * @param userId 用户id
     * @return token
     */
    String createPrimaryToken(Long userId);

    /**
     *  生成普通token
     *
     * @param userId 用户id
     * @return token
     */
    String createNormalToken(Long userId);

    /**
     *  唯一token校验
     *
     * @param token token
     * @return Clams
     */
    Claims validatePrimaryToken(String token);

    /**
     *  token校验
     *
     * @param token token
     * @return Claims
     */
    Claims validateNormalToken(String token);
}

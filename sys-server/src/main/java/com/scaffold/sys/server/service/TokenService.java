package com.scaffold.sys.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.scaffold.sys.server.entity.TokenEntity;

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
}

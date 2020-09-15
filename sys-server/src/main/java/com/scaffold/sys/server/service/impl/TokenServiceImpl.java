package com.scaffold.sys.server.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scaffold.common.exception.BizException;
import com.scaffold.sys.server.dao.TokenDao;
import com.scaffold.sys.server.entity.TokenEntity;
import com.scaffold.sys.server.service.TokenService;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author wuyiliang
 * @date 2020/9/14 17:21
 */
@Service
public class TokenServiceImpl extends ServiceImpl<TokenDao, TokenEntity> implements TokenService {

    /**
     *  默认24小时过期
     */
    private static final int EXPIRE_TIME = 1000 * 3600 * 24;
    private static final String SIGNING_KEY = "1000 * 3600 * 24";
    @Value("${spring.application.name:scaffold}")
    private static String appName;

    @Override
    public String createPrimaryToken(Long userId) {
        String token = createNormalToken(userId);
        TokenEntity entity = new TokenEntity();
        entity.setToken(token);
        entity.setUserId(userId);
        saveOrUpdate(entity);
        return token;
    }

    @Override
    public String createNormalToken(Long userId) {
        return JwtHelper.createJwt(userId);
    }

    @Override
    public Claims validateToken(String token) {
        return JwtHelper.parseJwt(token);
    }


    private static class JwtHelper {
        public static String createJwt(Long userId) {
            long exp = System.currentTimeMillis() + EXPIRE_TIME;
            JwtBuilder jb = Jwts.builder()
                    .setId(String.valueOf(userId))
                    .setIssuer(appName)
                    .signWith(SignatureAlgorithm.HS256, SIGNING_KEY)
                    .setExpiration(new Date(exp));
            return jb.compact();
        }

        public static Claims parseJwt(String token) {
            Claims claims = Jwts.parser().setSigningKey(SIGNING_KEY).parseClaimsJws(token).getBody();
            if (!StrUtil.equals(appName, claims.getIssuer())) {
                throw new BizException("非本系统签发token");
            }
            return claims;
        }
    }
}

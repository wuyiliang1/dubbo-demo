package com.scaffold.sys.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scaffold.sys.server.dao.TokenDao;
import com.scaffold.sys.server.entity.TokenEntity;
import com.scaffold.sys.server.service.TokenService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

    private static class JwtHelper {
        public static String createJwt(Long userId) {
            long exp = System.currentTimeMillis() + EXPIRE_TIME;
            Map<String, Object> chaims = new HashMap<>(4);
            chaims.put("beer", userId);
            JwtBuilder jb = Jwts.builder()
                    .setClaims(chaims)
                    .signWith(SignatureAlgorithm.HS256, SIGNING_KEY)
                    .setExpiration(new Date(exp));
            return jb.compact();
        }
    }
}

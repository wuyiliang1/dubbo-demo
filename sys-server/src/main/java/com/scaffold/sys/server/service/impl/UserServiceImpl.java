package com.scaffold.sys.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scaffold.sys.server.dao.UserDao;
import com.scaffold.sys.server.entity.UserEntity;
import com.scaffold.sys.server.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author wuyiliang
 * @date 2020/9/11 12:46
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Override
    public String hellp(String str) {
        return "hello " + str;
    }
}

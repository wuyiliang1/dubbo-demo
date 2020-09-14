package com.scaffold.sys.server.controller;

import com.scaffold.sys.server.entity.UserEntity;
import com.scaffold.sys.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuyiliang
 * @date 2020/9/11 13:48
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("test1")
    public Object test() {
        for (int i = 0; i < 100; i++) {
            UserEntity entity = new UserEntity();
            entity.setMobile("123");
            entity.setPassword("456");
            entity.setUsername("user" + i);
            userService.save(entity);
        }
        return "ok";
    }

}

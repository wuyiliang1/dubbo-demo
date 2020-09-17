package com.scaffold.sys.server.controller;

import com.scaffold.sys.server.annotation.TokenFree;
import com.scaffold.sys.server.service.TokenService;
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
    private TokenService tokenService;

    @TokenFree
    @GetMapping("/t1")
    public String test() {
        return "12";
    }

    @GetMapping("/t2")
    public String te() {
        return "34";
    }
}

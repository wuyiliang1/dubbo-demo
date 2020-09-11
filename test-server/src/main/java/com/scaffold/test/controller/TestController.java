package com.scaffold.test.controller;

import com.scaffold.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuyiliang
 * @date 2020/9/11 15:31
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/test1")
    public Object test1(@RequestParam String key) {
        return testService.test1(key);
    }
}

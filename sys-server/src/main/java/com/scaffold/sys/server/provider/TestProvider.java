package com.scaffold.sys.server.provider;

import com.scaffold.sys.client.api.TestApi;
import com.scaffold.sys.server.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wuyiliang
 * @date 2020/9/11 15:04
 */
@Service
public class TestProvider implements TestApi {

    @Autowired
    private UserService userService;

    @Override
    public String test(String str) {
        return "";
    }
}

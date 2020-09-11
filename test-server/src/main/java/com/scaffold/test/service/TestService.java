package com.scaffold.test.service;

import com.scaffold.sys.client.api.TestApi;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @author wuyiliang
 * @date 2020/9/11 15:47
 */
@Service
public class TestService {
    @Reference
    TestApi testApi;

    public String test1(String str) {
        return testApi.test(str);
    }
}

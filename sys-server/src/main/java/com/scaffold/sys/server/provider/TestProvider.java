package com.scaffold.sys.server.provider;

import com.scaffold.sys.client.api.TestApi;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author wuyiliang
 * @date 2020/9/11 15:04
 */
@Service
public class TestProvider implements TestApi {

    public String test(String str) {
        return str + "TestProvider";
    }
}

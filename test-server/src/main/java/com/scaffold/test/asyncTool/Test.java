package com.scaffold.test.asyncTool;

import com.jd.platform.async.executor.Async;
import com.jd.platform.async.worker.WorkResult;
import com.jd.platform.async.wrapper.WorkerWrapper;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author wuyiliang
 * @date 2020/9/22 18:03
 */
public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        WorkerWrapper<String, String> work1 =  new WorkerWrapper.Builder<String, String>()
                .worker((param, map) -> {
                    System.out.println("work1");

                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

//                    throw new RuntimeException("work1 Exception");
                    return param + "-> work1";
                })

                .callback((flag, param, result)
                        -> System.out.println("回调： flag=" + flag + ",param=" + param + ",result=" + result))
                .param("work1-param")
                .id("work1")
                .build();

        WorkerWrapper<String, String> work2 = new WorkerWrapper.Builder<String, String>()

                .worker((param, map) -> {
                    System.out.println("work2");
                    WorkResult work1Rs = map.get("work1").getWorkResult();
                    System.out.println("work1结果：" + work1Rs);

                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    return work1Rs + "-> work2";
                })
                .callback((flag, param, result)
                        -> System.out.println("回调： flag=" + flag + ",param=" + param + ",result=" + result))
                .depend(work1)
                .build();
        
        Async.beginWork(3500, work1);
        // web项目不要关闭
        Async.shutDown();
    }
}

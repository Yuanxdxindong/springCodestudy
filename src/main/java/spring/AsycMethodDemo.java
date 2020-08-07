package spring;

import lombok.Data;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

/**
 * @author yuanxindong
 * @date 2020/7/31 16:49
 */
@EnableAsync
@Service
public class AsycMethodDemo {

@Async
public void asyncMethod(Integer i) throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("异步任务"+i+"执行完成");
    }
}

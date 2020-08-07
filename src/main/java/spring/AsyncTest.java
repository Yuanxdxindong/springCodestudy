package spring;

import config.MainConfig;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author yuanxindong
 * @date: 2020/7/31 16:53
 */
@Service
public class AsyncTest {
    @Autowired
    AsycMethodDemo asycMethodDemo;
    @Test
   public void runAsyncTask() throws InterruptedException {
        Thread.sleep(50000);
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        AsycMethodDemo asycMethodDemo =  applicationContext.getBean(AsycMethodDemo.class);
    int i = 0;
    for( i = 0; i< 100;i++){
        asycMethodDemo.asyncMethod(i);
        System.out.println("任务"+i+"执行完成");
    }

    Thread.sleep(1000000);
    }

}

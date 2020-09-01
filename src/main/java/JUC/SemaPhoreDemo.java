package JUC;

import jdk.nashorn.internal.ir.CallNode;
import lombok.extern.slf4j.Slf4j;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @authoryuanxindong
 * @date: 2020/6/24 2:19 上午
 */
@Slf4j
public class SemaPhoreDemo implements Runnable{
    private Integer No;
    private static Semaphore semaphore;
    private  static Integer THREAD_COUNT;


    public SemaPhoreDemo(Integer no) {
        No = no;
    }

    @Override
    public void run() {
        try {
            System.out.println("等待坑位" + No);
            semaphore.acquire();
            System.out.println("坑位拉屎" + No);
            Thread.sleep(3000);
            semaphore.release();
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }
    }

    public static void main(String[] args) {
        THREAD_COUNT = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(100);
         semaphore  =  new Semaphore(THREAD_COUNT);
                for (int i = 0; i<100;i++){
                    SemaPhoreDemo semaPhoreDemo = new SemaPhoreDemo(i);
                    executorService.submit(semaPhoreDemo);
                }

    }
}

package JUC;

import jdk.nashorn.internal.ir.CallNode;
import lombok.Data;
import lombok.SneakyThrows;
import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.concurrent.CountDownLatch;

/**
 * @authoryuanxindong
 * @date: 2020/6/16 10:18 下午
 */
public class CountDownLatchDemo implements Runnable{
    private static final  int DownLatchCount = 3;
    private  int  timeOut;
    public CountDownLatchDemo(int timeOut){
        this.timeOut = timeOut;
    }

   static final CountDownLatch latch = new CountDownLatch(DownLatchCount);
    public static void main(String[] args) {
        // 创建多个线程，且每个线程的sleep的时间是不一致的
        CountDownLatchDemo countDownLatchDemo = new CountDownLatchDemo(1000);
        Thread thread = new Thread(countDownLatchDemo);
        CountDownLatchDemo countDownLatchDemov2 = new CountDownLatchDemo(3000);
        Thread thread1 =new  Thread(countDownLatchDemov2);
        CountDownLatchDemo countDownLatchDemov3 = new CountDownLatchDemo(4000);
        Thread thread2 =new  Thread(countDownLatchDemov3);
        long start = System.currentTimeMillis();
        thread.start();
        thread1.start();
        thread2.start();

        try {
            System.out.println("等待+"+DownLatchCount+"+个子线程执行完毕...");
           long time2 = System.currentTimeMillis();
            latch.await();
            System.out.println(DownLatchCount+"个子线程已经执行完毕");
            long time = System.currentTimeMillis()-start;
            //通过执行的时间大概，查看CountDownLatch的效果。
            System.out.println("time:"+ time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    @Override
    public void run() {
        Thread.sleep(timeOut);
        System.out.println("yuanxindongO"+Thread.currentThread().getName());
        latch.countDown();
    }
}

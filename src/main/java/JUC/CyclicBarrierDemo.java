package JUC;

import lombok.SneakyThrows;

import java.awt.*;
import java.util.concurrent.CyclicBarrier;

/**
 * @authoryuanxindong
 * @date: 2020/6/18 11:53 下午
 */
public class CyclicBarrierDemo implements Runnable{
    private int  timeOut ;
    private CyclicBarrier cyclicBarrier;

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;

    }
    public  static class innerCyclicBarrierDemo  implements Runnable{
        @Override
        public void run() {
            System.out.println("最后执行的方法+");
        }
    }

    public CyclicBarrierDemo(int timeOut,CyclicBarrier cyclicBarrier) {
        this.timeOut = timeOut;
        this.cyclicBarrier = cyclicBarrier;
    }


    public static void main(String[] args) {
        // 启用一个CyclicBarrier，然后进行加载。
        CyclicBarrier cyclicBarrier =new CyclicBarrier(3,new innerCyclicBarrierDemo());
        long startTime = System.currentTimeMillis();
        CyclicBarrierDemo cyclicBarrierDemo = new CyclicBarrierDemo(1000,cyclicBarrier);
        Thread thread = new Thread(cyclicBarrierDemo);
        CyclicBarrierDemo cyclicBarrierDemo2 = new CyclicBarrierDemo(2000,cyclicBarrier);
        Thread thread1 = new Thread(cyclicBarrierDemo2);
        CyclicBarrierDemo cyclicBarrierDemo3 = new CyclicBarrierDemo(3000,cyclicBarrier);
        Thread thread2 = new Thread(cyclicBarrierDemo3);
           thread.start();
           thread1.start();
           thread2.start();


        System.out.println("所有线程执行结束执行时间："+(System.currentTimeMillis() -startTime));
    }
    @SneakyThrows
    @Override
    public void run() {
        System.out.println("开始执行：「」"+Thread.currentThread().getName()+System.currentTimeMillis());
        Thread.sleep(timeOut);
      long watingTime = System.currentTimeMillis();
        System.out.println("等待：「」"+Thread.currentThread().getName()+watingTime);
        cyclicBarrier.await();
        System.out.println("完成：「」"+Thread.currentThread().getName() +"    time:    "+ (System.currentTimeMillis()-watingTime));
    }

}

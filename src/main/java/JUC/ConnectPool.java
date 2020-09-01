package JUC;

import java.awt.image.SampleModel;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @authoryuanxindong
 * @date: 2020/6/25 1:13 上午
 */
public class ConnectPool {
    public static class Connect {

    }

    /**
     * 连接池大小
     */
    private int size;
    /**
     * 连接的对象
     */
    private Connect[] connects;
    /**
     * 连接状态
     */
    private boolean[] connectFlag;
    /**
     * 可用连接
     */
    private volatile int available;
    /**
     * 信号量
     */
    private Semaphore semaphore;

    public ConnectPool(int size) {
        this.size = size;
        this.connects = new Connect[size];
        this.connectFlag = new boolean[size];
        this.available = size;
        //使用true为公平等待
        this.semaphore = new Semaphore(size, true);
        initConnects();
    }

    /**
     * 初始化连接
     */
    private void initConnects() {
        //将连接
        for (int i = 0; i < this.size; i++) {
            connects[i] = new Connect();
        }
    }

    /**
     * 获取数据库的连接
     *
     * @return
     */
    private synchronized Connect getConnect() {
        for (int i = 0; i < connectFlag.length; i++) {
            //遍历集合找到未使用的连接
            if (!connectFlag[i]) {
                //将连接设置为使用中
                connectFlag[i] = true;
                //可用连接数减1 非原子性操作
                available--;
                System.out.println("【" + Thread.currentThread().getName() + "】以获取连接，剩余连接数：" + available);
                //返回连接引用
                return connects[i];
            }
        }
        return null;
    }

    /**
     * 获取一个链接
     *
     * @return
     * @throws InterruptedException
     */
    public Connect openConnect() throws InterruptedException {
        //获取许可证
        semaphore.acquire();
        //获取数据库连接
        return getConnect();
    }

    /**
     * 释放一个连接
     *
     * @param connect
     */
    public synchronized void release(Connect connect) {
        for (int i = 0; i < this.size; i++) {
            if (connect == connects[i]) {
                //将连接设置为未使用
                connectFlag[i] = false;
                //可用连接数加1
                available++;
                System.out.println("【" + Thread.currentThread().getName() + "】以释放连接      剩余连接数：" + available);
                //释放许可证
                semaphore.release();
            }
        }
    }

    /**
     * 剩余连接数
     *
     * @return
     */
    public int available() {
        return available;
    }

    /**
     * 测试线程
     */
    public static class ThreadDemo implements Runnable {
        private static ConnectPool pool = new ConnectPool(3);

        @Override
        public void run() {
            try {
                Connect connect = pool.openConnect();
                Thread.sleep(100);  //休息一下
                pool.release(connect);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {

    }


}

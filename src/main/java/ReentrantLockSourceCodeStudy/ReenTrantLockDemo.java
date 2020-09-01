package ReentrantLockSourceCodeStudy;

import com.sun.corba.se.spi.activation.BadServerDefinition;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author yuanxindong
 */
public class ReenTrantLockDemo implements Runnable {
    private static ReentrantLock reentrantLock = new ReentrantLock();
    static int i = 1;

    public static void main(String[] args) {
        try {
            reentrantLock.lock();

            System.out.println();
        } catch (Exception e) {
            reentrantLock.unlock();
            e.getMessage();
        } finally {
            reentrantLock.unlock();
        }
    }



    public void run() {
    }
}

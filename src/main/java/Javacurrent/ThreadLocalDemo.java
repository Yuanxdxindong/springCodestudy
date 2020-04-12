package Javacurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *
 */
public class ThreadLocalDemo extends Thread {
    ThreadLocal threadLocal = new ThreadLocal();

    @Override
    public void run() {
        String str  = super.getName()+"thread name";
        threadLocal.set(str);
        String s = addValue("2");
        threadLocal.remove();
        System.out.println(s);
    }

    private String  addValue(String name){
        // threadLocal.remove();
        return "addvalue"+name+threadLocal.get();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            ThreadLocalDemo ctt = new ThreadLocalDemo();
            ctt.start();
        }
    }
}

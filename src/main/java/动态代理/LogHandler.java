package 动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author:yuanxindong
 * @Date:2020/5/90:47
 */
public class LogHandler  implements InvocationHandler {
    private Object  target;
    public LogHandler(Object target){
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object  result  = method.invoke(target,args);
        after();
        return result;
    }
    private void before(){
        System.out.println("log start"+ System.currentTimeMillis());
    }

    private  void after(){
        System.out.println("log end" + System.currentTimeMillis());
    }

}

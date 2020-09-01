package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author:yuanxindong
 * @Date:2020/5/90:47
 */
public class LogHandler  implements InvocationHandler {
    private Object  target;
    //使用构造方法将代理对象传入代理对象
    public LogHandler(Object target){
        this.target = target;
    }

    //通过反射的方式执行并织入（不知道用的是否合理）代理方法，这个接口实现方法会被newProxyInstance（）方法使用
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        //
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

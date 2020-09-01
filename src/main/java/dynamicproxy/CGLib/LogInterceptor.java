package dynamicproxy.CGLib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Author:yuanxindong
 * @Date:2020/5/91:26
 */
public class LogInterceptor implements MethodInterceptor {

    /**
         * @param object 表示要进行增强的对象
         * @param method 表示拦截的方法
         * @param objects 数组表示参数列表，基本数据类型需要传入其包装类型，如int-->Integer、long-Long、double-->Double
         * @param methodProxy 表示对方法的代理，invokeSuper方法表示对被代理对象方法的调用
         * @return 执行结果
         * @throws Throwable
         */
        public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            before();
            // 注意这里是调用 invokeSuper 而不是 invoke，否则死循环，methodProxy.invokesuper执行的是原始类的方法，method.invoke执行的是子类的方法
            Object result = methodProxy.invokeSuper(object, objects);
            after();
            return result;
        }
        private void before() {
            System.out.println(String.format("log start time [%s] ", new Date()));
        }
        private void after() {
            System.out.println(String.format("log end time [%s] ", new Date()));
        }


}


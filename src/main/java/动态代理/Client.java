package 动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author:yuanxindong
 * @Date:2020/5/90:53
 */
public class Client {
    public static void main(String[] args) {
        UserServiceImpl userServiceLmpl = new UserServiceImpl();
        //使用classLOader进行创建
        ClassLoader classLoader = userServiceLmpl.getClass().getClassLoader();
        //获取被代理对象所有实现的接口
        Class []  interfaces = userServiceLmpl.getClass().getInterfaces();
        // 将被代理对象的实例添加到代理对象中
        InvocationHandler logHandler = new LogHandler(userServiceLmpl);
        //创建一个代理对象
        UserService proxy = (UserService) Proxy.newProxyInstance(classLoader,interfaces,logHandler);
        //通过动态代理创建的代理对象进行调用
        proxy.select();
        proxy.update();
        ProxyUtils.generateClassFile(userServiceLmpl.getClass(), "UserServiceProxy");

    }
}

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

        ClassLoader classLoader = userServiceLmpl.getClass().getClassLoader();

        Class []  interfaces = userServiceLmpl.getClass().getInterfaces();
        InvocationHandler logHandler = new LogHandler(userServiceLmpl);

        UserService proxy = (UserService) Proxy.newProxyInstance(classLoader,interfaces,logHandler);

        proxy.select();
        proxy.update();
        ProxyUtils.generateClassFile(userServiceLmpl.getClass(), "UserServiceProxy");

    }
}

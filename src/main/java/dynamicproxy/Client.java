package dynamicproxy;

import java.lang.reflect.*;

/**
 * @Author:yuanxindong
 * @Date:2020/5/90:53
 */
public class Client {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        //实例化一个对象
        //分别分为两种方事实现的，一个是直接new 关键字创建一个对象，
        // 第二种是通过反射机制穿件一个对象
        //UserServiceImpl userServiceLmpl = new UserServiceImpl();
        //1。 读取加载"dynamicproxy.UserServiceImpl"路径下的class对象
        Class aClass = Class.forName("dynamicproxy.UserServiceImpl");

        //使用class对象中的方法获取父类加载器
        //ClassLoader classLoader = userServiceLmpl.getClass().getClassLoader();
        ClassLoader classLoader = aClass.getClassLoader();
        //Class []  interfaces = userServiceLmpl.getClass().getInterfaces();
        //获取实现class实现的接口
        Class[] interfaces = aClass.getInterfaces();

        //获取这个类的、构造方法
        Constructor constructors = aClass.getConstructor();
        //通过构造方法 去实例化这个对象
        UserServiceImpl userServiceLmpl = (UserServiceImpl) constructors.newInstance();
        //将获取到的对象传入对应的处理器上，通过反射的方式拿到对应的方法切织入
        InvocationHandler logHandler = new LogHandler(userServiceLmpl);
        //创建动态代理对象的接口
        UserService proxy = (UserService) Proxy.newProxyInstance(classLoader, interfaces, logHandler);

        proxy.select();
        proxy.update();
        ProxyUtils.generateClassFile(userServiceLmpl.getClass(), "UserServiceProxy");

    }
}

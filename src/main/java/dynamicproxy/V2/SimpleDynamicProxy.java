package dynamicproxy.V2;

import java.lang.reflect.Proxy;

/**
 * @author yuanxindong
 * @date
 */
public class SimpleDynamicProxy {
    public static void consumer(Interface iface){
        iface.doSomething();
        iface.somethingElse("yuanxindong");
    }

    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        consumer(realObject);
        //动态生成代理对象的的静态方法
        Interface proxy = (Interface) Proxy.newProxyInstance(
                //通过Java中的反射拿到代理对象
                Interface.class.getClassLoader(),
                //获取代理对象的所有接口
                new Class[]{Interface.class},
                //将代理
                new DynamicProxyHandler(realObject));
        consumer(proxy);

    }
}

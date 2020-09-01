package dynamicproxy.V2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * author
 */
public class DynamicProxyHandler  implements InvocationHandler {
    private  Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy Object:"+proxy.getClass()+"method" +
                method+"args"+args);
        if(args != null){
            for(Object o : args){
                System.out.println(""+args);
            }
        }
        return method.invoke(proxied,args);
    }

}

package dynamicproxy.V2;

import static jdk.nashorn.internal.objects.Global.print;

/**
 * @author yuanxindong
 */
public class RealObject implements Interface{
    public void doSomething() {
        print("doSometing");
    }

    public void somethingElse(String arg) {
        print("somethingElse");
    }
}

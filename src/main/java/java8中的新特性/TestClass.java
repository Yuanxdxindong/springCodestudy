package java8中的新特性;

/**
 * @author yuanxindong
 * @date: 2020/7/8 22:36
 */
public class TestClass implements interfaceDemo{
    public static void main(String[] args) {
        TestClass t  = new TestClass();
       System.out.println(t.getString("类的传参！！！"));
    }

    @Override
    public String getString(String string) {
         return  "实现的方法:{}"+string;
    }


}

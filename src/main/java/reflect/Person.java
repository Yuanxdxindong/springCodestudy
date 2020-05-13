package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author:yuanxindong
 * @Date:2020/5/1113:23
 */
public class Person extends Huaman{

    private  String name;
    private  String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //通过classLoad 获取类的 Class 对象实例。
        Class c = Class.forName("reflect.Person");
        //根据Class对象实例获取 Constructor 对象
        Method setName = c.getMethod("setName", String.class);
        //根据 Class 对象实例获取 Constructor 对象
        Constructor constructor = c.getConstructor();
        //使用Constructor对象的newInstance 方法获取反射类对象
        Object o = constructor.newInstance();
        //使用invoke方法调用创建实例对象的方法。
        setName.invoke(o,"yuanxindong");
        //查看调用是否成功
        System.out.println(o.toString());

    }
}

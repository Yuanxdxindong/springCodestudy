package SerializableEnum;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.hsf.HSFJSONUtils;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import jdk.nashorn.internal.runtime.JSONFunctions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @Author:yuanxindong
 * @Date:2020/5/101:31
 */
public class Person implements Serializable {
    private static final long serialVersionUID = -1053613777;
    private String name;
    private  PersonEnum a;
   private   WoMan woMan;


    public void setName(String name) {
        this.name = name;
    }

    public void setA(PersonEnum a) {
        this.a = a;
    }

    public String getName() {
        return name;
    }

    public PersonEnum getA() {
        return a;
    }

    public WoMan getWoMan() {
        return woMan;
    }

    public void setWoMan(WoMan woMan) {
        this.woMan = woMan;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", a=" + a +
                '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try {
            // ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.txt"));
            // Person p = new Person();
            // p.setA(PersonEnum.YUANXINDONG);
            // p.setName("小圆");
            // WoMan woMan = new WoMan();
            // p.setWoMan(woMan);
            // oos.writeObject(p);
            //         System.out.println(PersonEnum.YUANXINDONG.toString());

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\workCode\\票税助手\\aresV3\\springCodestudy\\object.txt"));
            Person brady = (Person) ois.readObject();
            brady.getA();
            JSONObject o = (JSONObject) JSONObject.toJSON(brady);

            System.out.println(o);

            String json = "{\"a\":\"1\",\"woMan\":{\"name\":\"苍老师\",\"age\":\"18\"},\"name\":\"小圆\"}";

            Person a = JSON.parseObject(json, Person.class);

            System.out.println(a);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
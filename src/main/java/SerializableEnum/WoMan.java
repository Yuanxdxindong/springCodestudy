package SerializableEnum;

import java.io.Serializable;

/**
 * @Author:yuanxindong
 * @Date:2020/5/1022:14
 */
public class WoMan implements Serializable {
    private  String  name = "苍老师" ;
    private String   age = "18" ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

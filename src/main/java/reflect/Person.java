package reflect;

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

    public static void main(String[] args) throws ClassNotFoundException {
        //获取一个class的三种方式
        Class c = Class.forName("reflect.Person");
        Class c1 = Person.class;
        Huaman person = new Huaman();
        Class C2 = person.getClass();
    }
}

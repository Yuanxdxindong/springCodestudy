package Java8;

import com.sun.tools.javac.util.List;
import org.springframework.core.annotation.SynthesizedAnnotation;

import java.util.ArrayList;

/**
 * @authoryuanxindong
 * @date: 2020/6/5 10:52 下午
 */
public class StreamStudy implements demo1,demo2 {
    private String name;
    private String gender;

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
    public String getString() {
        return "123";
    }

    public static void main(String[] args) {
        demo1 demo1 = new StreamStudy();
        demo1 demo2 = new StreamStudy();
        System.out.println(demo1.getString());
        System.out.println(demo2.getString());


    }
}

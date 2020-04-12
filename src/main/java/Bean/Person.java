package Bean;

import lombok.Data;

@Data
public class Person {
    private String name;
    private Integer age;
    private String gender;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

}

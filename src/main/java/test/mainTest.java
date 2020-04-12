package test;

import Bean.Person;
import config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class mainTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person bean = applicationContext.getBean(Person.class);
        System.out.println("bean为："+bean);

    }
}

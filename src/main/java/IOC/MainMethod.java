package IOC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;

public class MainMethod {
    @Autowired
    Apple apple;
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext();


    }
}

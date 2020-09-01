package test;

import Bean.Person;
import javafx.application.Application;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @Author yuanxindong
 */
@SuppressWarnings("deprecation")
public class BeanFactoryTest {

    /**
     * configReader 用于读取并配置文件，读取然后放在内存中
     * ReflectionUtil 用于配置文件中的配置进行反射是列化
     * App 用于整个逻辑的串联
     */
    @Test
    public  void testSimpleLoad(){


        //读取配置文件，将XML文件抽象为ClassPathResource
//        ClassPathResource classPathResource = new ClassPathResource("bean.xml");
        //通过XmlBeanFactory来创建，BeanFactory也就是存放bean的

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");

        Object person = applicationContext.getBean("Person");
        System.out.println("bean"+ person.toString());
//        BeanFactory bf  = new XmlBeanFactory(classPathResource);
//        Person bean  = (Person)bf.getBean("Person");
//        System.out.println("bean"+ bean.toString());
    }


}

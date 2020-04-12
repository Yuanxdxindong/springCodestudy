package test;

import Bean.Person;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("deprecation")
public class BeanFactoryTest {

    /**
     * configReader 用于读取并配置文件，读取然后放在内存中
     * ReflectionUtil 用于配置文件中的配置进行反射是列化
     * App 用于整个逻辑的串联
     */
    @Test
    public  void testSimpleLoad(){
        BeanFactory bf  = new XmlBeanFactory(new ClassPathResource("bean.xml"));
        Person bean  = (Person)bf.getBean("Person");
        Map<String,String> map  = new HashMap<String, String>();
        ArrayList<String> arrayList = new ArrayList((Collection) map);
        System.out.println("bean"+ bean.toString());
    }


}

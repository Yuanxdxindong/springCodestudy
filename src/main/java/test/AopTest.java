package test;

import AOP.MainConfigAop;
import AOP.MathCalculator;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopTest{


    @Test
    public void test(){

        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(MainConfigAop.class);
        MathCalculator bean = applicationContext.getBean(MathCalculator.class);
        bean.div(1,2);
        applicationContext.close();
    }

}

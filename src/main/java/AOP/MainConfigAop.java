package AOP;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 *
 */
//@EnableAspectJAutoProxy 启动基于AOP的注解模式
    /*
    Aop的注解
    1.@EnableAspectJAutoProxy
        @Import({   .class}) 给容器导入AspectJAutoProxyRegistrar.class
     */
@EnableAspectJAutoProxy
@Configuration
public class MainConfigAop {

    @Bean
    public MathCalculator mathCalculator(){
        return  new MathCalculator();
    }

    @Bean
    public LogAspectService logAspectService(){
        return new LogAspectService();
    }
}

package config;

import Bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import spring.AsycMethodDemo;
@Configuration
public class MainConfig {
    @Bean
    public Person person(){
        return new Person("lisi",20);
    }
    @Bean
    public AsycMethodDemo asycMethodDemo(){
        return new AsycMethodDemo();
    }
}

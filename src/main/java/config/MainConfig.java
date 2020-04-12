package config;

import Bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig {
    @Bean
    public Person person(){
        return new Person("lisi",20);
    }
}

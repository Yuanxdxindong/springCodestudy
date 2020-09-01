package IOC;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
public class Apple {
    private String color;
    private String weight;
    private String size;

    public Apple() {
        this.color = "red";
        this.weight = "10G";
        this.size = "55";
    }

    @Bean
    public Apple createApple(){
       return new Apple();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}

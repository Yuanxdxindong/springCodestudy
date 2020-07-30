package 泛型;

import lombok.Data;

/**
 * @author yuanxindong
 * @date: 2020/7/6 16:22
 */
@Data
public abstract class Animal<T> {
    private T animalEnty;
    private Number age;
}

package effectiveJava;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author yuanxindong
 * @date 2020/9/8 11:09 下午
 */
public abstract class Pizza {
  public enum Topping {
    /** 披萨类型 */
    HAM,
    MUSHROOM,
    ONION,
    PEPPER,
    SAUSAGE
  }

  final Set<Topping> toppings;

  abstract static class Builder<T extends Builder<T>> {
    EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

    public T addTopping(Topping topping) {
      toppings.add(Objects.requireNonNull(topping));
      return self();
    }

    abstract Pizza build();

    protected abstract T self();
  }

  Pizza(Builder<?> builder) {
    toppings = builder.toppings.clone();
  }
}

package 设计模式;

/**
 * @authoryuanxindong
 * @date: 2020/7/4 12:53 上午
 */
public class RedDuck extends Duck implements FlyAble {
    @Override
    public void disPlay() {
        System.out.println("红色");
    }

    @Override
    public void fly() {
        System.out.println("Flying");
    }
}

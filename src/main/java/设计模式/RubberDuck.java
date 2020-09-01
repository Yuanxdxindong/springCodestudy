package 设计模式;

/**
 * @author yuanxindong
 * @date 2020/7/4 12:55 上午
 */
public class RubberDuck extends Duck implements SwingAble {
    /**
     * 这个鸭子只有外观
     */
    @Override
    public void disPlay() {
        System.out.println("灰色");
    }

    @Override
    public void Swing() {
        System.out.println("游泳");
    }
}

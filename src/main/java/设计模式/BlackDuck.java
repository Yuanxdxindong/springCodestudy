package 设计模式;

/**
 * @author yuanxindong
 * @date 2020/7/4 12:43 上午
 */
public class BlackDuck extends Duck implements SwingAble{

    /**
     * 由于是继承于Duck的且duck是没有被实现的，所以duck必须要定义这个
     * 这个约束让代码变得规范
     */
    @Override
    public void disPlay() {
        System.out.println("我是一个黑鸭子");
    }

    @Override
    public void Swing() {
        System.out.println("游泳高手");
    }
}

package 设计模式;

/**
 * @author yuanxindong
 * @date 2020/7/4 12:38 上午
 */
public abstract class Duck {
    /**
     * 由于不是所有的外形都是一样的所以定义一个可以被实现外形的抽象方法
     */
    public abstract void disPlay();

    //所有的鸭子都会呱呱叫，所以这个行为可以放在基类里面，
    // 由于有部分鸭子不会游泳所以不能写在基类上
//    String quack() {
//        return "呱呱挂";
//    }

    /**
     * 所有的鸭子都能游泳
     *
     * @return
     */
    String Swim() {
        return "游泳ING";
    }


}

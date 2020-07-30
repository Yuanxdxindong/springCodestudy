package java8中的新特性;

/**
 * @author yuanxindong
 * @date: 2020/7/8 22:46
 */
public interface interFaceDemo2 {
    default String  getString(String string){
       return "interFaceDemo2接收到字符串！！"+string;
    }
    String  getString();

}

package java8中的新特性;

/**
 * @author yuanxindong
 * @date: 2020/7/8 22:20
 */
public interface interfaceDemo {
     default String getString(String string){
        return "接口接受到类的字符传"+ string;
    }


}

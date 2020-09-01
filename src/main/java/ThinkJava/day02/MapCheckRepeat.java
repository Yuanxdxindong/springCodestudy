package ThinkJava.day02;

import java.util.HashMap;

/**
 * @author yuanxindong
 * @date 2020/7/16  11:07 下午
 */
public class MapCheckRepeat {
  public static void main(String[] args) {
    HashMap<String,String> hashMap = new HashMap<String,String>();
    hashMap.put("1","1");
    hashMap.put("1","1");
    System.out.println(hashMap);
  }
}

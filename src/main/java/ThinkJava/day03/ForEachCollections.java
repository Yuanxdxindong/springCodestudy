package ThinkJava.day03;

import java.util.ArrayList;

/**
 * @author yuanxindong
 * @date 2020/7/19 8:52 下午
 */
public class ForEachCollections {
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<String>();
    for (int i = 0; i < 100; i++) {
      list.add("a" + i);
    }
    for (String string : list) {
      System.out.println("out:" + string);
    }
    }

  }

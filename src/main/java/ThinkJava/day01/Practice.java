package ThinkJava.day01;

import sun.lwawt.LWWindowPeer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author yuanxindong
 * @date 2020/7/15  10:34 下午
 */
public class Practice {
  public static void main(String[] args) {
      Random random = new Random(46);
      List<Integer> integers = Arrays.asList(1, 2, 3, 4);
      int i = integers.indexOf(6);
      System.out.println(i);

  }
}

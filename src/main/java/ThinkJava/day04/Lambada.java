package ThinkJava.day04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yuanxindong
 * @date 2020/7/22  11:34 下午
 */
public class Lambada {
  public static void main(String[] args) {
    //
      List<Object> collect = Arrays.asList("1", "2", "3", "4", "5").stream().filter(t -> t.equals(null)).collect(Collectors.toList());
  }

}

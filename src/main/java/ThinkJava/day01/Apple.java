package ThinkJava.day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yuanxindong
 * @date 2020/7/15  9:19 下午
 */
public class Apple {
    private  static long counter;
    private final long id = counter++;
    public  long id(){
        return id;
    }
    public static class Orange {
    }

    @SuppressWarnings("unchecked")
  public static void main(String[] args) {
      ArrayList apples = new ArrayList();
      for(int i = 0 ;i<3;i++){
          apples.add(new Apple());

          apples.add(new Orange());

          for(int j = 0;j<apples.size();j++){
              ((Apple)apples.get(i)).id();
          }
      }
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
    }
}

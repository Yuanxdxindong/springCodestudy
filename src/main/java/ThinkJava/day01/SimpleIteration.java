package ThinkJava.day01;

import java.util.*;

/**
 * @author yuanxindong
 * @date 2020/7/15  11:08 下午
 */
public class SimpleIteration {
  public static void main(String[] args) {

      List<Integer> strings = new ArrayList<Integer>();
      for(int i =0 ; i<100;i++){
          strings.add(1);
          strings.add(Integer.valueOf(String.valueOf(new Random(46).nextInt())));
      }
      Iterator<Integer> iterator = strings.iterator();
      while(iterator.hasNext()){
          Integer next = iterator.next();
          iterator.remove();
          System.out.println(next);
      }
      Map<String ,String> map = new HashMap<String,String>(10);

  }
}

package ThinkJava.day02;

import java.util.*;

/**
 * @author yuanxindong
 * @date 2020/7/16  10:47 下午
 */
public class Practice18 {
  public static void main(String[] args) {
    //组装
      Map<String, String> hashMap = new HashMap<String, String>();
      Random random = new Random(43);

      for(int i =0 ;i<43;i++){
          hashMap.put("random"+random.nextInt(43),"random"+random.nextInt(43));
      }
      Collection<String> values = hashMap.keySet();
      Iterator<String> iterator = values.iterator();
      HashSet<String> hashSet = new HashSet<String>( );
      hashSet.add("");
      while(iterator.hasNext()){
          System.out.println(iterator.next());
      }
  }
}

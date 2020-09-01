package 面试题;

import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

/**
 * @author yuanxindong
 * @date 2020/7/28  10:35 下午
 */
@Data
public class HashMapDemo {
    private String  name;
    private String  value;
  public static void main(String[] args) {
    //
  HashMap<Object,Object> hashMap = new HashMap<>(15);
      HashMapDemo hashMapDemo = new HashMapDemo();
      hashMapDemo.setName("66");
      hashMap.put(hashMapDemo,66);


      Object o = hashMap.get(hashMapDemo);
      System.out.println(o);
      hashMapDemo.setName("666");
      //改变这个对象后hashCode改变了
      Object o1 = hashMap.get(hashMapDemo);
      System.out.println(o1);

      Hashtable<String,String> hashtable = new Hashtable<>();
      //直接抛出空指针
//      hashtable.put(null,null);


      HashSet<Object> hashSet = new HashSet<>();
      HashMapDemo hashMapDemo1 = new HashMapDemo();
      hashMapDemo1.setName("11111");
      hashSet.add(hashMapDemo1);
      hashSet.add(hashMapDemo1);
      hashSet.add(hashMapDemo1);
      hashSet.add(hashMapDemo1);
      

      System.out.println(hashSet.size());

  }
}

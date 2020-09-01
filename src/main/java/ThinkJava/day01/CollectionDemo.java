package ThinkJava.day01;

import java.io.PrintStream;
import java.util.*;

import static sun.misc.Version.print;

/**
 * @author yuanxindong
 * @date 2020/7/15 10:12 下午
 */
public class CollectionDemo {
  public static Collection fill(Collection<String> collection) {
    collection.add("dog");
    collection.add("pig");
    collection.add("cat");
    collection.add("dog");
    return collection;
  }

  static Map fill(Map<String, String> map) {
    map.put("rat", "yuanxindong");
    map.put("dog", "liming");
    map.put("pig", "jeff");
    return map;
  }

  public static void main(String[] args) {
    System.out.println(fill(new ArrayList<String>()));
    System.out.println(fill(new LinkedList<String>()));
    System.out.println(fill(new HashMap<String, String>()));
    System.out.println(fill(new TreeSet<String>()));
    System.out.println(fill(new TreeMap<String, String>()));
    System.out.println(fill(new LinkedHashSet<String>()));
    // 截取一段 创建一个新的SubList 进行截取
    fill(new ArrayList<String>());
    List<String> list = new ArrayList<String>();

    System.out.println();
    list.add("1");
    list.add("2");
    list.add("3");
    System.out.println(list);
    boolean b = list.retainAll(Arrays.asList("1"));
    System.out.println(list);

    //

  }
}

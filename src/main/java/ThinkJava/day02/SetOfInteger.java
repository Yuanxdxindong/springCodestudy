package ThinkJava.day02;

import com.sun.codemodel.internal.fmt.JTextFile;
import org.omg.CORBA.INTERNAL;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

/**
 * @author yuanxindong
 * @date 2020/7/16  10:08 下午
 */
public class SetOfInteger {
  public static void main(String[] args)
  {
      Random random = new Random(42);
      HashSet<Integer> hashSet = new HashSet<Integer>();
      for(int i = 0; i< 500;i++) {
          hashSet.add(random.nextInt(25));
//          System.out.println(hashSet);
      }
      TreeSet<Integer> treeSet = new TreeSet<Integer>();

      for(int i = 0; i< 500;i++) {
          treeSet.add(random.nextInt(25));
          System.out.println(treeSet);
      }
      System.out.println(treeSet);

      //
  }
}

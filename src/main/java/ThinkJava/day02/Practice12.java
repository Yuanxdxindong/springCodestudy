package ThinkJava.day02;

import org.omg.CORBA.INTERNAL;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author yuanxindong
 * @date 2020/7/16  8:29 下午
 *
 */
public class Practice12 {
  public static void main(String[] args){
      List<Integer> lists = new ArrayList<Integer>();
      for(int i = 0 ;i<10;i++){
          lists.add(i);
      }
      ListIterator<Integer> integerListIterator = lists.listIterator();
      while (integerListIterator.hasNext()){
          System.out.println(integerListIterator.next());
      }
      List<Integer> lists2 =new ArrayList<Integer>();
      for(int i = 9; i>0;i--){
          lists2.add(lists.get(i));
      }
      //替换
      lists2.set(1,2);
      System.out.println(lists2);

  }
}

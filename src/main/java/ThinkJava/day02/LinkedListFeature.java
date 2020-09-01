package ThinkJava.day02;

import ThinkJava.day01.CollectionDemo;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/**
 * @author yuanxindong
 * @date 2020/7/16  9:19 下午
 */
public class LinkedListFeature {
  public static void main(String[] args) {
      LinkedList<String> linkedList = new LinkedList<String>();
      linkedList = (LinkedList<String>) CollectionDemo.fill(new LinkedList<String>());
      System.out.println(linkedList);
      linkedList.remove();
      System.out.println(linkedList);
      linkedList.listIterator();

      //插入最后一位
      linkedList.addFirst("first");
      System.out.println(linkedList);
      //插入第一位
      linkedList.addLast("last");
      System.out.println(linkedList);
      linkedList.getFirst();
      linkedList.getLast();

      linkedList.peek();
      System.out.println(linkedList);
      //检索第一个元素
      String s = linkedList.peekFirst();
      System.out.println(linkedList);

      //检索最后一个元素
      linkedList.peekLast();
      System.out.println(linkedList);
      // 检索并删除
      String s1 = linkedList.pollFirst();
      System.out.println(s1);
      //addfirst  压入堆栈
      linkedList.push("1");


  }
}

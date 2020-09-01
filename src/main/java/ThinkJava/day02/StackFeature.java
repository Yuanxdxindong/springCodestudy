package ThinkJava.day02;

import ThinkJava.day01.CollectionDemo;

import java.util.Collection;
import java.util.Stack;

/**
 * @author yuanxindong
 * @date 2020/7/16  9:37 下午
 */
public class StackFeature {
  public static void main(String[] args) {
      //java 1.8 中的栈是线程安全的，是通过数组来实现的，继承自Vector
      Stack<String> fill = (Stack<String>) CollectionDemo.fill(new Stack<String>());
      fill.peek();
      fill.peek();
      fill.pop();
      int dog = fill.search("dog");
      System.out.println(dog);
      int capacity = fill.capacity();
      System.out.println(capacity);

      //
  }
}

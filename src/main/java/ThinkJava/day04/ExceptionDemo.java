package ThinkJava.day04;

import java.util.logging.Logger;

/**
 * @author yuanxindong
 * @date 2020/7/22  11:11 下午
 */
public class ExceptionDemo {
  public static void main(String[] args) {
    //
     System.out.println(exceptionMethod());
  }
  public static int  exceptionMethod(){

      try{
          return 1;
//          int i ;
//          Integer a  = null ;
//          i = a;
      }catch (Exception e){
          System.out.println("e");
          return 2;
      }finally{
          return 3;
      }
  }

}

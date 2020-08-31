package java基础;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuanxindong
 * @date: 2020/8/19 13:09
 */
public class StringDemo {
    public static void main(String[] args) throws InterruptedException {
        int i =0;
        Map map = new HashMap<>();
        while (i<10000){
            i++;
            String a = "1";

            //将1放入常量池。
            a.intern();
            map.put("1"+i,a);
            Thread.sleep(100);
        }


        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        System.out.println(s.equals(s2));

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);

        System.out.println(s3.equals(s4));
    }
}

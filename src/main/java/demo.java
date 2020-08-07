import lombok.EqualsAndHashCode;
import test.staticdemo;

import java.util.HashMap;

/**
 * @author yuanxindong
 * @date: 2020/7/29 13:17
 */
@EqualsAndHashCode
public class demo extends demoDad {


    @Override
    public String getName(){
        return  "son";
    }

    public static void main(String[] args) {
        demo demo = new demo();
        System.out.println(demo.getName());
        demoDad demoDad = new demo();
        System.out.println(demoDad.getName());

        demoDad demo2 = new demo();
        if(demo2==demo){
            System.out.println("true");
        }

        if(demo.equals(demo2)){
            System.out.println("true");
        }


        Integer a = 1;
        int b =1;
        System.out.println();
        HashMap h  = new HashMap<>(2);
        h.put(demo,"1");

        h.get(h);

        HashMap  hashMap = new HashMap();

        // String a1 = staticdemo.a;
    }
}

package 算法.String;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yuanxindong
 * @date 2020/9/15  9:17 下午
 */
public class StringToMath {

  public static void main(String[] args) {
      romanToInt("IV");
    //
  }

        public static int romanToInt(String s) {

            if(s.length()<=0){
                return 0;
            }
            char [] chars =  s.toCharArray();
            int sum  = 0;
            int preNum = getValue(chars[0]);
            int num = 0;

            StringBuilder stringBuilder = new StringBuilder();
            Set set = new HashSet<>();
            for(int i = 0 ; i<chars.length; i++){
                num =  getValue(chars[i]);
                if(num <= preNum){
                    sum += num;
                }else if(num > preNum){
                    sum =  num  - preNum;
                }
                preNum = num;
            }
            return sum;
        }

        private static int getValue(char charstr){
            String str =  String.valueOf(charstr);
            if(str.equals("I")){
                return 1;
            } else if(str.equals("V")){
                return  5;
            } else if(str.equals("X")){
                return 10;
            }else if(str.equals("L") ){
                return 50;

            }else if(str.equals("C") ){
                return 100;

            }else if(str.equals("D") ){
                return 500;

            }else if(str.equals("M") ){
                return 1000;

            }
            return 0;


        }
}

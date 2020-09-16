package 算法;

import java.util.Stack;

/**
 * @author yuanxindong
 * @date 2020/9/9  9:21 下午
 */
public class lengthOfLongestSubstring {
  public static void main(String[] args) {
    //
     System.out.println(lengthOfLongestSubstring("abcabcbb"));
  }

    public static int lengthOfLongestSubstring(String s) {
        String result = "";
        if(s==null||s== ""){
            return result.length();
        }

        for(int i = 0; i< s.length();++i){
            int  endIndex = i+1 ;
            while(s.charAt(i) !=  s.charAt(endIndex)){
                endIndex = endIndex+1;
                if(endIndex == s.length()){
                    break;
                }
            }

            String str =  s.substring(i,endIndex-1);

            if(str.length()>result.length()){
                result = str;
            }
        }
        return result.length();
    }
}

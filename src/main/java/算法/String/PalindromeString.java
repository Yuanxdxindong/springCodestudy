package 算法.String;

import java.util.Stack;

/**
 * @author yuanxindong
 * @date 2020/9/11  9:07 下午
 */
public class PalindromeString {
  public static void main(String[] args) {
      //
     System.out.println(CheckPermutation("abc","bca"));
  }

        public static boolean CheckPermutation(String s1, String s2) {
            Stack stack = new Stack();
            char[] char1s = s1.toCharArray();
            for(int i= 0;i< char1s.length;i++){
                stack.push(String.valueOf(char1s[i]));
            }
            StringBuilder  str = new StringBuilder();
            for(int i= 0;i< char1s.length;i++){
                str.append(stack.pop());
            }
            if(str.toString().equals(s2)){
                return true;
            }
            return false;

    }}

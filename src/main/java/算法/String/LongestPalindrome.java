package 算法.String;

/**
 * @author yuanxindong
 * @date 2020/9/15 11:21 下午
 */
public class LongestPalindrome {
  public static void main(String[] args) {
    //
    longestPalindrome("bb");
    System.out.println(isPalindrome(new StringBuilder("bb")));
  }

  public static String longestPalindrome(String s) {

    if (s == null || "".equals(s)) {
      return "";
    }

    char[] chars = s.toCharArray();

    // 边界
    if (s.length() <= 1) {
      return String.valueOf(chars[0]);
    }
    String stringResult = "";

    for (int i = 0; i < chars.length; i++) {
      StringBuilder str = new StringBuilder();
      str.append(chars[i]);
      for (int j = i + 1; j < chars.length; j++) {
        str.append(chars[j]);
        if (isPalindrome(str) && stringResult.length() <= str.length()) {
          stringResult = str.toString();
        }
      }
    }

    return stringResult;
  }

  public static boolean isPalindrome(StringBuilder str) {
    char[] chars = str.toString().toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (!(chars[i] == chars[chars.length - i - 1])) {
        return false;
      }
    }
    return true;
  }
}

package 算法.String;

/**
 * @author yuanxindong
 * @date 2020/9/14 1:39 下午 压缩字符串
 */
public class CompressString {
  public static void main(String[] args) {
    String str = "";
    System.out.println(compressString("aabbcccdd"));
  }


  /**
   * 字符串压缩 aabbcccddd  ->  a2b2c3d3
   * @param str
   * @return
   */
  public static String compressString(String str) {
    if ("".equals(str)) {
      return str;
    }
    StringBuilder stringBuilder = new StringBuilder();
    char[] chars = str.toCharArray();
    stringBuilder.append(chars[0]);
    int count = 1;
    for (int i = 1; i < chars.length; i++) {
      if (chars[i] == chars[i - 1]) {
        count++;
      } else {
        stringBuilder.append(count).append(chars[i]);
        count = 1;
      }
    }
    stringBuilder.append(count);
    return stringBuilder.toString();
  }
}

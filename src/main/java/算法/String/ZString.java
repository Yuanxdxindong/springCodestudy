package 算法.String;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuanxindong
 * @date 2020/9/16 1:08 下午
 */
public class ZString {
  public static void main(String[] args) {
    //
    System.out.println(convert("AB", 3));
  }


    public  static String convert(String s, int numRows) {
      if(numRows < 2) {
        return s;
      }
      List<StringBuilder> rows = new ArrayList<StringBuilder>();
      for(int i = 0; i < numRows; i++) {
        rows.add(new StringBuilder());
      }
      int i = 0, flag = -1;
      for(char c : s.toCharArray()) {
        rows.get(i).append(c);

        //:todo 还得在理解理解   判断是否进入下一列
        if(i == 0 || i == numRows -1) {
          flag = - flag;
        }
        i += flag;
      }


      StringBuilder res = new StringBuilder();
      for(StringBuilder row : rows) {
        res.append(row);
      }
      return res.toString();
    }
}

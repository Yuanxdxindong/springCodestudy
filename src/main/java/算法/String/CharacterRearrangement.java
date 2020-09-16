package 算法.String;

/**
 * @author yuanxindong
 * @date 2020/9/11 9:36 下午
 */
public class CharacterRearrangement {

  public static void main(String[] args) {
    //
//      CheckPermutation("1asdfg","gfdsa1");

      test();
  }

  public static boolean CheckPermutation(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }


    int l1 = s1.length();
    int l2 = s2.length();
    int[] indexs = new int[128];
    for (int i = 0; i < s1.length(); i++) {
      // i位置的元素+1
        char c = s1.charAt(i);
        char c1 = s2.charAt(i);
        int i1 = indexs[c]++;
        System.out.println(i1);
      indexs[c1]--;
    }
    for (int i = 0; i < 128; i++) {
      if (indexs[i] != 0) {
        return false;
      }
    }
    return true;
  }

  public static void test(){
      int [] a = new int[128];
      String b = "abcdefghijklmnopqrstuvwxyz";
      char[] chars = b.toCharArray();
      for(int i =  0; i<  chars.length;i++){
          char aChar = chars[i];
          a[aChar] = 10;
      }

      for(int i = 0; i<128;i++){
         System.out.println(a[i]);
      }

  }

}

package 算法;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

/**
 * @Author:yuanxindong
 * @Date:2020/7/613:20
 */
public class agloem {
    public static void main(String[] args) {
        int [] [] rows = new int[][]{
                        {1,3,1},
                        {1,5,1},
                        {4,2,1}};

        System.out.println(maxValue(rows));
    }
    public static  int maxValue(int[][] grid) {
        int res =0;
        int j ;
        int m = grid.length, n = grid[0].length;
        int[] dp =new int[n+1];
        for(int i = 0;i<m-1;i++){
            for( j = 0 ;j<n-1 ;j++){
                dp[j] = Math.max (dp[j],grid[i][j]);
            }
            res = res + dp[j];
        }
        return  res;


    }
}

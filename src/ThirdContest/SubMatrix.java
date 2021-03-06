package ThirdContest;

import java.util.Scanner;

/**
 * @Classname SubMatrix
 * @Description TODO
 * @Date 2022/1/9 9:13
 * @Created by XJM
 */
/*
    子矩阵问题
    Description
    给定一个矩形区域，每一个位置上都是1或0，求该矩阵中每一个位置上都是1的最大子矩形区域中的1的个数。

    Input
    输入第一行为测试用例个数。每一个用例有若干行，第一行为矩阵行数n和列数m，下面的n行每一行是用空格隔开的0或1。

    Output
    输出一个数值。
     */

public class SubMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int row = sc.nextInt();
            int column = sc.nextInt();
            int [][]matrix = new int[row][column];
            for(int i = 0;i < row;i++){
                for(int j = 0;j < column;j++)
                    matrix[i][j] = sc.nextInt();
            }
            System.out.println(solution(matrix));
        }
    }

    public static int solution(int [][]matrix){
        int n = matrix.length, m = matrix[0].length;
        //横向记录连续1的个数
        int[][] cnt = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    cnt[i][j] = matrix[i][j];
                    continue;
                }
                if (matrix[i][j] == 1) {
                    cnt[i][j] = cnt[i][j - 1] + 1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cnt[j][i] == 0) {
                    continue;
                }
                int count = 0;
                int down = 0;
                while (j + down < n && cnt[j][i] <= cnt[j + down][i]) {
                    count++;
                    down++;
                }
                int up = 0;
                while (j - up >= 0 && cnt[j][i] <= cnt[j - up][i]) {
                    count++;
                    up++;
                }
                res = Math.max(res, cnt[j][i] * (count - 1));
            }
        }
        return res;
    }
}

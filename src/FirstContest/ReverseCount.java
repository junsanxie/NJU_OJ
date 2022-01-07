package FirstContest;

import java.util.Scanner;

/**
 * @Classname reverseCount
 * @Description TODO
 * @Date 2021/12/26 15:44
 * @Created by XJM
 */
 /*
    Description
    有一个由N个实数构成的数组，如果一对元素A[i]和A[j]是倒序的，即i<j但是A[i]>A[j]则称它们是一个倒置，设计一个计算该数组中所有倒置数量的算法。
    要求算法复杂度为O(nlogn)

    Input
    输入有多行，第一行整数T表示为测试用例个数，后面是T个测试用例，每一个用例包括两行，第一行的一个整数是元素个数，第二行为用空格隔开的数组值。

    Output
    输出每一个用例的倒置个数，一行表示一个用例。
     */
public class ReverseCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while ((--t)>=0) {
            int k = scan.nextInt();
            int[] arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = scan.nextInt();
            }
            System.out.println(count(arr));

        }
        scan.close();
    }

    public static int count(int[] arr){
        int res=0;
        int len = arr.length;
        for(int i = 0;i< len ;i++){
            for(int j = i+1;j < len;j++){
                if(arr[i] > arr[j]){
                    res++;
                }
            }
        }
        return res;
    }
}

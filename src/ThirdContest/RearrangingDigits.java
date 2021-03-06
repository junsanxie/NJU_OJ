package ThirdContest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Classname RearrangingDigits
 * @Description TODO
 * @Date 2022/1/9 15:06
 * @Created by XJM
 */
 /*
    数字重组整除问题
    Description
    Babul’s favourite number is 17. He likes the numbers which are divisible by 17.
    This time what he does is that he takes a number N and tries to find the largest number which is divisible by 17, by rearranging the digits.
    As the number increases he gets puzzled with his own task.
    So you as a programmer have to help him to accomplish his task.
    Note: If the number is not divisible by rearranging the digits, then print “Not Possible”. N may have leading zeros.

    Input
    The first line of input contains an integer T denoting the no of test cases. Each of the next T lines contains the number N.

    Output
    For each test case in a new line print the desired output.
     */
public class RearrangingDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-->0){
            char[] nums = sc.nextLine().toCharArray();
            Arrays.sort(nums);
            List<Integer> list = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            boolean[] isVisited = new boolean[nums.length];
            solution(list, nums, sb, isVisited);
            int max = 0;
            for(Integer i:list){
                if(i % 17 == 0 && i>max)
                    max = i;
            }
            if(max == 0){
                System.out.println("Not Possible");
            }else{
                System.out.println(max);
            }
        }
    }

    public static void solution(List<Integer> list, char[] nums, StringBuilder sb, boolean[] isVisited){
        if(sb.length() == nums.length){
            list.add(Integer.parseInt(sb.toString()));
            return;
        }
        for(int i = 0;i < nums.length;i++){
            if(!isVisited[i]){
                sb.append(nums[i]);
                isVisited[i] = true;
                solution(list, nums, sb, isVisited);
                isVisited[i] = false;
                sb.deleteCharAt(sb.length()-1);
                while (i < nums.length - 1 && nums[i] == nums[i+1]){
                    i++;
                }
            }
        }
    }
}

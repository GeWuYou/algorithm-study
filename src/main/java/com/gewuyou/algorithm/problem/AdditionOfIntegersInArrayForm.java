package com.gewuyou.algorithm.problem;

import java.util.LinkedList;
import java.util.List;

/**
 * 989. 数组形式的整数加法
 *
 * @author gewuyou
 * @since 2024-05-12 下午12:50:34
 */
public class AdditionOfIntegersInArrayForm {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new LinkedList<>();
        String kStr = String.valueOf(k);
        int carry = 0;
        int index = kStr.length() - 1;
        for (int i = num.length - 1; i >= 0; i--) {
            int sum;
            if (index >= 0) {
                sum = num[i] + kStr.charAt(index) - '0' + carry;
                index--;
            } else {
                sum = num[i] + carry;
            }
            if (sum >= 10) {
                carry = 1;
                sum -= 10;
            } else {
                carry = 0;
            }
            // result.addFirst(sum);
            result.addFirst(sum);
        }
        // 判断k是否有多余的位数
        while (index >= 0) {
            int sum = kStr.charAt(index) - '0' + carry;
            index--;
            if (sum >= 10) {
                carry = 1;
                sum -= 10;
            } else {
                carry = 0;
            }
            result.addFirst(sum);
        }
        if (carry == 1) {
            result.addFirst(1);
        }
        return result;
        // int n = num.length;
        // int curr = k;
        // List<Integer> result = new LinkedList<>();
        // int i = n - 1;
        // while (i>=0 || curr> 0){
        //     if(i>=0){
        //         curr+=num[i--];
        //     }
        //     result.addFirst(curr%10);
        //     curr/=10;
        // }
        // return result;
    }

    public static void main(String[] args) {
        AdditionOfIntegersInArrayForm solution = new AdditionOfIntegersInArrayForm();
        int[] num = {1};
        int k = 999;
        List<Integer> result = solution.addToArrayForm(num, k);
        System.out.println(result);
    }
}

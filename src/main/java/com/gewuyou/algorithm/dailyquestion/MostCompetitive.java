package com.gewuyou.algorithm.dailyquestion;

import java.util.Stack;

/**
 * 1673. 找出最具竞争力的子序列
 *
 * @author gewuyou
 * @since 2024-05-24 上午11:09:16
 */
public class MostCompetitive {
    public int[] mostCompetitive(int[] nums, int k) {
        int[] result = new int[k];
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() > nums[i] && stack.size() + (n - i) > k) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.push(nums[i]);
            }
        }
        int i = k - 1;
        while (i >= 0) {
            if (!stack.isEmpty()) {
                result[i] = stack.pop();
            }
            i--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 6};
        int k = 2;
        int[] result = new MostCompetitive().mostCompetitive(nums, k);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
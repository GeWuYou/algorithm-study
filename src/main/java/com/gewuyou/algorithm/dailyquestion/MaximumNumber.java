package com.gewuyou.algorithm.dailyquestion;

import java.util.ArrayList;
import java.util.List;

/**
 * 179. 最大数
 *
 * @author gewuyou
 * @since 2024-05-17 下午7:35:13
 */
public class MaximumNumber {
    public String largestNumber(int[] nums) {
        // 构造一个字符串集合
        List<String> list = new ArrayList<>();

        // 遍历数组，将每个数字转换为字符串，并添加到字符串集合中
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        // 按照字符串的字典序进行排序
        list.sort((s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        // 连接字符串集合，得到最大的数字字符串
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        // 去除前导零
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        MaximumNumber solution = new MaximumNumber();
        String result = solution.largestNumber(nums);
        System.out.println(result);
    }
}

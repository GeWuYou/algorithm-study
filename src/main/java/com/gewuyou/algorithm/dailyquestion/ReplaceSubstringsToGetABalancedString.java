package com.gewuyou.algorithm.dailyquestion;

/**
 * 替换子串得到平衡字符串
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName ReplaceSubstringsToGetABalancedString
 * @apiNote </br>
 * @since 2023/2/13 11:46
 */
public class ReplaceSubstringsToGetABalancedString {
    public int balancedString(String s) {
        // 创建数组记录各个字母出现的次数
        int[] ints = new int[4];
        String temp = "QWER";
        // 记录总长度
        int length = s.length();
        // 计算平衡时所需的各字母个数
        int count = length / 4;
        // 遍历集合判断该字符串是否平衡
        for (int i = 0; i < length; ++i) {
            ints[temp.indexOf(s.charAt(i))]++;
        }
        if (ints[0] == count && ints[1] == count && ints[2] == count && ints[3] == count) {
            return 0;
        }
        int result = length;
        // 使用双指针j和i分别维护窗口的左右边界 初始时 j=0
        for (int i = 0, j = 0; i < length; i++) {
            // 从左到右遍历字符串，每次遍历到一个字符串讲该数目减1
            ints[temp.indexOf(s.charAt(i))]--;
            // 开始移动左边界判断 i - j 之外的字符出现次数是否小于所需字母个数
            while (j <= i && ints[0] <= count && ints[1] <= count && ints[2] <= count && ints[3] <= count) {
                // 更新答案，选择长度最小的子串答案
                result = Math.min(result, i - j + 1);
                // 移动左边界，将左边界处的字符纳入数组的判断范围
                ints[temp.indexOf(s.charAt(j++))]++;
            }
        }
        return result;
    }


}

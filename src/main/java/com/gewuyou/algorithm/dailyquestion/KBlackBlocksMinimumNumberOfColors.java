package com.gewuyou.algorithm.dailyquestion;

/**
 * 得到 K 个黑块的最少涂色次数
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName KBlackBlocksMinimumNumberOfColors
 * @apiNote </br>
 * @since 2023/3/9 12:46
 */
public class KBlackBlocksMinimumNumberOfColors {
    public int minimumRecolors(String blocks, int k) {
        // 定义结果
        int result = 0;
        int currResult = 0;
        // 定义窗口前边界
        int start = 0;
        // 初始化窗口
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                currResult++;
            }
        }
        result = currResult;
        for (int i = k; i < blocks.length(); i++) {
            // 判断出界元素是否为W
            if (blocks.charAt(start) == 'W') {
                currResult--;
            }
            // 判断进入元素是否为W
            if (blocks.charAt(i) == 'W') {
                currResult++;
            }
            // 移动窗口
            start++;
            // 判断当前次数是否小于结果次数
            result = Math.min(result, currResult);
        }
        return result;
    }
}

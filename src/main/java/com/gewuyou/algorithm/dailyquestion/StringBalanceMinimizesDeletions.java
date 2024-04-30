package com.gewuyou.algorithm.dailyquestion;

/**
 * 字符串平衡的最少删除次数
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName StringBalanceMinimizesDeletions
 * @apiNote </br>
 * @since 2023/3/6 12:24
 */
public class StringBalanceMinimizesDeletions {
    public int minimumDeletions(String s) {
        // 三种情况 全部为a 全部为b 前面全部为a后面全部为b
        // 划分分界线 向左删除b 向右删除a
        int leftb = 0;
        int righta = 0;
        // 遍历字符串计算右边全部的a
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a'){
                righta++;
            }
        }
        // 创建变量接收结果
        int result = righta;
        // 进行第二次遍历，开始划分
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if(temp == 'a'){
                righta--;
            }else {
                leftb++;
            }
            result = Math.min(result, righta+leftb);
        }
        return result;
    }
}

package com.gewuyou.algorithm.dailyquestion;

/**
 * 有效时间的数目
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName NumberOfValidTimes
 * @apiNote </br>
 * @since 2023/5/9 20:44
 */
public class NumberOfValidTimes {
    /**
     * 方法二：分开枚举
     * 思路与算法
     * 由于题目中小时和分钟的限制不同，因此没有必要枚举所有可能的数字，由于小时和分钟限制如下：
     * “00"≤hh≤“23"；“00"≤mm≤“59"；
     * 我们检测所有符合当前字符串 time 匹配的小时 hh 的数目为 countHour，
     * 同时检测检测所有符合当前字符串 time 匹配的分钟 hh 的数目为 countMinute，
     * 则合法有效的时间数目为 countHour×countMinute。
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/number-of-valid-clock-times/solution/you-xiao-shi-jian-de-shu-mu-by-leetcode-j7gqz/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param time
     * @return
     */
    public int countTime(String time) {
        // 得到 0-23 能匹配上的小时数，0-59 能匹配上的 分钟数，返回 二者的乘积
        char ha = time.charAt(0), hb = time.charAt(1), ma = time.charAt(3), mb = time.charAt(4);
        return cnt(ha, hb, 24) * cnt(ma, mb, 60);
    }

    /**
     * 统计 "ha hb" 能匹配 [0,hex-1] 中几个数字
     * @param ha
     * @param hb
     * @param hex
     * @return
     */
    private int cnt(char ha, char hb, int hex) {
        int ans = 0;
        // 枚举 [0,hex-1] 每个数字
        for (int i = 0; i < hex; ++i) {
            // 得到高位和低位
            int a = i / 10, b = i % 10;
            // 判断 ha。hb 是否 能够匹配 a、b
            if ((ha == '?' || ha == a + '0') && (hb == '?' || hb == b + '0')) {
                // 匹配成功，ans++
                ans++;
            }
        }
        return ans;
    }
}

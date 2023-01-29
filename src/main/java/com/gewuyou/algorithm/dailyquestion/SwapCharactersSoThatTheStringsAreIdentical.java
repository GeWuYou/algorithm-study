package com.gewuyou.algorithm.dailyquestion;

/**
 * 交换字符使得字符串相同
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName SwapCharactersSoThatTheStringsAreIdentical
 * @apiNote </br>
 * @since 2023/2/25 10:28
 */
public class SwapCharactersSoThatTheStringsAreIdentical {
    public int minimumSwap(String s1, String s2) {
        int length = s1.length();
        if (length == 1) {
            return s1.equals(s2) ? 0 : -1;
        }
        int xy = 0;
        int yx = 0;
        int result = 0;
        // 示例1：可以通过一次交换，使得xy或yx的值减少2。示例2：可以通过两次交换，使得xy和yx的值各减少1。
        for (int i = 0; i < length; i++) {
            if (s1.charAt(i) == 'x' && s2.charAt(i) == 'y') {
                xy++;
            } else if (s1.charAt(i) == 'y' && s2.charAt(i) == 'x') {
                yx++;
            }
        }
        // 当xy与yx的和为奇数时无法达到目的
        if (((yx + xy) & 1) == 1) {
            return -1;
        }
        // 先使用交换一次让xy或者yx减少两次
        while (xy > 1 || yx > 1) {
            if (xy > 1) {
                xy -= 2;
                result++;
            }
            if (yx > 1) {
                yx -= 2;
                result++;
            }
        }
        // 当xy与yx都为1时可以使用第二种方法进行消去
        if(xy==yx&&xy==1){
            result+=2;
            xy--;
            yx--;
        }
        // 再使用交换两次，让xy或者yx减少一次
        while (xy > 0 || yx > 0) {
            if (xy > 0) {
                xy--;
                result += 2;
            }
            if (yx > 0) {
                yx--;
                result += 2;
            }
        }
        return result;
    }
}

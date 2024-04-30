package com.gewuyou.algorithm.dailyquestion;

/**
 * 回环句
 *
 * @author GeWuYou
 * @version V1.0.0
 * @apiNote </br>
 * @since 2023/6/30 11:06
 */
public class LoopbackSentences {
    public boolean isCircularSentence(String sentence) {
        String[] strings = sentence.split(" ");
        char start;
        char end = strings[0].charAt(strings[0].length() - 1);
        for (int i = 1; i < strings.length; i++) {
            start = strings[i].charAt(0);
            if (start!= end) {
                return false;
            }
            end = strings[i].charAt(strings[i].length() - 1);
        }
        start = strings[0].charAt(0);
        return start== end;
    }
}

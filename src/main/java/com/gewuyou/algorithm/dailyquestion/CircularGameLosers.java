package com.gewuyou.algorithm.dailyquestion;

import java.util.ArrayList;

/**
 * 循环游戏输家
 *
 * @author GeWuYou
 * @version V1.0.0
 * @apiNote </br>
 * @since 2023/8/16 11:37
 */
public class CircularGameLosers {
    public int[] circularGameLosers(int n, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        boolean[] friends = new boolean[n];
        for (int i = k, j = 0; !friends[j]; i += k) {
            friends[j] = true;
            j = (j + i) % n;
        }
        for (int i = 0; i < n; i++) {
            if (!friends[i]) {
                result.add(i + 1);
            }
        }
        int []answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}

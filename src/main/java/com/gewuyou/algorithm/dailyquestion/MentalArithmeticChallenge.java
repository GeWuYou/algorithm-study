package com.gewuyou.algorithm.dailyquestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LCP 40. 心算挑战
 *
 * @author gewuyou
 * @since 2024-08-01 上午10:24:04
 */
public class MentalArithmeticChallenge {
    public int maxmiumScore(int[] cards, int cnt) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        Arrays.sort(cards);
        int n = cards.length;
        for (int i = n - 1; i >= 0; i--) {
            if ((cards[i] & 1) == 0) {
                even.add(cards[i]);
            } else {
                odd.add(cards[i]);
            }
        }
        int maxSum = 0;
        // 前缀和数组，用于快速计算任意前缀的和
        int[] evenPrefix = new int[even.size() + 1];
        int[] oddPrefix = new int[odd.size() + 1];
        for (int i = 1; i <= even.size(); i++) {
            evenPrefix[i] = evenPrefix[i - 1] + even.get(i - 1);
        }
        for (int i = 1; i <= odd.size(); i++) {
            oddPrefix[i] = oddPrefix[i - 1] + odd.get(i - 1);
        }
        // 枚举选择的奇数卡牌的数量
        for (int oddCount = 0; oddCount <= cnt; oddCount++) {
            int evenCount = cnt - oddCount;
            if (oddCount <= odd.size() && evenCount <= even.size() && (oddCount & 1) == 0) {
                int currSum = evenPrefix[evenCount] + oddPrefix[oddCount];
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MentalArithmeticChallenge m = new MentalArithmeticChallenge();
        int[] cards = {9, 5, 9, 1, 6, 10, 3, 4, 5, 1};
        System.out.println(m.maxmiumScore(cards, 2));
    }
}

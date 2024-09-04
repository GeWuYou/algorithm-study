package com.gewuyou.algorithm.dailyquestion;

/**
 * 2024. 考试的最大困扰度
 *
 * @author gewuyou
 * @since 2024-09-04 09:05:53
 */
public class BiggestProblemWithTheExam {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int ans = 0;
        int n = answerKey.length();
        for (int r = 0, l = 0, t = 0, f = 0; r < n; r++) {
            if (answerKey.charAt(r) == 'T') t++;
            else f++;
            while (Math.min(t, f) > k) {
                if (answerKey.charAt(l) == 'T') t--;
                else f--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}

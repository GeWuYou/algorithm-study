package com.gewuyou.algorithm.dailyquestion;

/**
 * 522. 最长特殊序列 II
 *
 * @author gewuyou
 * @since 2024-06-17 下午12:47:22
 */
public class LongestSpecialSequenceII {
    public int findLUSlength(String[] strs) {
       int n = strs.length;
       int result = -1;
        for (int i = 0; i < n; i++) {
            boolean check = true;
            for (int j = 0; j < n; j++) {
                if(i!=j&&isSubseq(strs[i],strs[j])){
                    check = false;
                    break;
                }
            }
            if(check){
                result = Math.max(result,strs[i].length());
            }
        }
        return result;
    }

    public boolean isSubseq(String s, String t) {
        int left = 0, right = 0;
        int sLength = s.length();
        int tLength = t.length();
        while (left < sLength && right < tLength) {
            if (s.charAt(left) == t.charAt(right)) {
                left++;
            }
            right++;
        }
        return left == sLength;
    }
    public static void main(String[] args) {
        LongestSpecialSequenceII solution = new LongestSpecialSequenceII();
        // String[] strs = {"a","b","c","d","e","f","a","b","c","d","e"};
        String[] strs = {"aaa","aaa","aa"};
        int result = solution.findLUSlength(strs);
        System.out.println(result);
    }
}

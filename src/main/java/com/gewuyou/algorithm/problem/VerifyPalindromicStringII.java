package com.gewuyou.algorithm.problem;

/**
 * 680. 验证回文串 II
 *
 * @author gewuyou
 * @since 2024-04-27 下午2:00:08
 */
public class VerifyPalindromicStringII {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        int count = 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // 尝试删除左边或右边的字符
                // 如果没机会了直接返回false
                if (count == 0) {
                    return false;
                }
                count--;
                // 尝试删除左边的字符
                if (s.charAt(left + 1) == s.charAt(right)) {
                    if(validPalindrome(s,left+1,right)){
                        return true;
                    }
                }
                if (s.charAt(left) == s.charAt(right - 1)) {
                    return validPalindrome(s,left,right-1);
                }
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
    public boolean validPalindrome(String s,int left,int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
              return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        VerifyPalindromicStringII solution = new VerifyPalindromicStringII();
        String s = "lcuppucul";
        System.out.println(solution.validPalindrome(s));
    }
}

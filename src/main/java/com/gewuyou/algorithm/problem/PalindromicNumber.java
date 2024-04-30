package com.gewuyou.algorithm.problem;

/**
 * 回文数
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName PalindromicNumber
 * @apiNote </br>
 * @since 2023/4/1 20:54
 */
public class PalindromicNumber {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int start = 0;
        int end = s.length()-1;
        while (start<=end){
            if(s.charAt(start)==s.charAt(end)){
                start++;
                end--;
            }else {
                return false;
            }
        }
        return true;
    }
}

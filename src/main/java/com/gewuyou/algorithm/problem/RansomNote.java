package com.gewuyou.algorithm.problem;

/**
 * 383. 赎金信
 *
 * @author gewuyou
 * @since 2024-04-13 上午10:33:09
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            count[magazine.charAt(i) - 'a']++;
        }
        char[] ransomNoteArray = ransomNote.toCharArray();
        for (char c : ransomNoteArray) {
            int index = c - 'a';
            if (count[index] == 0) {
                return false;
            }
            count[index]--;
        }
        return true;
    }
}

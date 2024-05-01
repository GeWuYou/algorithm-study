package com.gewuyou.algorithm.problem;

/**
 * 917. 仅仅反转字母
 *
 * @author gewuyou
 * @since 2024-05-08 下午12:37:06
 */
public class JustInvertTheLetters {
    public String reverseOnlyLetters(String s) {
        StringBuilder sb = new StringBuilder();
        char[] array = s.toCharArray();
        int left = 0, right = array.length - 1;
        while (left < right) {
            while (left < right && !Character.isLetter(array[left])) {
                left++;
            }
            while (left < right && !Character.isLetter(array[right])) {
                right--;
            }
            if (left < right) {
                char temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
        return new String(array);
    }
}

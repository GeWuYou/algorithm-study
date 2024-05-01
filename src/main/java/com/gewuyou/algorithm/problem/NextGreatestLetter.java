package com.gewuyou.algorithm.problem;

/**
 * 744. 寻找比目标字母大的最小字母
 *
 * @author gewuyou
 * @since 2024-05-01 上午11:01:01
 */
public class NextGreatestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        int length = letters.length;
        if (target >= letters[length - 1]) {
            return letters[0];
        }
        int low = 0, high = length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (letters[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return letters[low];
    }

    public static void main(String[] args) {
            char[] letters = {'c', 'f', 'j'};
            char target = 'g';
            NextGreatestLetter solution = new NextGreatestLetter();
            char result = solution.nextGreatestLetter(letters, target);
            System.out.println(result);
    }
}

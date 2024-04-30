package com.gewuyou.algorithm.problem;

class GuessGame {
    protected int guess(int num) {
        return 0;
    }
}

/**
 * 374. 猜数字大小
 *
 * @author gewuyou
 * @since 2024-04-13 上午10:24:54
 */
public class GuessSizeOfNumber extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int guess = guess(mid);
            switch (guess) {
                case 0:
                    return mid;
                case -1:
                    right = mid - 1;
                    break;
                case 1:
                    left = mid + 1;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + guess);
            }
        }
        return -1;
    }
}

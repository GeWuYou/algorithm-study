package com.gewuyou.algorithm.dailyquestion;

/**
 * 交换一次的先前排列
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName PreviousPermutationThatIsSwappedOnce
 * @apiNote </br>
 * @since 2023/4/3 13:34
 */
public class PreviousPermutationThatIsSwappedOnce {
    public int[] prevPermOpt1(int[] arr) {
        int length = arr.length;
        int currMax = -1;
        int index = -1;
        boolean hasResult = false;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                for (int j = i + 1; j < length; j++) {
                    if (arr[j] < arr[i]) {
                        hasResult = true;
                        if (currMax < arr[j]) {
                            currMax = arr[j];
                            index = j;
                        }
                    }
                }
                if (hasResult) {
                    int temp = arr[i];
                    arr[i] = arr[index];
                    arr[index] = temp;
                    return arr;
                }
            }
        }
        return arr;
    }
}

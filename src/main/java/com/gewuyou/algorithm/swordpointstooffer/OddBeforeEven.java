package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 奇于偶前
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName OddBeforeEven
 * @apiNote </br>
 * @since 2023/1/30 17:19
 */
public class OddBeforeEven {
    public static int[] exchange(int[] nums) {
        // 奇数指针
        int oddPointer = 0;
        // 偶数指针
        int evenPointer = nums.length - 1;
        while (oddPointer < evenPointer) {
            if ((nums[oddPointer] & 1) == 1) {
                oddPointer++;
            } else if ((nums[evenPointer] & 1) != 1) {
                evenPointer--;
            } else {
                // 交换奇数与偶数位置
                int temp = nums[oddPointer];
                nums[oddPointer] = nums[evenPointer];
                nums[evenPointer] = temp;
            }
        }
        return nums;
    }
}

package com.gewuyou.algorithm.dailyquestion;

/**
 * 2970. 统计移除递增子数组的数目 I
 *
 * @author gewuyou
 * @since 2024-07-10 上午9:19:32
 */
public class IncremovableSubarrayCount {
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int res = 0;
        int l = 1;
        while (l < n && nums[l - 1] < nums[l]) {
            l++;
        }
        res += l + (l < n ? 1 : 0);
        for (int r = n - 2; r >= 0; r--) {
            while (l >0 && nums[l - 1] >=nums[r + 1] ) {
                l--;
            }
            res += l + (l <= r ? 1 : 0);
            if (nums[r] >= nums[r + 1]) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,4};
        IncremovableSubarrayCount solution = new IncremovableSubarrayCount();
        int result = solution.incremovableSubarrayCount(nums);
        System.out.println(result);
    }
}

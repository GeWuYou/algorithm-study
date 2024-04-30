package com.gewuyou.algorithm.dynamicprogramming;

/**
 * 打家劫舍
 *
 * @author GeWuYou
 * @version V1.0.0
 * @apiNote </br>
 * @since 2023/6/28 11:35
 */
public class Rob {
    public int rob(int[] nums) {
        /*
        如果房屋的数量大于两间，对于偷到第n间房时，你存在两个选项：
            1、当你偷了上一间房之后，你就无法偷当前的
            2、当你偷当前房间，说明你偷的收益为上上间房间加上当前房间的收益
            状态转移方程 f(k) = max(f(k-2)+nums[k],f(k-1))
        */
        int n = nums.length;
        // 首先判断房屋数量
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        // k-2间
        int prev = nums[0];
        // k-1间
        int curr =Math.max(nums[1],nums[0]);
        for (int i = 2; i < n; i++) {
            // 判断偷当前房间的收益高还是偷上一间房间的收益高
            int temp = Math.max(prev+nums[i],curr);
            prev = curr;
            curr = temp;
        }
        return curr;
    }
}

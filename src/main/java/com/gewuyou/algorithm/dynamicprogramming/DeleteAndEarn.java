package com.gewuyou.algorithm.dynamicprogramming;

/**
 * 删除并获得点数
 *
 * @author GeWuYou
 * @version V1.0.0
 * @apiNote </br>
 * @since 2023/6/29 14:58
 */
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        // 判断元素数量
        if(n==1){
            return nums[0];
        }
        // 构造索引数组
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int [] all = new int[max+1];
        // 记录对应数字的数目
        for (int num : nums) {
            all[num]++;
        }
        int pPrev = 0;
        int prev = 0;
        /*
            如果数字数量大于1时，当你选择了一个数字i时，需要删除i-1与i+1
            本题存在数字i重复的情况，因此
            转移方程为f(k) = max(f(i-1),f(i-2)+i*all[i])
        */
        for (int i = 1; i <= max; i++) {
            int temp = Math.max(prev,pPrev+all[i]*i);
            pPrev = prev;
            prev =temp;
        }
        return prev;
    }
}

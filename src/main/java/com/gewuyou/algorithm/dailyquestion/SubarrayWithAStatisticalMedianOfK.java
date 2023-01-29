package com.gewuyou.algorithm.dailyquestion;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计中位数为 K 的子数组
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName SubarrayWithAStatisticalMedianOfK
 * @apiNote </br>
 * @since 2023/3/16 12:03
 */
public class SubarrayWithAStatisticalMedianOfK {
    public int countSubarrays(int[] nums, int k) {
        int lengh = nums.length;
        int kIndex = 0;
        while(nums[kIndex]!=k){
            kIndex++;
        }
        int result = 0;
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(0, 1);
        int sum = 0;
        for(int i =0;i<lengh;i++){
            sum+=sign(nums[i],k);
            if(i<kIndex){
                counts.put(sum,counts.getOrDefault(sum,0)+1);
            }
            else{
                int pre0 =  counts.getOrDefault(sum,0);
                int pre1 = counts.getOrDefault(sum-1,0);
                result+=(pre0+pre1);
            }
        }
        return result;
    }
    public int sign(int x,int k){
        if(x==k){
            return 0;
        }
        return x>k?1:-1;
    }
}

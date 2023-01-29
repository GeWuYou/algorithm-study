package com.gewuyou.algorithm.problem;

/**
 * 移除元素
 *
 * @author gewuyou
 * @since 2024-04-05 下午2:01:14
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        /*
            思路：
            我们维护一个新长度，它从0开始自增，遍历原数组，如果当前元素不是我们要移除的元素就将
            它放在nums[length]的位置，然后长度自增，因为我们后续超出新长度的元素可以不管因此不用关心后续
            [3,2,2,3,5,6,3,7] val = 3
            执行代码后是这样的
            [2,2,5,6,7,6,3,7]
         */
       int length = 0;
       for (int i = 0; i < nums.length; i++) {
           if(nums[i] != val) {
               nums[length++] = nums[i];
           }
       }
       return length;
    }
}

package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 数组中的逆序对
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName ReverseOrderPairsInAnArray
 * @apiNote </br>
 * @since 2023/3/1 12:19
 */
public class ReverseOrderPairsInAnArray {
    public int reversePairs(int[] nums) {
        int length = nums.length;
        int[] auxiliary = new int[length];
        return mergeSort(nums, auxiliary, 0, length - 1);

    }

    private int mergeSort(int[] nums, int[] auxiliary, int start, int end) {
        // 终止条件
        if (start >= end) {
            return 0;
        }
        // 划分数组
        int mid = (start + end) / 2;
        // 递归调用计算结果
        int result = mergeSort(nums, auxiliary, start, mid) + mergeSort(nums, auxiliary, mid + 1, end);
        // 合并数组
        if (end + 1 - start >= 0) {
            System.arraycopy(nums, start, auxiliary, start, end + 1 - start);
        }
        // 使用双指针指向左右子数组的首元素
        int i = start;
        int j = mid + 1;
        for (int k = start; k <= end; k++) {
            // 当i=mid+1时：代表左子数组已合并完，因此添加右子数组当前元素 auxiliary[j]并执行j++
            if (i == mid + 1) {
                nums[k] = auxiliary[j++];
            }
            // 当j=end+1时，代表右子数组已合并完，因此添加左子数组当前元素 auxiliary[i]并执行i++
            // 或当auxiliary[i]<=auxiliary[j]时，添加左子数组当前元素auxiliary[i]并执行i++
            else if (j == end + 1 || auxiliary[i] <= auxiliary[j]) {
                nums[k] = auxiliary[i++];
            } else {
                nums[k] = auxiliary[j++];
                result += mid - i + 1;
            }

        }
        return result;
    }


}

package com.gewuyou.algorithm.problem;

/**
 * X的算术平方根
 *
 * @author gewuyou
 * @since 2024-04-05 下午3:59:16
 */
public class XSqrt {
    /**
     * 我们首先检查x是否为0，如果是0，则返回0。
     * 然后，我们使用二分查找来寻找平方根。我们在[left, right]范围内进行查找，其中left的初始值为1，right的初始值为x。
     * 在每次迭代中，我们计算mid的平方并与x进行比较。
     * 如果mid的平方等于x，则找到了平方根，返回mid。
     * 如果mid的平方小于x，则说明平方根在[mid+1, right]范围内，更新left为mid+1。
     * 如果mid的平方大于x，则说明平方根在[left, mid-1]范围内，更新right为mid-1。
     * 最后，当left大于right时，查找结束，返回right作为平方根的整数部分。
     * 这种方法的时间复杂度是O(logx)，可以有效地处理大数。
     *
     * @param x
     * @return int
     * @apiNote
     * @since 2024/4/5 下午4:19
     */
    public int mySqrt(int x) {
        // 返回特殊情况
        if (x == 0) {
            return 0;
        }
        // 设置二分
        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid == x / mid) {  // 防止乘法溢出
                return mid;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;  // 返回right而不是left，因为题目要求返回的是整数部分
    }
}

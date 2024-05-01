package com.gewuyou.algorithm.problem;

/**
 * 寻找第K大
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName FindTheKLargest
 * @apiNote </br>
 * @since 2023/1/9 19:51
 */
public class FindTheKLargest {
    /**
     * 寻找第K大
     *
     * @param a 数组
     * @param n 数组长度
     * @param K 第K大
     * @return int
     * @apiNote
     * @since 2023/1/9 19:52
     */
    public int findKth(int[] a, int n, int K) {
        if (n == 0) {
            return -1;
        }
        return QuickSort(a, 0, n - 1, K);
    }

    /**
     * 使用快速排序返回第K大的元素
     *
     * @param array 待排数组
     * @param start 排序上界
     * @param end   排序下界
     * @param K     第K大
     * @return int 第K大的元素
     * @apiNote
     * @since 2023/1/9 20:02
     */
    public int QuickSort(int[] array, int start, int end, int K) {
        // 划分
        int pivot = Partition(array, start, end);
        // 判断枢轴距离第K大的位置
        // 当前枢轴恰好为第K大
        if (end - pivot + 1 == K) {
            return array[pivot];
        }
        // 如果枢轴位于第K大的左边，向右快排
        else if (end - pivot + 1 > K) {
            return QuickSort(array, pivot + 1, end, K);
        }
        // 如果枢轴位于第K大右边，向左快排
        else {
            // 注意向左快排时式子end - pivot + 1的值为大于K的元素的数量
            // 比如2 4 6 8 9 end = 4 pivot = 3 K=4，得出的结果为2，说明包括枢轴，右边有两个值都大于第K大值所以需要让K减去该值
            return QuickSort(array, start, pivot - 1, K - (end - pivot + 1));
        }
    }

    /**
     * 划分方法
     *
     * @param array 待划分数组
     * @param start 划分上界
     * @param end   划分下界
     * @return int 划分之后枢轴所在的最终位置
     * @apiNote 返回划分之后的枢轴位置
     * @since 2023/1/9 20:04
     */
    private int Partition(int[] array, int start, int end) {
        // 以第一个元素作为枢轴
        int pivot = array[start];
        // 使用while循环找出枢轴的最终位置
        while (start < end) {
            while (start < end && array[end] >= pivot) {
                // 如果右边的值大于枢轴，则移动索引
                end--;
            }
            // 如果右边的值比枢轴小移动到左端
            array[start] = array[end];
            while ((start < end && array[start] <= pivot)) {
                // 如果左边的值小于枢轴则，移动索引
                start++;
            }
            // 如过左边的值比枢轴大移动到右端
            array[end] = array[start];
        }
        // 最后空出来的start的位置则是现在枢轴元素应该存在的位置，将该枢轴元素赋值给该位置
        array[start] = pivot;
        // 返回枢轴所在的位置，以便下一次划分
        return start;
    }
}

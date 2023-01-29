package com.gewuyou.algorithm.sort;

/**
 * 快速排序：存在BUG
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName Quick
 * @apiNote 稳定性：快速排序需要一个基准值，在基准值的右侧找一个比基准值小的元素，在基准值的左侧找一个比基准值大的元素，然后交换这两个元素，此时会破坏稳定性，所以快速排序是一种不稳定的算法。
 * @since 2022/9/11 17:31
 */
public class Quick extends Sort {
    /**
     * 对数组array进行排序
     *
     * @param array 待排序数组
     * @apiNote 快速排序 从小到大排
     * @since 2022/9/11 17:35
     */
    public static void sort(Comparable[] array) {
        // 1、初始化两个索引
        int start = 0;
        // ! 注意索引尾端只能到array.length - 1
        int end = array.length - 1;
        // 2、调用重载的sort方法进行排序
        sort(array, start, end);
    }

    /**
     * 对数组array中从索引start处到索引end之间的元素进行排序
     *
     * @param array 待排序数组
     * @param start 索引1
     * @param end   索引2
     * @apiNote 快速排序 从小到大排
     * @since 2022/9/11 17:34
     */
    public static void sort(Comparable[] array, int start, int end) {
        // 1、安全性校验
        if (end <= start) {
            return;
        }
        // 2、需要对数值中start索引到end索引处的元素进行分组 分别分为左子组和右子组
        // 调用分组方法过后返回的值为分界值所在的索引，分界值位置变换之后的索引
        int partitionIndex = partition(array, start, end);
        // 3、分别让左子组和右子组有序
        // ! 注意索引起始
        // 3.1、让左子组有序
        sort(array, start, partitionIndex - 1);
        // 3.2、让右子组有序
        sort(array, partitionIndex + 1, end);
    }

    /**
     * 对数组array中从索引start到end之间的元素进行分组，并返回分组界限对应的索引值
     *
     * @param array 待排序数组
     * @param start 索引1
     * @param end   索引2
     * @return int
     * @apiNote
     * @since 2022/9/11 17:38
     */
    public static int partition(Comparable[] array, int start, int end) {
        // 1、确定分界值
        Comparable key = array[start];
        // 2、定义两个指针,分别指向待切分元素的最小索引处和最大索引处的下一个位置
        int left = start;
        int right = end + 1;
        // 3、切分
        while (true) {
            // 4、先从从右往左扫描，移动right指针。找到一个比分界值小的值，停止
            while (greater(array[--right], key)) {
                if (right == left) {
                    break;
                }
            }
            // 5、接着从左往右扫描，移动left指针，找到一个比分界值大的值，停止
            while (greater(key, array[++left])) {
                if (left == right) {
                    break;
                }
            }
            // 判断left>=right，如果是则退出循环
            if (left >= right) {
                break;
            } else {
                // 6、反之则交换两个位置的索引
                exchange(array, left, right);
            }
        }
        // 7、当循环结束时，两个指针将停在中间位置交换分界值与中间值 所以这里填right和left都一样
        exchange(array, start, left);
        // 8、返回当前分界点索引(中间值所对应的索引)
        return left;
    }
    /**
     * 快速排序
     *
     * @param array 待排数组
     * @param start 排序上界
     * @param end   排序下界
     * @apiNote
     * @since 2023/1/9 20:02
     */
    public static void  QuickSort(int[] array, int start, int end) {
        // 递归终止条件
        if(start<end){
            // 划分
            int pivot = Partition(array, start, end);
            QuickSort(array, start, pivot-1);
            QuickSort(array, pivot+1,end);
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
    private static int Partition(int[] array, int start, int end) {
        // 以第一个元素作为枢轴
        int pivot = array[start];
        // 使用while循环找出枢轴的最终位置
        while (start<end){

            while (start<end&&array[end]>=pivot){
                // 如果右边的值大于枢轴，则移动索引
                end--;
            }
            // 如果右边的值比枢轴小移动到左端
            array[start] = array[end];
            while ((start<end&&array[start]<=pivot)){
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

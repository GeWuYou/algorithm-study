package com.gewuyou.algorithm.sort;

/**
 * 堆排序类
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName HeapSort
 * @apiNote 通过对堆进行排序的方法
 * @since 2022/9/2 14:41
 */
public class HeapSort {

    /**
     * 元素比较
     *
     * @param heap 堆
     * @param i    索引i
     * @param j    索引j
     * @return boolean
     * @apiNote 判断堆中索引处i的元素是否小于索引j处的元素
     * @since 2022/9/2 14:44
     */
    private static boolean less(Comparable[] heap, int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    /**
     * 元素交换
     *
     * @param heap 堆
     * @param i    索引i
     * @param j    索引j
     * @apiNote 交换堆中i索引与j索引处的值
     * @since 2022/9/2 14:47
     */
    private static void exch(Comparable[] heap, int i, int j) {
        Comparable temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    /**
     * 根据数组构造堆
     *
     * @param source 源数组
     * @param heap   堆
     * @apiNote 根据源数组source，构造出堆heap
     * @since 2022/9/2 14:49
     */
    private static void createHeap(Comparable[] source, Comparable[] heap) {
        // 把source中的元素拷贝到heap中
        System.arraycopy(source, 0, heap, 1, source.length);
        // 对堆中的元素做下沉调整(从长度的一半处开始往索引1处扫描
        for (int i = heap.length / 2; i > 0; i--) {
            // 注意由于堆中0位不存储元素，所以扩容了一位，但是长度要比原来的大一所以要-1比如存11个数，但是数组长度是12
            sink(heap, i, heap.length - 1);
        }
    }

    /**
     * source数组排序
     *
     * @param source 源数组
     * @apiNote 对source数组中的数据进行从小到大排序
     * @since 2022/9/2 14:51
     */
    public static void sort(Comparable[] source) {
        // 头节点不使用
        Comparable[] heap = new Comparable[source.length + 1];
        // 构建堆
        createHeap(source, heap);
        // 定义一个变量记录未排序的元素中最大的索引 为什么减一? 因为数组统计长度是从0开始导致要比实际长度大1(堆中0不储存元素)
        int maxIndex = heap.length - 1;
        // 当 maxIndex!=1 时终止
        while (maxIndex != 1) {
            // 通过循环交换1索引处和未排序的元素中最大的索引
            exch(heap, 1, maxIndex);
            // 排除交换后最大元素所在的索引，让它不要参与堆的下沉
            maxIndex--;
            // 需要对索引1处的元素进行堆下沉调整
            sink(heap, 1, maxIndex);
        }
        // 将heap中的数据赋值到源数组
        System.arraycopy(heap, 1, source, 0, source.length);


    }

    /**
     * 下沉元素
     *
     * @param head   堆
     * @param target 目标位置
     * @param range  最大范围
     * @apiNote 在heap堆中，对target处的元素做下沉，范围是0~range
     * @since 2022/9/2 14:54
     */

    private static void sink(Comparable[] head, int target, int range) {
        int maxIndex;
        //通过循环不断的对比当前节点和其左子节点2*k和右子节点2*k+1中的较大值节点
        while (2 * target <= range) {
            // 判断是否有右子节点
            if (2 * target + 1 <= range) {
                // 获取当前节点的子节点中的较大节点
                maxIndex = less(head, 2 * target, 2 * target + 1) ? 2 * target + 1 : 2 * target;
            } else {
                // 如果没有右节点，默认左边节点为最大的节点
                maxIndex = 2 * target;
            }
            // 比较当前节点与其子节点中较大节点的值
            if (!less(head, target, maxIndex)) {
                // 当前节点值比较大子节点要大，没有必要比较了，直接返回
                return;
            } else {
                // 当前节点值比较大子节点要小，交换当前节点与较大子节点的值
                exch(head, target, maxIndex);
                // 变换索引值 为下一循环作准备
                target = maxIndex;
            }
        }
    }
}

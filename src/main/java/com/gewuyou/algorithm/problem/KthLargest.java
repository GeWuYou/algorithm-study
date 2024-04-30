package com.gewuyou.algorithm.problem;

import java.util.PriorityQueue;

/**
 * 703. 数据流中的第 K 大元素
 *
 * @author gewuyou
 * @since 2024-04-29 下午1:44:44
 */
public class KthLargest {
    private final int k;
    private PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for (int x : nums) {
            add(x);
        }
    }

    public int add(int val) {
       pq.offer(val);
       if(pq.size()>k){
           pq.poll();
       }
       return pq.peek();
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}

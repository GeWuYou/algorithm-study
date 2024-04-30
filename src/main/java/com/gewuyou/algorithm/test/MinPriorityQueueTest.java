package com.gewuyou.algorithm.test;

import com.gewuyou.datastructures.priority.MinPriorityQueue;

public class MinPriorityQueueTest {

    public static void main(String[] args) {

        //创建最小优先队列对象
        MinPriorityQueue<String> queue = new MinPriorityQueue<String>(10);
        //往队列中存数据
        queue.insert("G");
        queue.insert("F");
        queue.insert("E");
        queue.insert("D");
        queue.insert("C");
        queue.insert("B");
        queue.insert("A");

        //通过循环获取最小优先队列中的元素
        while(!queue.isEmpty()){
            String min = queue.deleteMin();
            System.out.print(min+" ");
        }

    }
}

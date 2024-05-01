package com.gewuyou.algorithm.problem;

import java.util.Arrays;

/**
 * 1046. 最后一块石头的重量
 *
 * @author gewuyou
 * @since 2024-05-15 上午11:19:19
 */
public class WeightOfTheLastStone {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 0) {
            return 0;
        }
        for (int i = 0; i < stones.length-1; i++) {
            Arrays.sort(stones);
            int diff = stones[stones.length - 1] - stones[stones.length - 2];
            stones[stones.length - 1] = diff;
            stones[stones.length - 2] = 0;
        }
        return stones[stones.length - 1];
        // List<Integer> stonesList = new LinkedList<>(Arrays.stream(stones).boxed().toList());
        // stonesList.sort((a, b) -> b - a);
        //
        // while (stonesList.size() > 1) {
        //     int diff = stonesList.get(0) - stonesList.get(1);
        //     stonesList.removeFirst();
        //     stonesList.removeFirst();
        //     if (diff != 0) {
        //         if (stonesList.isEmpty()) {
        //             stonesList.add(diff);
        //             break;
        //         }
        //         boolean isFound = false;
        //         // 将新石头找到一个合适的位置
        //         for (int size = stonesList.size() - 1; size >= 0; size--) {
        //             if (diff <= stonesList.get(size)) {
        //                 stonesList.add(size+1, diff);
        //                 isFound = true;
        //                 break;
        //             }
        //         }
        //         if (!isFound) {
        //             stonesList.addFirst(diff);
        //         }
        //     }
        //
        // }
        // return stonesList.isEmpty() ? 0 : stonesList.get(0);
    }

    public static void main(String[] args) {
        int[] stones = {9, 10, 4, 5, 7, 1};
        System.out.println(new WeightOfTheLastStone().lastStoneWeight(stones));
    }
}

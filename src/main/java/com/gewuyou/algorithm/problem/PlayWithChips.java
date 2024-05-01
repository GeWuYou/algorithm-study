package com.gewuyou.algorithm.problem;

/**
 * 1217. 玩筹码
 *
 * @author gewuyou
 * @since 2024-05-20 下午12:48:29
 */
public class PlayWithChips {
    public int minCostToMoveChips(int[] position) {
        int oddCount = 0;
        int evenCount = 0;
        for (int i = 0; i < position.length; i++) {
            if((position[i]&1)==0){
                evenCount++;
            }else{
                oddCount++;
            }
        }

        return Math.min(evenCount, oddCount);
    }
}

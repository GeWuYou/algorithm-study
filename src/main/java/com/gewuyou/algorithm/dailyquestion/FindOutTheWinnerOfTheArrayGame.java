package com.gewuyou.algorithm.dailyquestion;

import java.util.LinkedList;
import java.util.List;

/**
 * 1535. 找出数组游戏的赢家
 *
 * @author gewuyou
 * @since 2024-05-19 上午9:37:52
 */
public class FindOutTheWinnerOfTheArrayGame {
    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        List<Integer> list = new LinkedList<>();
        for (int i : arr) {
            list.add(i);
        }
        int count = 0;
        int winner = -1;
        while (count < k) {
            int currentWinner;
            int contestants1 = list.get(0);
            int contestants2 = list.get(1);
            if (contestants1 > contestants2) {
                currentWinner = contestants1;
                list.remove(1);
                list.add(contestants2);
            } else {
                currentWinner = contestants2;
                list.removeFirst();
                list.addLast(contestants1);
            }
            if (currentWinner != winner) {
                winner = currentWinner;
                count = 0;
            }
            count++;
            if(count>n){
                return winner;
            }
        }
        return winner;
    }
}

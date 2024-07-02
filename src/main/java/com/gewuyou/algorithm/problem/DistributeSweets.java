package com.gewuyou.algorithm.problem;

import java.util.Arrays;

/**
 * 135. 分发糖果
 *
 * @author gewuyou
 * @since 2024-07-27 上午9:56:31
 */
public class DistributeSweets {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int res = 0;
        int[] candy = new int[n];
        Arrays.fill(candy, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            // 如果当前孩子的评分比后一个孩子高，并且当前孩子的糖果数不比后一个孩子多，
            // 则调整当前孩子的糖果数，使其比后一个孩子多一个。
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
        }
        for (int i : candy) {
            res += i;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ratings = {1, 2, 87, 87, 87, 2, 1};
        DistributeSweets ds = new DistributeSweets();
        int res = ds.candy(ratings);
        System.out.println(res);
    }
}

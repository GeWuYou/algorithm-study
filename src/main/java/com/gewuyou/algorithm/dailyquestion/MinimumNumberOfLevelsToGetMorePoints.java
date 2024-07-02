package com.gewuyou.algorithm.dailyquestion;

/**
 * 3096. 得到更多分数的最少关卡数目
 *
 * @author gewuyou
 * @since 2024-07-19 上午10:18:34
 */
public class MinimumNumberOfLevelsToGetMorePoints {
    public int minimumLevels(int[] possible) {
       int n = possible.length;
       int sum =0;
        for (int i : possible) {
            sum += i==1 ? 1 : -1;
        }
        int pre = 0;
        for (int i = 0; i < n-1; i++) {
            pre += possible[i] ==1 ? 1 : -1;
            if(2*pre > sum){
                return i+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumNumberOfLevelsToGetMorePoints solution = new MinimumNumberOfLevelsToGetMorePoints();
        System.out.println(solution.minimumLevels(new int[]{1,0,1,0}));
    }
}

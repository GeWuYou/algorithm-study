package com.gewuyou.algorithm.problem;

/**
 * 892. 三维形体的表面积
 *
 * @author gewuyou
 * @since 2024-05-07 下午6:14:51
 */
public class SurfaceAreaOfA3DBody {
    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        int area = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int level = grid[i][j];
                // 判断此位置是否有正方体组成的柱体
                if(level>0){
                    // 一个柱体：2个底面+所有的正方体都贡献了4个侧表面积
                    area+=(level*4)+2;
                    // 减去i与i-1相贴的两份表面积
                    area-=i>0?Math.min(level,grid[i-1][j])*2:0;
                    // 减去j与j-1相贴的两份表面积
                    area-=j>0?Math.min(level,grid[i][j-1])*2:0;
                }
            }
        }
        return area;
    }
}

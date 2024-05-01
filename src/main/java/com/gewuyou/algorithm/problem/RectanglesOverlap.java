package com.gewuyou.algorithm.problem;

/**
 * 836. 矩形重叠
 *
 * @author gewuyou
 * @since 2024-05-04 上午11:07:45
 */
public class RectanglesOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(
                // 左下角 0~1 右上角 2~3
                // 如果矩形1的右上角小于等于矩形2的左下角
                rec1[2] <= rec2[0] ||
                        rec1[3] <= rec2[1] ||
                        // 或者矩形1的左下角大于等于矩形2的右上角
                        rec1[0] >= rec2[2] ||
                        rec1[1] >= rec2[3]);
        // 则不可能是矩形，对此情况取反即可
    }
}

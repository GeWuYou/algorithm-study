package com.gewuyou.algorithm.problem;

/**
 * 733. 图像渲染
 *
 * @author gewuyou
 * @since 2024-04-30 下午12:44:57
 */
public class ImageRendering {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if (oldColor == color) {
            return image;
        }
        dfs(image, sr, sc, oldColor, color);
        return image;
    }


    private void dfs(int[][] image, int r, int c, int oldColor, int newColor) {

        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c]!= oldColor) {
            return;
        }
        image[r][c] = newColor;
        dfs(image, r + 1, c, oldColor, newColor);
        dfs(image, r - 1, c, oldColor, newColor);
        dfs(image, r, c + 1, oldColor, newColor);
        dfs(image, r, c - 1, oldColor, newColor);
    }
}

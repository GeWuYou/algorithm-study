package com.gewuyou.algorithm.problem;

/**
 * 661. 图片平滑器
 *
 * @author gewuyou
 * @since 2024-04-27 下午12:31:32
 */
public class PictureSmoother {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                int count = 0;
                for (int k = i - 1; k <= i + 1; k++) {
                    for (int l = j - 1; l <= j + 1; l++) {
                        if(k<0 || k>=m || l<0 || l>=n){
                            continue;
                        }
                        sum += img[k][l];
                        count++;
                    }
                }
                res[i][j] = sum / count;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PictureSmoother pictureSmoother = new PictureSmoother();
        int[][] img = {{100, 200, 100}, {200, 50, 200}, {100, 200, 100}};
        int[][] res = pictureSmoother.imageSmoother(img);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}

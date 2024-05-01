package com.gewuyou.algorithm.problem;

/**
 * 832. 翻转图像
 *
 * @author gewuyou
 * @since 2024-05-04 上午10:55:49
 */
public class FlipTheImage {
    /**
     * 对于前后需要交换的两位，
     * 若相等，则最后结果为反转后结果，如 1,1 交换-> 1,1 反转-> 0,0
     * 若不等，则最后结果为自己本身，如 1,0 交换-> 0,1 反转-> 1,0
     * 另外，我们可通过与 1进行异或运算，将数进行反转，即 x = x^1
     * 如: x=1时，1^1 = 0， x=0，0^1 = 1。
     */
    public int[][] flipAndInvertImage(int[][] image) {
        int rows = image.length;
        int cols = image[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0, r = cols - 1; j <= r; j++, r--) {
                if (image[i][j] == image[i][r]) {
                    image[i][j] ^= 1;
                    image[i][r] = image[i][j];
                }
            }
        }
        return image;
    }
}

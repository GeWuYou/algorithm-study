package com.gewuyou.algorithm.test;

import com.gewuyou.datastructures.array.SparseArray;

/**
 * 稀疏数组测试
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName SparseArrayTest
 * @apiNote 棋盘问题
 * @since 2022/9/13 20:18
 */
public class SparseArrayTest {
    public static void main(String[] args) {
        // 1、创建一个原始的二维数组 11*11
        int[][] chessArray = new int[11][11];
        // 2、0 表示没有棋子，1 表示黑子，2 表示白子
        // 棋盘的1,2处有一个黑子
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        // 3、输出原始二维数组
        System.out.println("=================原始的二维数组=================");
        for (int[] row : chessArray) {
            for (int chess : row) {
                System.out.printf("%d\t",chess);
            }
            System.out.println("||");
        }
        System.out.println("=================原始的二维数组=================");
        // 4、将二维数组转成稀疏数组
        SparseArray sparseArray = new SparseArray();
        // 5、打印稀疏数组
        sparseArray.save(chessArray);
        int[][] load = sparseArray.load();
        sparseArray.show(load);
        int[][] convert = sparseArray.convert(chessArray);
        sparseArray.show(convert);
        // 6、将稀疏数组转换为二维数组
        int[][] unconvert = sparseArray.unconverted(convert);
        // 7、打印二维数组
        sparseArray.show(unconvert);

    }
}

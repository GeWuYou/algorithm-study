package com.gewuyou.datastructures.array;



import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * 稀疏数组
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName SparseArray
 * @apiNote 二维数组转稀疏数组思路思路：<p>1、遍历原始的二维数组。得到有效数据的个数sum</p><p>2、根据sum就可以创建稀疏数组sparseArray int [sum+1] [3]并赋值</p><p> 3、将二维数组的有效数据存入到稀疏数组并写入磁盘</p>
 * 稀疏数组转二维数组思路：<p>1、先从磁盘读取稀疏数组的第一行(因为第一行为稀疏数组的基本信息，总行数。总列数。元素总个数)，根据第一行数组创建原始的数组</p> <p>2、楷书读取稀疏数组后几行的数据并赋值给原始二维数组</p>
 * @since 2022/9/13 19:57
 */
@Slf4j
public class SparseArray {

    /**
     * 二维数组转稀疏数组
     *
     * @param array 二维数组
     * @return com.gewuyou.datastructures.array.SparseArray 稀疏数组
     * @apiNote 将一个二维数组转换为一个稀疏数组
     * @since 2022/9/13 20:30
     */
    public int[][] convert(int[][] array) {
        // 创建稀疏数组大小
        int num = 0;
        // 统计总行数
        int row = 0;
        // 统计总循环次
        int count = 0;
        // 1、遍历原始的二维数组。得到有效数据的个数sum
        for (int[] rows : array) {
            row++;
            for (int number : rows) {
                if (number != 0) {
                    num++;
                }
                count++;
            }
        }
        // 2、根据sum就可以创建稀疏数组sparseArray int [sum+1] [3]

        //创建一个稀疏数组
        int[][] sparseArray = new int[num + 1][3];
        // 3、给稀疏数组赋值
        // 总行数
        sparseArray[0][0] = row;
        // 总列数
        if (row == 0) {
            log.error("一个严重的错误：总行数不能为0！！");
            return sparseArray;
        }
        sparseArray[0][1] = count / row;
        // 有效值的数目
        sparseArray[0][2] = num;
        // 遍历
        // 设置计数器
        int counter = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < count / row; j++) {
                if (array[i][j] != 0) {
                    counter++;
                    sparseArray[counter][0] = i;
                    sparseArray[counter][1] = j;
                    sparseArray[counter][2] = array[i][j];
                }
            }
        }
        return sparseArray;
    }

    /**
     * 稀疏数组转二维数组
     *
     * @param sparseArray 传入的稀疏数组
     * @apiNote 将稀疏数组进行转换返回二维数组
     * @since 2022/9/13 22:02
     */
    public int[][] unconverted(int[][] sparseArray) {
        //1、读取稀疏数组
        // 读取总行数
        int row = sparseArray[0][0];
        // 读取总列数
        int col = sparseArray[0][1];
        // 创建一个二维数组
        int[][] array = new int[row][col];
        // 将数据写回二维数组
        for (int i = 1; i < sparseArray.length; i++) {
            array[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        return array;
    }

    /**
     * 打印二维数组
     *
     * @apiNote
     * @since 2022/9/13 22:19
     */
    public void show(int[][] array) {
        log.info("=================解析的数组=================");
        for (int[] row : array) {
            for (int chess : row) {
                System.out.printf("%d\t", chess);
            }
            System.out.println();
        }
        log.info("=================解析的数组=================");
    }

    /**
     * 保存二维数组
     *
     * @param array 二维数组
     */
    public void save(int[][] array) {
        // 转换二维数组
        int[][] convert = convert(array);
        try (
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("resource\\map.data"))
        ) {
            for (int[] ints : convert) {
                bufferedWriter.write(ints[0] + " " + ints[1] + " " + ints[2]);
                // 换行
                bufferedWriter.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 载入上次的二维数组
     *
     * @apiNote
     * @since 2022/9/14 9:30
     */
    public int[][] load() {
        // 声明接收数组
        int[][] temp = null;
        // 创建标记
        boolean flag = true;
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader("resource\\map.data"))
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // 切割当行数据
                String[] str = line.split(" ");
                if (flag) {
                    // 创建接收数组
                    temp = new int[Integer.parseInt(str[0])][Integer.parseInt(str[1])];
                    flag = false;
                } else {
                    // 行
                    int row = Integer.parseInt(str[0]);
                    // 列
                    int col = Integer.parseInt(str[1]);
                    // 数据
                    int data = Integer.parseInt(str[2]);
                    // 赋值
                    temp[row][col] = data;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

}


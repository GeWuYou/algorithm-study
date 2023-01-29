package com.gewuyou.algorithm.problem;


import lombok.extern.slf4j.Slf4j;

/**
 * 八皇后问题
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName EightQueensProblem
 * @apiNote 算法题：八皇后问题
 * </br>
 * @since 2022/10/21 13:06
 */
@Slf4j
public class EightQueensProblem {

    /**
     * 计数器，记录有多少个解法
     */
    private int count = 0;

    /**
     * 该数组记录皇后位置
     */
    private final int[] queenAddress = {0, 4, 7, 5, 2, 6, 1, 3};


    /**
     * 放置第n个皇后
     *
     * @param n 第n个皇后
     * @apiNote
     * @since 2022/10/21 18:08
     */
    private void check(int n) {

        /*
          定义一个数组表示有多少个皇后
         */
        int queenMax = 8;

        // 设置返回条件 八个皇后已经放好了
        if(n== queenMax){
            count++;
            print();
            return;
        }
        // 如果没有，则依次放入皇后并检查其是否冲突
        for (int i = 0; i < queenMax; i++) {
            // 先把当前的皇后 n 放到该行的第一列
            queenAddress[n] = i;
            // 判断当放置第n个皇后到i列时是否冲突
            if(judge(n)){
                // 说明冲突，接着放,即开始递归
                check(n+1);
            }
            //如果冲突，则开始回溯，继续执行循环将皇后放到下一个索引处的位置
        }
    }


    /**
     * 检测该皇后是否和前面已经摆放的皇后冲突
     *
     * @param n 表示第n个皇后
     * @return boolean
     * @apiNote 查看当我们摆放第n个皇后是否冲突
     * @since 2022/10/21 17:41
     */
    private boolean judge(int n) {

        // 使用for循环检测该皇后是否和之前的皇后冲突
        for (int i = 0; i < n; i++) {
            /* 1、queenAddress[i] == queenAddress[n]判断位置是否为同列
             * 2、Math.abs(n-i) == Math.abs(queenAddress[n] - queenAddress[i]) 表示判断第n个皇后是否和第i个皇后是否在同一斜线
             * 3、数组索引与皇后数量的关系为index+1
             * 4、在棋盘里面如果两个棋子在同一条斜线上那么他们两行相减的值和列相减的值肯定一样的
             * 5、没有必要判断二者在同一行。因为n是递增的
             */
            if (queenAddress[i] == queenAddress[n] || Math.abs(n - i) == Math.abs(queenAddress[n] - queenAddress[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 将皇后摆放的位置输出
     *
     * @apiNote
     * @since 2022/10/21 17:39
     */
    private void print() {
        for (int address : queenAddress) {
            System.out.print(address + " ");
        }
        System.out.println();
        log.info("第{}种解",count);
    }

    public static void main(String[] args) {
        // 测试问题
        EightQueensProblem eightQueensProblem = new EightQueensProblem();
        eightQueensProblem.check(0);
    }


}

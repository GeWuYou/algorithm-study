package com.gewuyou.algorithm.problem;

import lombok.extern.slf4j.Slf4j;

/**
 * 迷宫问题
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName MazeProblem
 * @apiNote 使用递归解决迷宫问题
 * </br>
 * @since 2022/10/20 10:38
 */
@Slf4j
public class MazeProblem {

    /**
     * 目标点x
     */
    private final int x;

    /**
     * 目标点y
     */
    private final int y;

    /**
     * 通路
     */
    private static final int PATH = 2;

    public MazeProblem(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 策略枚举
     */
    enum Tactics {
        UP, DOWN, LEFT, RIGHT
    }

    private int[][] setWay(int[][] map, int i, int j, Tactics tactics) {
        if (tactics == Tactics.UP) {
            setWayByUp(map, i, j);
        } else if (tactics == Tactics.DOWN) {
            setWayByDown(map, i, j);
        } /*else if (tactics == Tactics.LEFT) {
            setWayByUp(map, i, j);
        } else if (tactics == Tactics.RIGHT) {
            setWayByUp(map, i, j);
        }*/
        return map;


    }

    /**
     * 寻路算法
     *
     * @param map 地图
     * @param i   起始位置 - 行
     * @param j   起始位置 - 列
     * @return boolean 是否找到
     * @apiNote 约定：</br>
     * 1、当map[i][j] 为0 表示该点没有走过。当为1 表示墙 而2 为有效通路 3 表示该点已经走过，但是走不通 出发点 P(i，j)</br>
     * 2、在走迷宫时，需要确定一个策略(方法) 上->右->下->左
     * @since 2022/10/20 12:25
     */
    private boolean setWayByDown(int[][] map, int i, int j) {
        // 表明已经走到头了
        if (i >= map.length || j >= map[0].length) {
            return false;
        }
        // 如果通路已经找到
        if (map[x][y] == PATH) {
            return true;
        } else {
            // 如果当前这个点还没有走过
            if (map[i][j] == 0) {
                // 按照 下->右->上->左 的策略走
                // 先假定这个点为有效通路
                map[i][j] = 2;
                // 在该点的基础上向下走
                if (setWayByDown(map, i + 1, j)) {
                    // 如果能走通，返回true
                    return true;
                } else if (setWayByDown(map, i, j + 1)) {
                    // 向右走
                    return true;
                } else if (setWayByDown(map, i - 1, j)) {
                    // 向上走
                    return true;
                } else if (setWayByDown(map, i, j - 1)) {
                    // 向左走
                    return true;
                } else {
                    // 说明该点四周为死路
                    map[i][j] = 3;
                    return false;
                }
            } else {
                // 如果map[i][j] ！= 0 可能为 1 2 3
                // 1 表明为墙，直接返回 2 表明走过了，直接返回， 3 表明表明死路，走不通
                return false;
            }
        }
    }

    /**
     * 寻路算法
     *
     * @param map 地图
     * @param i   起始位置 - 行
     * @param j   起始位置 - 列
     * @return boolean 是否找到
     * @apiNote 约定：</br>
     * 1、当map[i][j] 为0 表示该点没有走过。当为1 表示墙 而2 为有效通路 3 表示该点已经走过，但是走不通 出发点 P(i，j)</br>
     * 2、在走迷宫时，需要确定一个策略(方法) 下->右->上->左
     * @since 2022/10/20 12:25
     */
    private boolean setWayByUp(int[][] map, int i, int j) {
        // 表明已经走到头了
        if (i >= map.length || j >= map[0].length) {
            return false;
        }
        // 如果通路已经找到
        if (map[x][y] == PATH) {
            return true;
        } else {
            // 如果当前这个点还没有走过
            if (map[i][j] == 0) {
                // 按照 上->右->下->左 的策略走
                // 先假定这个点为有效通路
                map[i][j] = 2;
                // 在该点的基础上向上走
                if (setWayByUp(map, i - 1, j)) {
                    // 如果能走通，返回true
                    return true;
                } else if (setWayByUp(map, i, j + 1)) {
                    // 向右走
                    return true;
                } else if (setWayByUp(map, i + 1, j)) {
                    // 向下走
                    return true;
                } else if (setWayByUp(map, i, j - 1)) {
                    // 向左走
                    return true;
                } else {
                    // 说明该点四周为死路
                    map[i][j] = 3;
                    return false;
                }
            } else {
                // 如果map[i][j] ！= 0 可能为 1 2 3
                // 1 表明为墙，直接返回 2 表明走过了，直接返回， 3 表明表明死路，走不通
                return false;
            }
        }
    }

    private void printMap(int[][] map) {
        // 输出地图
        log.info("迷宫地图：宽：{}，高：{}", map.length, map[0].length);
        for (int[] ints : map) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int[][] map = new int[8][7];
        // 使用1 表示墙
        // 将上下置为1
        for (int i = 0; i < map[0].length; i++) {
            map[0][i] = 1;
            map[map.length - 1][i] = 1;
        }
        // 将左右置为1
        for (int i = 0; i < map.length; i++) {
            map[i][0] = 1;
            map[i][map[0].length - 1] = 1;
        }
        // 创建迷宫问题解决模型
        MazeProblem mazeProblem = new MazeProblem(6, 5);

        // 设置挡板。用1表示
        map[3][1] = 1;
        map[3][2] = 1;
        /*
        map[1][4] = 1;
        map[2][4] = 1;
        map[3][4] = 1;

        map[5][3] = 1;
        map[5][4] = 1;
        map[5][5] = 1;*/
        mazeProblem.printMap(map);
        mazeProblem.setWay(map, 1, 1, Tactics.UP);
        mazeProblem.printMap(map);
        mazeProblem.setWay(map, 1, 1, Tactics.DOWN);
        mazeProblem.printMap(map);
    }
}

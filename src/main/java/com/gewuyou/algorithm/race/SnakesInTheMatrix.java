package com.gewuyou.algorithm.race;

import java.util.List;

/**
 * Q1. 矩阵中的蛇
 *
 * @author gewuyou
 * @since 2024-08-11 10:30:57
 */
public class SnakesInTheMatrix {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = (i * n) + j;
            }
        }
        int x = 0;
        int y = 0;
        // 0: up, 1: right, 2: down, 3: left
        int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (String command : commands) {
            switch (command) {
                case "UP":
                    x += direction[0][0];
                    y += direction[0][1];
                    break;
                case "RIGHT":
                    x += direction[1][0];
                    y += direction[1][1];
                    break;
                case "DOWN":
                    x += direction[2][0];
                    y += direction[2][1];
                    break;
                case "LEFT":
                    x += direction[3][0];
                    y += direction[3][1];
                    break;
                default:
                    break;
            }
        }
        return grid[x][y];
    }

    public static void main(String[] args) {
        SnakesInTheMatrix s = new SnakesInTheMatrix();
        int n = 3;
        List<String> commands = List.of("DOWN","RIGHT","UP");
        int result = s.finalPositionOfSnake(n, commands);
        System.out.println(result);
    }
}

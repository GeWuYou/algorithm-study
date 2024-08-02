package com.gewuyou.algorithm.dailyquestion;

/**
 * 3127. 构造相同颜色的正方形
 *
 * @author gewuyou
 * @since 2024-08-31 09:19:40
 */
public class ConstructSquaresOfTheSameColor {
    public boolean canMakeSquare(char[][] grid) {
        int n = grid.length;
        int equalsCount;
        int unequalsCount;
        int[][] direction = {{0, 1}, {1, 0}, {1, 1}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                equalsCount=0;
                unequalsCount=0;
                char c = grid[i][j];

                for (int k = 0; k < 3; k++) {
                    int x = i + direction[k][0];
                    int y = j + direction[k][1];
                    if (x < 0 || x >= n || y < 0 || y >= n) {
                        continue;
                    }
                    if (grid[x][y] == c) {
                        equalsCount++;
                    }else {
                        unequalsCount++;
                    }

                }
                if (equalsCount >= 2||unequalsCount ==3) {
                    return true;
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] grid = {{'B','W','B'},{'W','B','W'},{'B','W','B'}};
        ConstructSquaresOfTheSameColor solution = new ConstructSquaresOfTheSameColor();
        System.out.println(solution.canMakeSquare(grid));
    }
}

package com.gewuyou.algorithm.dailyquestion;

/**
 * 困于环中的机器人
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName RobotTrappedInARing
 * @apiNote </br>
 * @since 2023/4/11 8:46
 */
public class RobotTrappedInARing {
    public static boolean isRobotBounded(String instructions) {
        // 方向数组 东南西北
        boolean[] direct = new boolean[]{false, false, false, true};
        // 记录此时方位
        int index = 3;
        // 位置数组
        int[][] location = new int[][]{{0, 0}};
        // 解析操作
        int length = instructions.length();
        // 循环四次检查是否存在环路
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < length; j++) {
                // 直走
                if (instructions.charAt(j) == 'G') {
                    // 东
                    if (direct[0]) {
                        location[0][0]++;
                    }
                    // 南
                    else if (direct[1]) {
                        location[0][1]--;
                    }
                    // 西
                    else if (direct[2]) {
                        location[0][0]--;
                    }
                    // 北
                    else if (direct[3]) {
                        location[0][1]++;
                    }
                }
                // 转向 向左或者向右
                else if (instructions.charAt(j) == 'L') {
                    // 变换当前方向
                    direct[index] = false;
                    index--;
                    // 如果index向左越界将其指针移到最右边
                    if (index < 0) {
                        index = 3;
                    }
                    direct[index] = true;
                } else if (instructions.charAt(j) == 'R') {
                    // 变换当前方向
                    direct[index] = false;
                    index++;
                    // 如果index向右越界将其指针移到最左边
                    if (index > 3) {
                        index = 0;
                    }
                    direct[index] = true;
                }

            }
        }
        // 判断此时机器人是否在原来位置
        if (location[0][0] != 0) {
            return false;
        }
        if (location[0][1] != 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String location = "GL";
        System.out.println(isRobotBounded(location));
    }
}

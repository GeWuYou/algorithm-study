package com.gewuyou.algorithm.problem;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 657. 机器人能否返回原点
 *
 * @author gewuyou
 * @since 2024-04-26 下午2:03:44
 */
public class WhetherTheRobotCanReturnToItsOrigin {
    public boolean judgeCircle(String moves) {
        char[] array = moves.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : array) {
            if (c == 'U') {
                map.put(c, map.getOrDefault(c, 0) + 1);
            } else if (c == 'D') {

                map.put(c, map.getOrDefault(c, 0) + 1);
            } else if (c == 'L') {

                map.put(c, map.getOrDefault(c, 0) + 1);
            } else if (c == 'R') {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        return Objects.equals(map.getOrDefault('U', 0), map.getOrDefault('D', 0))
                && Objects.equals(map.getOrDefault('L', 0), map.getOrDefault('R', 0));
    }

    public static void main(String[] args) {

        WhetherTheRobotCanReturnToItsOrigin solution = new WhetherTheRobotCanReturnToItsOrigin();
        System.out.println(solution.judgeCircle("UD"));
        System.out.println(solution.judgeCircle("LL"));
        System.out.println(solution.judgeCircle("RRDD"));
    }
}

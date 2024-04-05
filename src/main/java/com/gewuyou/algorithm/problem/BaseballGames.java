package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 682. 棒球比赛
 *
 * @author gewuyou
 * @since 2024-04-28 下午3:12:22
 */
public class BaseballGames {
    public int calPoints(String[] operations) {
        int result = 0;
        List<Integer> list = new ArrayList<>();
        for (String operation : operations) {
            if ("C".equals(operation)) {
                list.remove(list.size() - 1);
                continue;
            }
            if ("D".equals(operation)) {
                list.add(list.get(list.size() - 1) * 2);
                continue;
            }
            if ("+".equals(operation)) {
                list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
                continue;
            }
            int num = Integer.parseInt(operation);
            list.add(num);
        }
        for (Integer i : list) {
            result += i;
        }
        return result;

    }
}

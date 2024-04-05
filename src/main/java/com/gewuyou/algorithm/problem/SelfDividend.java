package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 728. 自除数
 *
 * @author gewuyou
 * @since 2024-04-30 下午12:32:12
 */
public class SelfDividend {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            String str = String.valueOf(i);
            boolean flag = true;
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == '0' || i % (c - '0') != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SelfDividend selfDividend = new SelfDividend();
        List<Integer> result = selfDividend.selfDividingNumbers(1, 10000);
        System.out.println(result);
    }
}


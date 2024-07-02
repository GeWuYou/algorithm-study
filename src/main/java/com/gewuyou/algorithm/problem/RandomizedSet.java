package com.gewuyou.algorithm.problem;

import java.util.HashSet;
import java.util.Set;

/**
 * 随机集
 *
 * @author gewuyou
 * @since 2024-07-26 下午12:34:29
 */
public class RandomizedSet {
    private final Set<Integer> set;

    public RandomizedSet() {
        set = new HashSet<>();
    }

    public boolean insert(int val) {
        if (set.contains(val)) {
            return false;
        } else {
            set.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if (set.contains(val)) {
            set.remove(val);
            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        int index = (int) (Math.random() * set.size());
        int i = 0;
        for (Integer integer : set) {
            if (i == index) {
                return integer;
            }
            i++;
        }
        return -1;
    }
}
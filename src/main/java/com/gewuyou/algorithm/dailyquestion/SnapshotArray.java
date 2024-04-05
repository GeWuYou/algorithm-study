package com.gewuyou.algorithm.dailyquestion;

import java.util.*;

/**
 * 1146. 快照数组
 *
 * @author gewuyou
 * @since 2024-04-26 上午8:56:29
 */
public class SnapshotArray {
    // 数组快照
   private TreeMap<Integer, Integer>[] data;
    int snap_id;
    public SnapshotArray(int length) {
        data = new TreeMap[length];
        Arrays.setAll(data, e -> new TreeMap<>());
        snap_id = 0;
    }

    public void set(int index, int val) {
        data[index].put(snap_id, val);
    }

    public int snap() {
        return snap_id++;
    }

    public int get(int index, int snap_id) {
        Map.Entry<Integer, Integer> entry = data[index].floorEntry(snap_id);
        return entry == null? 0 : entry.getValue();
    }
}

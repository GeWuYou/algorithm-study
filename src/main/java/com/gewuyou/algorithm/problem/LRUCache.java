package com.gewuyou.algorithm.problem;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 *
 * @author gewuyou
 * @since 2024-05-10 下午7:25:00
 */
class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        // 使用访问顺序，即根据最近访问的顺序进行排序
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

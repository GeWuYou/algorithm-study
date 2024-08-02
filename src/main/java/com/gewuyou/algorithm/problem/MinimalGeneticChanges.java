package com.gewuyou.algorithm.problem;

import java.util.*;

/**
 * 433. 最小基因变化
 *
 * @author gewuyou
 * @since 2024-08-05 上午9:36:31
 */
public class MinimalGeneticChanges {
    public int minMutation(String startGene, String endGene, String[] bank) {
        // 首先将bank中的所有字符串加入集合中，其实我感觉list,set都是可以的但还是使用set算了，避免有重复的字符串
        Set<String> set = new HashSet<>();
        // 创建一个集合保存遍历过的字符串，防止重复进入队列，超出时间限制
        Set<String>  visited = new HashSet<>();
        // 将bank中的字符串加入到set中
        Collections.addAll(set, bank);

        // 创建一个数组记录A C G T
        char[] gen = {'A', 'C', 'G', 'T'};

        // 判断bank中是否含有end如果没有直接返回-1
        if (!set.contains(endGene)) {
            return -1;
        }

        // 创建一个队列来进行广度优先遍历
        Queue<String> queue = new LinkedList<>();

        // 将起始字符串入队列
        queue.offer(startGene);

        // 设置一个变量来记录广度优先遍历的层数
        int size = 0;
        // 进行广度优先遍历
        while (!queue.isEmpty()) {
            int count = queue.size();
            size++;
            // 按层数将队列中的元素依次遍历
            for (int i = 0; i < count; i++) {
                String temp = queue.poll();
                // 将temp转化为数组方便改变其中的字母
                char[] temp1;
                if (temp != null) {
                    temp1 = temp.toCharArray();
                } else {
                    continue;
                }
                // 将temp中的每个元素依次改变
                for (int j = 0; j < temp.length(); j++) {
                    // 保存当前位置的字母，方便一会复原
                    char c = temp1[j];
                    // 依次使用每个基因代替该节点
                    for (int k = 0; k < 4; k++) {
                        temp1[j] = gen[k];
                        String temp2 = new String(temp1);
                        //    如果找到目标字符串直接返回size
                        if (temp2.equals(endGene)) {
                            return size;
                        }
                        if (set.contains(temp2) && ! visited.contains(temp2)) {
                            queue.offer(temp2);
                        }
                        //    将入过队列的字符串记录下来，防止重复入队列
                         visited.add(temp2);
                    }
                    // 将数组复原
                    temp1[j] = c;
                }
            }
        }
        return -1;
    }
}

package com.gewuyou.algorithm.dailyquestion;

import java.util.*;

/**
 * 警告一小时内使用相同员工卡大于等于三次的人
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName WarnEmployees
 * @apiNote </br>
 * @since 2023/2/7 9:22
 */
public class WarnEmployees {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        // 创建姓名对应时间的哈希表
        Map<String, List<Integer>> timeMap = new HashMap<>();
        // 为哈希表赋值
        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            // 如果时间不存在则创建
            timeMap.putIfAbsent(name, new ArrayList<>());
            // 将时间转换为分钟加入集合中
            int hour = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
            int minute = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
            timeMap.get(name).add(hour * 60 + minute);
        }
        // 创建结果集合
        List<String> results = new ArrayList<>();
        // 使用迭代器迭代哈希表
        for (Map.Entry<String, List<Integer>> keyValuePair : timeMap.entrySet()) {
            List<Integer> time = keyValuePair.getValue();
            // 对时间集合进行排序
            Collections.sort(time);
            for (int i = 2; i < time.size(); i++) {
                // 如果第一个数据与第三个数据差值小于等于60直接结束循环
                if (time.get(i) - time.get(i - 2) <= 60) {
                    results.add(keyValuePair.getKey());
                    break;
                }
            }
        }
        // 按字典序排序
        Collections.sort(results);
        return results;
    }
}

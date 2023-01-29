package com.gewuyou.algorithm.dailyquestion;

import java.util.*;

/**
 * 保证文件名唯一
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName KeepFileNamesUnique
 * @apiNote </br>
 * @since 2023/3/3 12:21
 */
public class KeepFileNamesUnique {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            String tempStr = names[i];
            Integer temp = map.get(tempStr);
            if (temp != null) {
                while (map.containsKey(addSuffix(tempStr, temp))) {
                    temp++;
                }
                names[i] = addSuffix(tempStr, temp);
                map.put(tempStr, temp+1);
                map.put(names[i], 1);
            } else {
                map.put(tempStr, 1);
            }
        }
        return names;
    }

    public String addSuffix(String name, int k) {
        return name + "(" + k + ")";
    }
}

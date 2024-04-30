package com.gewuyou.algorithm.dailyquestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 删除子文件夹
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName DeleteSubfolder
 * @apiNote </br>
 * @since 2023/2/8 9:48
 */
public class DeleteSubfolder {
    public List<String> removeSubfolders(String[] folder) {
        List<String> result = new ArrayList<>();
        if (folder == null || folder.length == 0) {
            return result;
        }
        Arrays.sort(folder);
        result.add(folder[0]);
        for (int i = 1; i < folder.length; i++) {
            // 计算结果集合中最后一个字符串的长度
            int length = result.get(result.size() - 1).length();
            // 如果当前文件夹不为上一个文件夹的子文件夹则将其加入集合
            if (!(length < folder[i].length() && folder[i].charAt(length) == '/' && result.get(result.size() - 1).equals(folder[i].substring(0, length)))) {
                result.add(folder[i]);
            }
        }
        return result;
    }
}

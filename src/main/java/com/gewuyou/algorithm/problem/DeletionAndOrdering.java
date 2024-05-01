package com.gewuyou.algorithm.problem;

/**
 * 944. 删列造序
 *
 * @author gewuyou
 * @since 2024-05-10 下午2:44:03
 */
public class DeletionAndOrdering {
    public int minDeletionSize(String[] strs) {
        int count = 0;
        int n = strs.length;
        int m = strs[0].length();
        char [][] chars = new char[n][m];
        // 填充数组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                chars[i][j] = strs[i].charAt(j);
            }
        }
        // 遍历数组找出非升序排列数组
        for (int i = 0; i < m; i++) {
            char pre = 'a'-1;
            for (int j = 0; j < n; j++) {
                char c = chars[j][i];
                if(pre> c){
                    count++;
                    break;
                }
                pre = c;
            }
        }
        return count;
    }
}

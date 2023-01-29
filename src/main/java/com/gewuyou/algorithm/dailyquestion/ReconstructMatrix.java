package com.gewuyou.algorithm.dailyquestion;

import java.util.ArrayList;
import java.util.List;

/**
 * 重构 2 行二进制矩阵
 *
 * @author GeWuYou
 * @version V1.0.0
 * @apiNote </br>
 * @since 2023/6/29 13:42
 */
public class ReconstructMatrix {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        // 创建数组
        List<List<Integer>> result = new ArrayList<>();
        // 统计总和
        int sum = 0;
        for (int i : colsum) {
            sum += i;
        }
        if (sum != (upper + lower)) {
            return result;
        }
        //初始化lists
        for (int i = 0;i < 2;i++){
            result.add(new ArrayList<>());
        }
        for (int col : colsum) {
            // 第i列
            // 如果和为2，说明两行都为1
            if (col == 2) {
                result.get(0).add(1);
                result.get(1).add(1);
                lower--;
                upper--;
            }// 如果为0，说明两行都为0
            else if (col == 0) {
                result.get(0).add(0);
                result.get(1).add(0);
            }
            // 如果和为1，说明其中一行为1
            else {
                //如果等于1 则根据upper和lower的大小选择
                if (upper>lower) {
                    result.get(0).add(1);
                    upper--;
                    result.get(1).add(0);
                }else {
                    result.get(1).add(1);
                    lower--;
                    result.get(0).add(0);
                }
                if(upper<0||lower<0){
                    return new ArrayList<>();
                }
            }
        }
        return result;
    }
}

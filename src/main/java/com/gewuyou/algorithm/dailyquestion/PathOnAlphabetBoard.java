package com.gewuyou.algorithm.dailyquestion;

/**
 * 字母板上的路径
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName PathOnAlphabetBoard
 * @apiNote </br>
 * @since 2023/2/12 11:00
 */
public class PathOnAlphabetBoard {
    public String alphabetBoardPath(String target) {
        // 记录初始位置
        int mx = 0;
        int my = 0;
        // 创建字符串序列记录操作
        StringBuilder result = new StringBuilder();
        // 目标有多长就得执行多少次查找操作
        for (int i = 0; i < target.length(); i++) {
            // 获取目标字母
            char c = target.charAt(i);
            // 计算目标字母在字母板上的位置
            // 行
            int tx = (c - 'a') / 5;
            // 列
            int ty = (c - 'a') % 5;
            // 判断当前位置在目标位置的方位
            // 向上
            if (tx < mx) {
                for (int j = 0; j < mx - tx; j++) {
                    result.append("U");
                }
            }
            // 向左
            if (ty < my) {
                for (int j = 0; j < my - ty; j++) {
                    result.append("L");
                }
            }
            // 向下
            if (tx > mx) {
                for (int j = 0; j < tx - mx; j++) {
                    result.append("D");
                }
            }
            // 向右
            if (ty > my) {
                for (int j = 0; j < ty - my; j++) {
                    result.append("R");
                }
            }
            // 加入分隔符
            result.append('!');
            // 更新位置
            mx = tx;
            my = ty;
        }
        // 返回结果
        return result.toString();
    }
}

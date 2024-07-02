package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 68. 文本左右对齐
 *
 * @author gewuyou
 * @since 2024-07-28 上午8:15:23
 */
public class TextIsAlignedLeftAndRight {
    public List<String> fullJustify(String[] words, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        // 带有空格的单词长度
        int len = 0;
        // 单词个数
        int count = 0;
        // 当前行已使用的单词长度
        int wordLen = 0;
        // 数组长度
        int n = words.length;
        for (int i = 0; i < n; i++) {
            // 计算需要添加的长度
            int addLen = words[i].length() + 1;
            // 判断当前单词是否可以放入当前行
            if (len + addLen - 1 <= maxWidth) {
                // 放入当前行
                len += addLen;
                count++;
                wordLen += words[i].length();
            } else {
                // 当前行已满，需要进行对齐
                // 判断还剩多少空格
                int spaceNum = maxWidth - wordLen;
                // 对于count个单词需要count-1个空格
                int spaceCount = count - 1;
                if(spaceCount == 0){
                    // 只有一个单词后面需要填充空格，如果有的话
                    spaceCount = 1;
                }
                // 计算平均空格数
                int avgSpaceNum = spaceNum / spaceCount;
                // 计算剩余空格数
                int remainSpaceNum = spaceNum % spaceCount;
                // 拼接单词填充空格
                for (int j = i - count; j < i; j++) {
                    sb.append(words[j]);
                    if (j != i - 1) {
                        sb.append(" ".repeat(Math.max(0, avgSpaceNum)));
                    }
                    if (remainSpaceNum > 0) {
                        sb.append(" ");
                        remainSpaceNum--;
                    }
                }
                // 填充只有一个单词的行
                if(count==1){
                    sb.append(" ".repeat(Math.max(0, avgSpaceNum)));
                }
                count = 0;
                len = 0;
                wordLen = 0;
                result.add(sb.toString());
                sb.setLength(0);
                i--;
            }
        }
        // 处理最后一行
        len = 0;
        for (int i = n - count; i < n; i++) {
            if (i != n - 1) {
                sb.append(words[i]).append(" ");
                len += words[i].length() + 1;
            } else {
                sb.append(words[i]);
                len += words[i].length();
                // 填充剩余空格
                sb.append(" ".repeat(maxWidth - len));
            }
        }
        result.add(sb.toString());
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"What","must","be","acknowledgment","shall","be"};
        int maxWidth = 16;
        TextIsAlignedLeftAndRight solution = new TextIsAlignedLeftAndRight();
        List<String> result = solution.fullJustify(words, maxWidth);
        for (String s : result) {
            System.out.println(s);
        }
    }
}

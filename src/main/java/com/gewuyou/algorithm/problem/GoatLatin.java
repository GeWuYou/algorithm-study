package com.gewuyou.algorithm.problem;

import java.util.Set;

/**
 * 824. 山羊拉丁文
 *
 * @author gewuyou
 * @since 2024-05-03 下午3:23:36
 */
public class GoatLatin {
    public String toGoatLatin(String sentence) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.setLength(0);
            // 如果单词以元音开头则在尾部添加ma
            if (vowels.contains(words[i].charAt(0))) {
                sb.append(words[i]).append("ma");
            }
            // 否则移除第一个字符并放置于末尾之后添加ma
            else {
                sb.append(words[i].substring(1)).append(words[i].charAt(0)).append("ma");
            }
            // 在末尾添加和索引相同数量的a
            sb.append("a".repeat(i + 1));
            if (i != words.length - 1) {
                sb.append(" ");
            }
            result.append(sb);
        }
        return result.toString();
    }
}

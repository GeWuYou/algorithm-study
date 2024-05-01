package com.gewuyou.algorithm.problem;

/**
 * 748. 最短补全词
 *
 * @author gewuyou
 * @since 2024-05-01 下午12:53:57
 */
public class ShortestComplement {
    public String shortestCompletingWord(String licensePlate, String[] words) {
       // 提取字母
        String letters = licensePlate.replaceAll("[^a-zA-Z]", "").toLowerCase();
        System.out.println(letters);
        int minLength = Integer.MAX_VALUE;
        String result = "";
        for (String s : words) {
            String word = s.toLowerCase();
            // 统计字母出现次数
            int[] count = new int[26];
            for (int j = 0; j < word.length(); j++) {
                count[word.charAt(j) - 'a']++;
            }
            // 统计licensePlate字母出现次数
            int[] plateCount = new int[26];
            for (int j = 0; j < letters.length(); j++) {
                plateCount[letters.charAt(j) - 'a']++;
            }
            // 字母出现次数大于等于licensePlate字母出现次数，则为合法词
            boolean valid = true;
            for (int j = 0; j < 26; j++) {
                if (count[j] < plateCount[j]) {
                    valid = false;
                    break;
                }
            }
            if (valid && word.length() < minLength) {
                minLength = word.length();
                result = word;
            }
        }
        return result;
    }
}

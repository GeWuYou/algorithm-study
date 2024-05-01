package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 1078. Bigram 分词
 *
 * @author gewuyou
 * @since 2024-05-16 下午4:08:33
 */
public class BigramParticiple {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> result = new ArrayList<>();
        String[] words = text.split(" ");
        int n = words.length;
        for (int i = 0; i < n-2; i++) {
            if (words[i].equals(first)) {
                if (i + 1 < n && words[i + 1].equals(second)) {
                    result.add(words[i + 2]);
                }
            }
        }
        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {

        BigramParticiple bigramParticiple = new BigramParticiple();
        String[] result = bigramParticiple.findOcurrences(
                "we we we we will rock you",
                "we", "we");
        for (String s : result) {
            System.out.println(s);
        }
    }
}

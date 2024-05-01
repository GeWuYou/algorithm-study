package com.gewuyou.algorithm.problem;

/**
 * 925. 长按键入
 *
 * @author gewuyou
 * @since 2024-05-09 下午2:13:16
 */
public class PressAndHoldToType {
    public boolean isLongPressedName(String name, String typed) {
        int indexName = 0;
        int n = name.length();
        int m = typed.length();
        if (n == m) {
            return name.equals(typed);
        }
        for (int i = 0; i < typed.length(); i++) {
            char charTyped = typed.charAt(i);
            if (indexName >= n) {
                if (typed.charAt(i - 1) != charTyped) {
                    return false;
                }
                continue;
            }
            if (charTyped != name.charAt(indexName)) {
                // 如果此时没有上一个则返回false
                if (i == 0 || typed.charAt(i - 1) != charTyped) {
                    return false;
                }
            } else {
                indexName++;
            }
        }
        return indexName == n;

    }

    public static void main(String[] args) {

        PressAndHoldToType p = new PressAndHoldToType();
        System.out.println(p.isLongPressedName("alex", "aaleelx"));
    }
}

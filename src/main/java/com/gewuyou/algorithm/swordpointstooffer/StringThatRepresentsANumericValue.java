package com.gewuyou.algorithm.swordpointstooffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 表示数值的字符串
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName StringThatRepresentsANumericValue
 * @apiNote </br>
 * @since 2023/1/18 18:13
 */
public class StringThatRepresentsANumericValue {
    /**
     * 表示数值的字符串
     *
     * @param s 字符串
     * @return boolean 是否为数值
     * @apiNote
     * @since 2023/1/18 18:16
     */
    public boolean isNumber(String s) {
        Map[] states = {
                // 0.
                new HashMap<Object, Object>() {{
                    put(' ', 0);
                    put('s', 1);
                    put('d', 2);
                    put('.', 4);
                }},
                // 1.
                new HashMap<Object, Object>() {{
                    put('d', 2);
                    put('.', 4);
                }},
                // 2.
                new HashMap<Object, Object>() {{
                    put('d', 2);
                    put('.', 3);
                    put('e', 5);
                    put(' ', 8);
                }},
                // 3.
                new HashMap<Object, Object>() {{
                    put('d', 3);
                    put('e', 5);
                    put(' ', 8);
                }},
                // 4.
                new HashMap<Object, Object>() {{
                    put('d', 3);
                }},
                // 5.
                new HashMap<Object, Object>() {{
                    put('s', 6);
                    put('d', 7);
                }},
                // 6.
                new HashMap<Object, Object>() {{
                    put('d', 7);
                }},
                // 7.
                new HashMap<Object, Object>() {{
                    put('d', 7);
                    put(' ', 8);
                }},
                // 8.
                new HashMap<Object, Object>() {{
                    put(' ', 8);
                }}
        };
        int p = 0;
        char t;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                t = 'd';
            } else if (c == '+' || c == '-') {
                t = 's';
            } else if (c == 'e' || c == 'E') {
                t = 'e';
            } else if (c == '.' || c == ' ') {
                t = c;
            } else {
                t = '?';
            }
            if (!states[p].containsKey(t)) {
                return false;
            }
            p = (int) states[p].get(t);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }
}

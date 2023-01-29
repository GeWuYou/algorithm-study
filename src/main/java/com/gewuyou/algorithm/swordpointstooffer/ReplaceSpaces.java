package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 替换空格
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName ReplaceSpaces
 * @apiNote </br>
 * @since 2023/1/18 14:23
 */
public class ReplaceSpaces {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}

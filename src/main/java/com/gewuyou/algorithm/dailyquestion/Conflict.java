package com.gewuyou.algorithm.dailyquestion;

/**
 * 判断两个事件是否存在冲突
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName Conflict
 * @apiNote </br>
 * @since 2023/5/17 15:03
 */
public class Conflict {
    public boolean haveConflict(String[] event1, String[] event2) {
        return !(event1[1].compareTo(event2[0]) < 0 || event2[1].compareTo(event1[0]) < 0);
    }
}

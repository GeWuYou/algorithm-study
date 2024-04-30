package com.gewuyou.algorithm.dailyquestion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 算法测试类
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName Test
 * @apiNote </br>
 * @since 2023/1/27 13:45
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        test.add(6);
        test.add(7);
        test.add(8);
        Iterator<Integer> iterator = test.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if((i&1)==0) {
                iterator.remove();
            }
        }
        System.out.println(test);
    }

}


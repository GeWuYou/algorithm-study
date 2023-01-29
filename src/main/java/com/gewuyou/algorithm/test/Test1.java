package com.gewuyou.algorithm.test;

import lombok.extern.slf4j.Slf4j;

/**
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName Test1
 * @apiNote </br>一个有序数列，序列中的每一个值都能够被2或者3或者5所整除，这个序列的初始值从1开始，但是1并不在这个数列中。求第1500个值是多少？
 * @since 2022/11/16 23:16
 */
@Slf4j
public class Test1 {
    public static void main(String[] args) {
       int count = 0;
        for (int i = 1; i < 99999; i++) {
            if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0) {
                count++;
            }
            if(count== 1500){
                log.info("{}",i);
                return;
            }
        }
    }
}

package com.gewuyou.algorithm.test;

import com.gewuyou.algorithm.sort.Merge;

import java.util.Arrays;

public class MergeTest {

    public static void main(String[] args) {
        Integer[] a = {8,4,5,7,1,3,6,2,2,999,3,4};
        Merge.sort(a);
        System.out.println(Arrays.toString(a));//{1,2,3,4,5,6,7,8}
    }
}

package com.gewuyou.algorithm.test;

import com.gewuyou.algorithm.sort.Quick;

import java.util.Arrays;

public class QuickTest {
    public static void main(String[] args) {
        int[] a= {2,1};
        Quick.QuickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));//{1, 2, 3, 4, 5, 6, 7, 8, 9}
    }
}

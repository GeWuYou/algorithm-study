package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 最小K个数
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName SmallestKNumber
 * @apiNote </br>
 * @since 2023/1/8 15:56
 */
public class SmallestKNumber {
    public List<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        return Arrays.stream(input).sorted().limit(k).boxed().collect(Collectors.toCollection(ArrayList::new));
    }
}

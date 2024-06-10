package com.gewuyou.algorithm.dailyquestion;

import java.util.Arrays;

/**
 * 881. 救生艇
 *
 * @author gewuyou
 * @since 2024-06-10 下午2:01:03
 */
public class Lifeboat {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int count = 0;
        while (left <= right && people[right] == limit) {
            right--;
            count++;
        }
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] people = {2, 2};
        int limit = 6;
        Lifeboat solution = new Lifeboat();
        int result = solution.numRescueBoats(people, limit);
        System.out.println(result);
    }
}

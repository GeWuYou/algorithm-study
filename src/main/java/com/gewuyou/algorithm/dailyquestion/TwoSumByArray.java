package com.gewuyou.algorithm.dailyquestion;

/**
 * @author GeWuYou
 * @version V1.0.0
 * @apiNote </br>
 * @since 2023/7/8 22:15
 */
public class TwoSumByArray {
    public int[] twoSum(int[] numbers, int target) {
        // 定义左指针
        int left = 0;
        // 定义右指针
        int right = numbers.length-1;
        while (left < right) {
            // 必须保证numbers[left]!=numbers[right]
            if((numbers[left] + numbers[right]==target)&&numbers[right]!=numbers[left]){
                return new int[] {left+1,right+1};
            }else if(numbers[left]+numbers[right]>target){
                right--;
            }else{
                left++;
            }
        }
        return new int[]{};
    }
}

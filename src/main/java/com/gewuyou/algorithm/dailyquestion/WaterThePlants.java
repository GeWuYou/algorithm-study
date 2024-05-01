package com.gewuyou.algorithm.dailyquestion;

/**
 * 2079. 给植物浇水
 *
 * @author gewuyou
 * @since 2024-05-08 上午11:43:03
 */
public class WaterThePlants {
    public int wateringPlants(int[] plants, int capacity) {
        int currentCapacity = capacity;
        int locale = 0;
        int result = 0;
        for (int i = 0; i < plants.length; i++) {
            // 判断是否可以浇水
            if(currentCapacity >= plants[i]){
                currentCapacity -= plants[i];
                locale++;
                result++;
            }
            // 如果不能浇水
            else{
                result+=(2*locale)+1;
                currentCapacity = capacity-plants[i];
                locale++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] plants = {2,2,3,3};
        int capacity = 5;
        WaterThePlants waterThePlants = new WaterThePlants();
        int result = waterThePlants.wateringPlants(plants, capacity);
        System.out.println(result);
    }
}

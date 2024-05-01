package com.gewuyou.algorithm.dailyquestion;

/**
 * 2105. 给植物浇水 II
 *
 * @author gewuyou
 * @since 2024-05-09 下午1:00:52
 */
public class WateringPlantsII {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int count = 0;
        int n = plants.length;
        int indexA = 0;
        int indexB = n - 1;
        int currentCapacityA = capacityA;
        int currentCapacityB = capacityB;
        while (indexA < indexB) {
            // 判断水是否充足
            if (currentCapacityA >= plants[indexA]) {
                currentCapacityA -= plants[indexA];
            } else {
                // 不够则补充
                currentCapacityA = capacityA - plants[indexA];
                count++;
            }
            indexA++;
            // 判断水是否充足
            if (currentCapacityB >= plants[indexB]) {
                currentCapacityB -= plants[indexB];
            } else {
                // 不够则补充
                currentCapacityB = capacityB - plants[indexB];
                count++;
            }
            indexB--;
        }
        if (indexA == indexB) {
            if (currentCapacityA >= currentCapacityB && currentCapacityA < plants[indexA]) {
                count++;
            }

            if (currentCapacityB > currentCapacityA && currentCapacityB < plants[indexB]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] plants = {1, 2, 4, 4, 5};
        int capacityA = 6;
        int capacityB = 5;
        WateringPlantsII wateringPlantsII = new WateringPlantsII();
        int minimumRefill = wateringPlantsII.minimumRefill(plants, capacityA, capacityB);
        System.out.println(minimumRefill);

    }
}

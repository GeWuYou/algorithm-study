package com.gewuyou.algorithm.problem;

/**
 * 507. 完美数
 *
 * @author gewuyou
 * @since 2024-04-20 上午9:09:16
 */
public class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) {
            return false;
        }
        // 对num求平方根
        int sqrt = (int) Math.sqrt(num);
        int sum = 0;
        // 从平方根开始找因子
        for (int i = sqrt; i > 0; i--) {
            if(num % i == 0){
                sum += i;
                if(i!= num/i&&sum!=num){
                    sum += num/i;
                }
            }
        }
        // 如果和等于num，则是完美数
        return sum == num;
    }

    public static void main(String[] args) {

        PerfectNumber perfectNumber = new PerfectNumber();
        System.out.println(perfectNumber.checkPerfectNumber(28)); // true
        System.out.println(perfectNumber.checkPerfectNumber(6)); // true
    }
}

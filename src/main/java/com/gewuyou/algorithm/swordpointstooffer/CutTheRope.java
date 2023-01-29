package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 剪绳子
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName CutTheRope
 * @apiNote </br>
 * @since 2023/2/15 20:47
 */
public class CutTheRope {
    public int cuttingRope(int n) {
        // 当n<=3时，按照规则不应该切分，但由于题目要求必须剪成m>1段，因此必须剪出一段长度为1的绳子，即返回n-1
        if (n <= 3) {
            return n - 1;
        }
        // 当n>3时，求n/3的整数部分a和余数部分b(即n=3a+b)，并分以下三种情况
        // 幂
        int power = n / 3;
        // 模
        int model = n % 3;
        // 当余数等于0时，直接返回3的power次方
        if (model == 0) {
            return (int) Math.pow(3, power);
        }
        // 当余数等于1时，要将一个1+3转换为2+2，因此返回3的power-1次方×4
        else if (model == 1) {
            power--;
            return (int) Math.pow(3, power) * 4;
        }
        // 当余数等于2时，返回返回3的power-1次方×2
        else {
            return (int) Math.pow(3, power) * 2;
        }
    }
}

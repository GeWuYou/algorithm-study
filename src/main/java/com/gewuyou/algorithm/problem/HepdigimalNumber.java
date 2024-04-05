package com.gewuyou.algorithm.problem;

/**
 * 504. 七进制数
 *
 * @author gewuyou
 * @since 2024-04-20 上午8:29:34
 */
public class HepdigimalNumber {
    public String convertToBase7(int num) {
            if (num == 0) {
                return "0";
            }
            boolean isNegative = false;
            if (num < 0) {
                num = -num;
                isNegative = true;
            }
            StringBuilder sb = new StringBuilder();
            while(num>0){
                int remainder = num % 7;
                sb.append(remainder);
                num /= 7;
            }
            if (isNegative) {
                sb.append("-");
            }
            return sb.reverse().toString();
    }

    public static void main(String[] args) {
        HepdigimalNumber h = new HepdigimalNumber();
        System.out.println(h.convertToBase7(7));
    }
}

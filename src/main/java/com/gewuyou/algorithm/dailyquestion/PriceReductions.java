package com.gewuyou.algorithm.dailyquestion;

/**
 * 2288. 价格减免
 *
 * @author gewuyou
 * @since 2024-06-18 下午1:59:28
 */
public class PriceReductions {
    public String discountPrices(String sentence, int discount) {
        double d = 1 - discount / 100.0;
        String[] a = sentence.split(" ");
        for (int i = 0; i < a.length; i++) {
            if(check(a[i])){
                a[i] = String.format("$%.2f", Long.parseLong(a[i].substring(1)) * d);
            }
        }
        return String.join(" ", a);
    }

    private boolean check(String s) {
        if(s.length()==1||s.charAt(0)!= '$'){
            return false;
        }
        char[] array = s.toCharArray();

        for(int i=1;i<array.length;i++){
            if(!Character.isDigit(array[i])){
                return false;
            }
        }
        return true;
    }
}

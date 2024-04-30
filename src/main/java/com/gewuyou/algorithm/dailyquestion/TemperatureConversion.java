package com.gewuyou.algorithm.dailyquestion;

/**
 * 温度转换
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName TemperatureConversion
 * @apiNote </br>
 * @since 2023/3/21 8:41
 */
public class TemperatureConversion {
    public double[] convertTemperature(double celsius) {
        return new double[]{celsius+273.15,(9.0/5.0)*(celsius-10)+50};
    }
}

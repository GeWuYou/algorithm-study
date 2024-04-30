package com.gewuyou.algorithm.dailyquestion;

/**
 * 经营摩天轮的最大利润
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName MaximumProfitFromOperatingAFerrisWheel
 * @apiNote </br>
 * @since 2023/3/5 12:31
 */
public class MaximumProfitFromOperatingAFerrisWheel {
    public static int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        // 等待人数
        int numberOfPeopleWaiting = 0;
        // 结果
        int result = -1;
        // 当前利润
        int currentProfit = 0;
        // 最大利润
        int maxProfit = 0;
        // 总轮数
        int count = 0;
        for (int customer : customers) {
            count++;
            // 将到达人数加入就绪队列
            numberOfPeopleWaiting += customer;
            // 计算登上座舱的游客数量
            int currCustomer = Math.min(4,numberOfPeopleWaiting);
            // 将登上座舱的游客数量从就绪队列中删去
            numberOfPeopleWaiting-=currCustomer;
            // 计算本轮李荣
            currentProfit+=currCustomer*boardingCost-runningCost;
            // 更新最大利润与次数
            if(currentProfit>maxProfit){
                result = count;
                maxProfit = currentProfit;
            }
        }
        // 如果等待队列为空则直接返回
        if(numberOfPeopleWaiting==0){
            return result;
        }
        int profitEachTime = boardingCost * 4 - runningCost;
        // 如果队列中还有人
        if(numberOfPeopleWaiting>0){
            int currCount = numberOfPeopleWaiting/4;
            currentProfit+=profitEachTime*currCount;
            count+=currCount;
            // 更新最大利润与次数
            if(currentProfit>maxProfit){
                result = count;
                maxProfit = currentProfit;
            }
            // 判断剩余的是否赚钱
            numberOfPeopleWaiting%=4;
            currentProfit+=numberOfPeopleWaiting*boardingCost-runningCost;
            // 更新最大利润与次数
            if(currentProfit>maxProfit){
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] temp = new int[]{0,43,37,9,23,35,18,7,45,3,8,24,1,6,37,2,38,15,1,14,39,27,4,25,27,33,43,8,44,30,38,40,20,5,17,27,43,11,6,2,30,49,30,25,32,3,18,23,45,43,30,14,41,17,42,42,44,38,18,26,32,48,37,5,37,21,2,9,48,48,40,45,25,30,49,41,4,48,40,29,23,17,7,5,44,23,43,9,35,26,44,3,26,16,31,11,9,4,28,49,43,39,9,39,37,7,6,7,16,1,30,2,4,43,23,16,39,5,30,23,39,29,31,26,35,15,5,11,45,44,45,43,4,24,40,7,36,10,10,18,6,20,13,11,20,3,32,49,34,41,13,11,3,13,0,13,44,48,43,23,12,23,2};
        System.out.println(minOperationsMaxProfit(temp, 43, 54));
    }
}

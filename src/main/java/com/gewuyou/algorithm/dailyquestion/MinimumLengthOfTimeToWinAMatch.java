package com.gewuyou.algorithm.dailyquestion;

/**
 * 赢得比赛需要的最少训练时长
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName MinimumLengthOfTimeToWinAMatch
 * @apiNote </br>
 * @since 2023/3/13 9:42
 */
public class MinimumLengthOfTimeToWinAMatch {
    /**
     * @param initialEnergy     初始经验
     * @param initialExperience 初始精力
     * @param energy            敌人经验数组
     * @param experience        敌人精力数组
     * @return int 最短小时数
     * @apiNote 从整局来看，一共需要进行n场比赛，则精力会损耗sum(experience[i]) 经验增加sum(energy[i])
     * 一次训练可以增加一点精力或者经验，只有经验与精力严格大于对手才会获胜
     * @since 2023/3/13 9:50
     */
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        // 计算对局数
        int n = energy.length;
        // 训练时间
        int result = 0;
        // 遍历数组判断差距
        for (int i = 0; i < n; i++) {
            // 比较经验
            // 经验打不过，再练练
            while (initialExperience <= experience[i]) {
                result++;
                initialExperience++;
            }
            // 打赢之后再加经验
            initialExperience += experience[i];
            // 比较精力
            // 精力打不过，再练练
            while (initialEnergy <= energy[i]){
                result++;
                initialEnergy++;
            }
            // 打赢后扣除精力
            initialEnergy-=energy[i];

        }
        return result;
    }
}

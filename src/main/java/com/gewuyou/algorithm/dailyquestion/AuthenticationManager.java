package com.gewuyou.algorithm.dailyquestion;

import java.util.HashMap;
import java.util.Map;

/**
 * 验证系统
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName AuthenticationManager
 * @apiNote </br>
 * @since 2023/2/9 9:44
 */
public class AuthenticationManager {
    /**
     * 验证码集合 验证码:过期时间
     */
    Map<String, Integer> map;
    /**
     * 验证码过期时间
     */
    private final int timeToLive;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.map = new HashMap<>();
    }

    /**
     * 生成新验证码
     *
     * @param tokenId     验证码
     * @param currentTime 当前时间
     * @apiNote 给定 tokenId ，在当前时间 currentTime 生成一个新的验证码。
     * @since 2023/2/9 9:56
     */
    public void generate(String tokenId, int currentTime) {
        // 新增验证码
        map.put(tokenId, currentTime + timeToLive);
    }

    /**
     * 更新验证码
     *
     * @param tokenId     验证码
     * @param currentTime 当前时间
     * @apiNote 将给定 tokenId 且 未过期 的验证码在 currentTime 时刻更新。如果给定 tokenId 对应的验证码不存在或已过期，请你忽略该操作，不会有任何更新操作发生。
     * @since 2023/2/9 9:57
     */
    public void renew(String tokenId, int currentTime) {
        // 如果map中验证码存在且过期时间大于当前时间则更新验证码
        if (map.containsKey(tokenId) && map.get(tokenId) > currentTime) {
            // 更新验证码
            map.put(tokenId, currentTime + timeToLive);
        }
    }

    /**
     * 返回未过期的验证码数量
     *
     * @param currentTime 当前时间
     * @return int
     * @apiNote 返回在给定 currentTime 时刻，未过期 的验证码数目。
     * @since 2023/2/9 9:58
     */
    public int countUnexpiredTokens(int currentTime) {
        // 计数器
        int count = 0;
        // 遍历过期时间
        for (Integer value : map.values()) {
            if (value > currentTime) {
                count++;
            }
        }
        // 返回未过期的验证码数量
        return count;
    }
}

package com.gewuyou.algorithm.test;

import com.gewuyou.algorithm.uf.UF_Tree_Weighted;

import java.io.*;

/**
 * 畅通工程
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName Traffic_Project_Test
 * @apiNote 使用并查集解决修路问题
 * @since 2022/9/7 11:53
 */
public class Traffic_Project_Test {

    public static void main(String[] args) throws IOException {

        // 构建一个缓冲读取流 BufferedReader
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(new FileInputStream("resource/traffic_project.txt")));
        // 读取第一行数据20
        int totalNumber = Integer.parseInt(bufferedReader.readLine());
        // 构建一个并查集对象
        UF_Tree_Weighted uf = new UF_Tree_Weighted(totalNumber);
        // 读取第二行数据7
        int roadNumber = Integer.parseInt(bufferedReader.readLine());
        // 循环读取七条道路
        for (int i = 0; i < roadNumber; i++) {
            String line = bufferedReader.readLine();
            String[] str = line.split(" ");
            int p = Integer.parseInt(str[0]);
            int q = Integer.parseInt(str[1]);
            // 调用并查集对象的union方法让两个城市想相通
            uf.union(p,q);
        }
        // 获取当前并查集中分组数量-1就可以得到还需要修建的道路的数目
        int roads = uf.count() - 1;
        System.out.println("还需要修建"+roads+"条数据,才能实现畅通工程！");
        bufferedReader.close();
    }
}

package com.gewuyou.algorithm.test;

import com.gewuyou.algorithm.graph.DepthFirstSearch;
import com.gewuyou.algorithm.graph.Graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 畅通工程
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName Traffic_Project_Test2
 * @apiNote 使用图搜索技术解决修路问题
 * @since 2022/9/8 13:42
 */
public class Traffic_Project_Test2 {

    public static void main(String[] args) throws IOException {
        // 构建一个缓冲读取流 BufferedReader
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(new FileInputStream("resource/traffic_project.txt")));
        // 读取第一行数据20
        int totalNumber = Integer.parseInt(bufferedReader.readLine());
        // 构建一个图
        Graph graph = new Graph(totalNumber);
        // 读取第二行数据7
        int roadNumber = Integer.parseInt(bufferedReader.readLine());
        // 循环读取七条道路
        String road;
        String[] strings;
        for (int i = 1; i < roadNumber; i++) {
            road = bufferedReader.readLine();
            strings = road.split(" ");
            int p = Integer.parseInt(strings[0]);
            int q = Integer.parseInt(strings[1]);
            //调用图的addEdge方法，把边添加到图中，表示已经修建好的道路
            graph.addEdge(p,q);
        }
        //构建一个深度优先搜索对象，起点设置为顶点9
        DepthFirstSearch search = new DepthFirstSearch(graph, 9);

        //调用marked方法，判断8顶点和10顶点是否与起点9相通
        System.out.println("顶点8和顶点9是否相通："+search.marked(8));
        System.out.println("顶点10和顶点9是否相通："+search.marked(10));
        bufferedReader.close();
    }
}

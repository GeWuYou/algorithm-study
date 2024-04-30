package com.gewuyou.algorithm.test;

import com.gewuyou.datastructures.tree.BinaryTree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        //创建二叉查找树对象
        BinaryTree<Integer, String> tree = new BinaryTree<>();

        //测试插入
        tree.put(1,"张三");
        tree.put(2,"李四");
        tree.put(3,"王五");
        /*tree.put(4,"王五2");
        tree.put(5,"王五3");
        tree.put(6,"王五4");
        tree.put(7,"王五5");
        tree.put(8,"王五6");
        tree.put(9,"王五7");
        tree.put(10,"王五8");
        tree.put(11,"王五9");
        tree.put(12,"王五10");
        tree.put(13,"王五11");
        tree.put(14,"王五12");
        tree.put(15,"王五13");
        tree.put(16,"王五14");
        tree.put(17,"王五15");
        tree.put(18,"王五16");
        tree.put(19,"王五17");
        tree.put(20,"王五18");
        tree.put(21,"王五19");
        tree.put(22,"王五20");
        tree.put(23,"王五21");
        tree.put(24,"王五22");
        tree.put(25,"王五23");
        tree.put(26,"王五24");*/
        System.out.println("插入完毕后元素的个数："+tree.size());

        //测试获取
        System.out.println("键2对应的元素是："+tree.get(2));

        //测试删除

        tree.delete(1);
        System.out.println("删除后的元素个数："+tree.size());
        System.out.println("删除后键1对应的元素:"+tree.get(1));


    }

}

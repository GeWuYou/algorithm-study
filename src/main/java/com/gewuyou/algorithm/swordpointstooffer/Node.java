package com.gewuyou.algorithm.swordpointstooffer;

/**
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName Node
 * @apiNote </br>
 * @since 2023/2/1 15:15
 */
public class Node {

    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

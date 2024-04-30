package com.gewuyou.algorithm.swordpointstooffer;


/**
 * 链表的反向遍历
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName ReverseTraversalOfALinkedList
 * @apiNote </br>
 * @since 2023/1/18 16:28
 */
public class ReverseTraversalOfALinkedList {
    // /**
    //  * 思路一：利用栈的特性求反向遍历
    //  * @param head 数据头节点
    //  * @return 遍历结果
    //  */
    // public int[] reversePrint(ListNode head) {
    //     Stack<Integer> temp = new Stack<>();
    //     ListNode flag = head;
    //     while (flag != null) {
    //         temp.push(flag.val);
    //         flag = flag.next;
    //     }
    //     int[] result = new int[temp.size()];
    //     int length = temp.size();
    //     for (int i = 0; i < length; i++) {
    //         result[i] = temp.pop();
    //     }
    //     return result;
    // }

    /**
     * 思路二：利用数组的索引关系
     *
     * @param head 数据头节点
     * @return 遍历结果
     */
    public int[] reversePrint(ListNode head) {
        // 计算链表长度
        ListNode temp = head;
        // 计数器
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        // 创建结果数组
        int[] result = new int[count];
        // 反向给数组赋值
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = head.val;
            head = head.next;
        }
        return result;
    }
}

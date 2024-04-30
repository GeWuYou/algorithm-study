package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 合并 K 个升序链表
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName MergeKLists
 * @apiNote </br>
 * @since 2023/4/11 20:18
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        List<ListNode> list = Arrays.asList(lists);
        // 调用合并方法进行合并
        list = mergeLists(list);
        return list.get(0);
    }

    public List<ListNode> mergeLists(List<ListNode> list) {
        // 判断链表集合中元素的数量
        int k = list.size();
        if (k == 1||list.isEmpty()) {
            return list;
        }
        List<ListNode> newList = new ArrayList<>();
        // 如果是偶数
        if ((k & 2) == 0) {
            for (int i = 0; i < k; i += 2) {
                // 将合并后的链表加入临时集合
                newList.add(Merge(list.get(i), list.get(i + 1)));
            }
        }
        // 如果是奇数
        else {
            for (int i = 0; i < k; i += 2) {
                // 当遍历到最后一位时直接将该链表加入集合
                if (i == k - 1) {
                    newList.add(list.get(i));
                    break;
                }
                // 将合并后的链表加入临时集合
                newList.add(Merge(list.get(i), list.get(i + 1)));
            }
        }
        // 递归调用
        return mergeLists(newList);
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        // 设list1为主链表 创建两个指针
        ListNode flag = new ListNode(0);
        ListNode head = flag;
        while (list1 != null && list2 != null) {
            // 比较两个指针值
            if (list1.val > list2.val) {
                flag.next = list2;
                list2 = list2.next;
            } else if (list1.val < list2.val) {
                flag.next = list1;
                list1 = list1.next;
            } else {
                flag.next = list1;
                list1 = list1.next;
                flag = flag.next;
                flag.next = list2;
                list2 = list2.next;
            }
            flag = flag.next;
        }
        // 判断是否还有链表未遍历完
        if (list1 != null) {
            flag.next = list1;
        }
        if (list2 != null) {
            flag.next = list2;
        }
        return head.next;
    }
}

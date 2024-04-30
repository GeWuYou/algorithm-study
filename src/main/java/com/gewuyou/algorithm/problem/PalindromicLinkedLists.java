package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 回文链表
 *
 * @author gewuyou
 * @since 2024-04-09 下午4:56:46
 */
public class PalindromicLinkedLists {
    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        List<Integer> list = new ArrayList<>();
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        int l = 0, r = list.size() - 1;
        while (l < r) {
            if (!Objects.equals(list.get(l), list.get(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}

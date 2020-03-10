package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/2/24
 * @desc 面试题0202
 */
public class KthToLast {

    public int kthToLast1(ListNode head, int k) {

        Map<Integer, ListNode> map = new HashMap<>();

        int index = 0;

        while (head != null) {
            map.put(index++, head);
            head = head.next;
        }
        index = index - k;
        return map.get(index).val;
    }

    public int kthToLast(ListNode head, int k) {

        ListNode first = head;
        for (int i = 0; i < k; i++) {
            first = first.next;
        }

        while (first != null) {
            head = head.next;
            first = first.next;
        }

        return head.val;
    }

}

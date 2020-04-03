package com.leetcode;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/3/23
 * @desc
 */
public class MiddleNode {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        ListNode head = ListNode.ListNodeUtil.create(arr);
        System.out.println(new MiddleNode().middleNode(head).val);
    }

    public ListNode middleNode(ListNode head) {
        ListNode next = head;
        if (next==null || next.next == null) {
            return head;
        }

        while (next != null && next.next != null) {
            next = next.next.next;
            head = head.next;
        }
        return head;
    }

}

package com.leetcode;

public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }

    public static class ListNodeUtil {
         public static ListNode create(int[] arr) {
             ListNode head = new ListNode(0), temp = head;
             for (int a : arr) {
                 temp.next = new ListNode(a);
                 temp = temp.next;
             }
             return head.next;
         }
     }

 }
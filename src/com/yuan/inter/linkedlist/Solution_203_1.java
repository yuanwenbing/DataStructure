package com.yuan.inter.linkedlist;

public class Solution_203_1 {
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            }else{
                prev = prev.next;
            }
        }

        return dummyHead.next;
    }
}

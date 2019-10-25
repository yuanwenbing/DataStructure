package com.yuan.inter.recursive;

import com.yuan.inter.Main;
import com.yuan.inter.linkedlist.ListNode;


public class Solution_203_2 {
    public ListNode removeElements(ListNode head, int val, int depth) {

        String depthString = generateDepthString(depth);
        if (head == null) {
            return null;
        }

//        ListNode res = removeElements(head.next, val);
//        if (head.val == val) {
//            return res;
//        } else {
//            head.next = res;
//        }
//
//        return head;

        head.next = removeElements(head.next, val, depth + 1);
        return head.val == val ? head.next : head;
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 3, 5};
        ListNode listNode = new ListNode(arr);
        new Solution_203_2().removeElements(listNode, 3, 0);
        System.out.println(listNode.toString());
    }
}

package com.yuan.inter.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution_20 {

    public static void main(String[] args) {
        String s = "[{}]";
        System.out.println(new Solution_20().isValid(s));


        Queue<Integer> queue = new LinkedList<>();
    }


    public  boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                if (ch == ')' && stack.pop() != '(')
                    return false;
                if (ch == ']' && stack.pop() != '[') {
                    return false;
                }
                if (ch == '}' && stack.pop() != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

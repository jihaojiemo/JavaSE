package com.bittech;

import java.util.Stack;

public class TestStack {

    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();

        stack.push("Java");
        stack.push("C++");
        stack.push("PHP");

        System.out.println(stack.peek());//PHP
        System.out.println(stack.pop());//PHP
        System.out.println(stack.size());//2
        System.out.println(stack.peek());//C++
        System.out.println(stack.isEmpty());//false
        System.out.println(stack.pop());//C++
        System.out.println(stack.pop());//Java

        //栈空了，EmptyStackException
        // System.out.println(stack.pop());

        if (stack.isEmpty()) {
            System.out.println("栈空了");
        } else {
            System.out.println(stack.pop());
        }

    }
}

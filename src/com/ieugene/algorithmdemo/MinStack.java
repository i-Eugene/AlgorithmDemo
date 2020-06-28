package com.ieugene.algorithmdemo;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void demo() {
        push(4);
        push(9);
        push(7);
        push(3);
        push(8);
        push(5);
        System.out.println("最小值：" + getMin());
        pop();
        pop();
        pop();
        System.out.println("三次出栈后最小值：" + getMin());
    }

    public void push(int element) {
        mainStack.push(element);
        if (minStack.isEmpty() || minStack.peek() >= element) {
            minStack.push(element);
        }
    }

    public int pop() {
        int element = mainStack.pop();
        if (!minStack.isEmpty() && minStack.peek().equals(element)) {
            minStack.pop();
        }
        return element;
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.demo();
    }
}

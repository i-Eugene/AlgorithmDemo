package com.ieugene.algorithmdemo;

import java.util.Stack;

public class StackSimulateQueue {
    Stack<Integer> pushStack = new Stack<>();
    Stack<Integer> popStack = new Stack<>();

    public void demo() {
        enqueue(1);
        enqueue(2);
        enqueue(3);
        System.out.println("第一次出队：" + dequeue());
        System.out.println("第二次出队：" + dequeue());
        enqueue(4);
        System.out.println("第三次出队：" + dequeue());
        System.out.println("第四次出队：" + dequeue());
    }

    //入队
    public void enqueue(int element) {
        pushStack.push(element);
    }

    //出队
    public Integer dequeue() {
        if (popStack.isEmpty()) {
            if (pushStack.isEmpty()) {
                return null;
            }
            transfer();
        }
        return popStack.pop();
    }

    private void transfer() {
        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
    }

    public static void main(String[] args) {
        StackSimulateQueue queue = new StackSimulateQueue();
        queue.demo();
    }
}

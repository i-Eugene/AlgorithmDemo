package com.ieugene.algorithmdemo;

/**
 * 循环队列
 */
public class QueueBaseOperation {
    private int[] array;
    private int front;
    private int rear;
    private int size;

    public QueueBaseOperation(int capacity) {
        array = new int[capacity];
    }

    public void demo() {
        try {
            enQueue(1);
            enQueue(3);
            enQueue(5);
            enQueue(7);
            enQueue(9);
            enQueue(7);
            System.out.println("入队后：");
            output();
            deQueue();
            deQueue();
            deQueue();
            System.out.println("出队后：");
            output();
            System.out.println("再入队：");
            enQueue(1);
            enQueue(3);
            enQueue(5);
            enQueue(7);
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void output() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[(front + i) % array.length] + " ");
        }
        System.out.println();
    }

    /**
     * 入队
     *
     * @param element 入队元素
     * @throws Exception 队列满了，抛出异常
     */
    public void enQueue(int element) throws Exception {
        if ((rear + 1) % array.length == front) {
            throw new Exception("队列已满！");
        }
        array[rear] = element;
        rear = (rear + 1) % array.length;
        size++;
    }

    /**
     * 出队
     *
     * @return 出队元素
     * @throws Exception 队列空了，抛出异常
     */
    public int deQueue() throws Exception {
        if (rear == front) {
            throw new Exception("队列已空！");
        }
        int deQueueElement = array[front];
        front = (front + 1) % array.length;
        size--;
        return deQueueElement;
    }

    public static void main(String[] args) {
        QueueBaseOperation operation = new QueueBaseOperation(10);
        operation.demo();
    }
}

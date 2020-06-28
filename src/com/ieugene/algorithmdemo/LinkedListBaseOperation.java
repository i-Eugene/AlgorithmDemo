package com.ieugene.algorithmdemo;

public class LinkedListBaseOperation {

    private Node head;//头节点
    private Node last;//尾节点
    private int size;//链表长度

    public void demo() {
        //插入数据
        insert(3, 0);
//        output();
        insert(5, 1);
//        output();
        insert(7, 2);
//        output();
        insert(9, 0);
//        output();
        insert(4, 3);
//        output();
        insert(2, 3);
//        output();
        insert(1, 1);
        System.out.println("插入数据后：");
        //读取数据
        output();
        //删除数据
        remove(0);
        remove(3);
//        remove(4);
        System.out.println("删除数据后：");
        output();
    }

    /**
     * 数据输出
     */
    public void output() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * 数据删除
     *
     * @param index 指定删除节点位置
     */
    public Node remove(int index) {
        checkIndexBounds(index);
        Node removedNode;
        if (index == 0) {//删除头节点
            removedNode = head;
            head = head.next;
        } else if (index == size - 1) {//删除尾节点
            Node prevNode = get(index-1);
            removedNode = prevNode.next;
            prevNode.next = null;
            last = prevNode;
        } else {
            Node prevNode = get(index-1);
            Node nextNode = prevNode.next.next;
            removedNode = prevNode.next;
            prevNode.next = nextNode;
        }
        size--;
        return removedNode;
    }

    /**
     * @param data  插入的数据
     * @param index 插入的位置
     */
    public void insert(int data, int index) {
        checkIndexBounds(index);
        Node insertedNode = new Node(data);
        if (size == 0) {
            head = insertedNode;
            last = insertedNode;
        } else if (index == 0) {
            insertedNode.next = head;
            head = insertedNode;
        } else {
            Node prevNode = get(index - 1);//查找数据
            Node nextNode = prevNode.next;
            insertedNode.next = nextNode;
            prevNode.next = insertedNode;
        }
        size++;
    }

    /**
     * 数据查找
     *
     * @param index 节点位置
     * @return 获取指定位置节点
     */
    private Node get(int index) {
        checkIndexBounds(index);
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    private void checkIndexBounds(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围！");
        }
    }

    /**
     * 单向链表
     */
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    /**
     * 双向链表
     */
    public static class NodeTW {
        int data;
        NodeTW next;
        NodeTW prev;

        NodeTW(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinkedListBaseOperation operation = new LinkedListBaseOperation();
        operation.demo();
    }
}

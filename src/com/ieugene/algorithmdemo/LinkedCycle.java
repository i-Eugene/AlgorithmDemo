package com.ieugene.algorithmdemo;

import com.ieugene.algorithmdemo.LinkedListBaseOperation.Node;

public class LinkedCycle {
    private int nodeSize = 0;//demo

    public void demo() {
        Node node1 = new Node(5);
        nodeSize++;
        Node node2 = new Node(3);
        nodeSize++;
        Node node3 = new Node(7);
        nodeSize++;
        Node node4 = new Node(2);
        nodeSize++;
        Node node5 = new Node(6);
        nodeSize++;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;
        System.out.println("链表环长度：" + cycleLength(node1));
        System.out.println("链表是否有环：" + hasCycle(node1));
    }

    public int cycleLength(Node head) {
        Node head1 = head;
        Node head2 = head;
        while (head1.next != null && head2.next.next != null) {
            head1 = head1.next;
            head2 = head2.next.next;
            if (head1 == head2) {
                head2 = head;
                break;
            }
        }
        int len = 0;
        while (head1.next != null && head1 != head2) {
            head1 = head1.next;
            head2 = head2.next;
            len++;
        }
        return nodeSize - len;
    }

    /**
     * 判断链表中是否有环
     *
     * @param head 链表头节点
     * @return 有环返回true，否则是false
     */
    public boolean hasCycle(Node head) {
        Node head1 = head;
        Node head2 = head;
        while (head1.next != null && head2.next.next != null) {
            head1 = head1.next;
            head2 = head2.next.next;
            if (head1 == head2) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedCycle cycle = new LinkedCycle();
        cycle.demo();
    }
}

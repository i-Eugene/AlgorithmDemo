package com.ieugene.algorithmdemo;

import java.util.Arrays;

public class BinaryTreeHeap {

    public void demo() {
        System.out.println("上浮前：");
        int[] array = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        System.out.println(Arrays.toString(array));
        upAdjust(array);
        System.out.println("上浮后：");
        System.out.println(Arrays.toString(array));
        System.out.println("无序数组：");
        array = new int[]{7, 1, 3, 10, 5, 2, 8, 9, 6};
        System.out.println(Arrays.toString(array));
        buildHeap(array);
        System.out.println("构建成二叉堆后：");
        System.out.println(Arrays.toString(array));
    }

    /**
     * 上浮（最小堆）
     * @param array 待调整数组
     */
    public void upAdjust(int[] array) {
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1) / 2;
        int temp = array[childIndex];
        while (childIndex > 0 && temp < array[parentIndex]) {
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    /**
     * 下浮（最小堆）
     * @param array 待调整数组
     * @param parentIndex 父节点位置
     */
    public void downAdjust(int[] array, int parentIndex) {
        int temp = array[parentIndex];
        int childIndex = parentIndex * 2 + 1;
        int length = array.length;
        while (childIndex < length) {
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }
            if (temp <= array[childIndex]) {
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = childIndex * 2 + 1;
        }
        array[parentIndex] = temp;
    }

    /**
     * 将无序数组构建二叉堆（最小堆）
     * @param array 无序的数组
     */
    public void buildHeap(int[] array) {
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i);
        }
    }

    public static void main(String[] args) {
        BinaryTreeHeap heap = new BinaryTreeHeap();
        heap.demo();
    }
}

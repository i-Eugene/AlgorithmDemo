package com.ieugene.algorithmdemo;

import java.util.Arrays;

public class QuickSort {

    public void demo() {
        int[] arr = {4, 4, 6, 5, 3, 2, 8, 1};
        System.out.println("排序前：" + Arrays.toString(arr));
//        quickSortBilateral(arr, 0, arr.length - 1);
        quickSortUnilateral(arr, 0, arr.length - 1);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    /**
     * 单边循环法快速排序
     *
     * @param arr        待排序数组
     * @param startIndex 起始位置
     * @param endIndex   结束位置
     */
    public void quickSortUnilateral(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) return;
        int pivotIndex = partitionUnilateral(arr, startIndex, endIndex);
        quickSortUnilateral(arr, startIndex, pivotIndex - 1);
        quickSortUnilateral(arr, pivotIndex + 1, endIndex);
    }

    /**
     * 单边循环法分治
     *
     * @param arr        待排序数组
     * @param startIndex 起始位置
     * @param endIndex   结束位置
     * @return 基准位置
     */
    private int partitionUnilateral(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int mark = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (arr[i] < pivot) {
                mark++;
                int temp = arr[i];
                arr[i] = arr[mark];
                arr[mark] = temp;
            }
        }
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }


    /**
     * 双边循环快速排序
     *
     * @param arr        待排序数组
     * @param startIndex 起始下标
     * @param endIndex   结束下标
     */
    public void quickSortBilateral(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) return;
        int pivotIndex = partitionBilateral(arr, startIndex, endIndex);
        quickSortBilateral(arr, startIndex, pivotIndex - 1);
        quickSortBilateral(arr, pivotIndex + 1, endIndex);
    }


    /**
     * 双边循环分治
     *
     * @param arr        待交换数组
     * @param startIndex 起始下标
     * @param endIndex   结束下标
     * @return
     */
    public int partitionBilateral(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];//也可以随机选择基准元素
        int left = startIndex;
        int right = endIndex;

        while (left != right) {
            while (right > left && arr[right] > pivot) {
                right--;
            }
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            if (arr[left] > arr[right]) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        arr[startIndex] = arr[left];
        arr[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        sort.demo();
    }
}

package com.ieugene.algorithmdemo;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {

    private int[] arr = {7, 8, 9, 1, 2, 3, 6, 5, 4};

    public void demo() {
//        int len = 100000;
//        arr = new int[len];
//        Random random = new Random();
//        for (int i = 0; i<len;i++){
//            arr[i] = random.nextInt();
//        }
        long start = System.currentTimeMillis();
//        baseSortAsc(arr);
//        optimalSortAsc(arr);
        cocktailSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("运行时长：" + (end - start));
        System.out.println("排序结果：" + Arrays.toString(arr));
    }

    /**
     * 鸡尾酒排序,适用于大部分元素有序的情况
     *
     * @param array 待排序数组
     */
    public void cocktailSort(int[] array) {
        int tmp = 0;
        for (int i = 0; i < array.length / 2; i++) {
            boolean isSorted = true;
            //左半边右移
            for (int j = i; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    isSorted = false;
                }
            }
            if (isSorted) break;
            isSorted = true;
            //右半边左移
            for (int j = array.length - i - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                    isSorted = false;
                }
            }
            if (isSorted) break;
        }
    }

    /**
     * 二次优化的冒泡排序（升序）
     *
     * @param array 待排序数组
     */
    public static void optimalSortAsc(int[] array) {
        int sortBorder = array.length - 1;//记录无序边界
        int sortBorderTemp = 0;
        for (int i = 0; i < array.length; i++) {
            boolean isSorted = true;//有序标记
            for (int j = 0; j < sortBorder; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSorted = false;
                    sortBorderTemp = j;
                }
            }
            sortBorder = sortBorderTemp;
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 无优化的冒泡排序(升序)
     *
     * @param array 待排序数组
     */
    private static void baseSortAsc(int array[]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        sort.demo();
    }
}

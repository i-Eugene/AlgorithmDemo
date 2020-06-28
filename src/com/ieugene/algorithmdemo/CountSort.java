package com.ieugene.algorithmdemo;

import java.util.Arrays;

public class CountSort {

    public void demo() {
        int[] arr = {95, 94, 91, 98, 99, 90, 99, 93, 91, 92};
        System.out.println(Arrays.toString(countSort(arr)));
    }

    public int[] countSort(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        int d = max - min;
        //创建统计数组并统计元素个数
        int[] countArray = new int[d + 1];
        for (int i = 0; i < arr.length; i++) {
            countArray[arr[i] - min]++;
        }
        //变形处理
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }
        //根据统计数组得出排序后数组
        int[] sortedArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sortedArray[countArray[arr[i] - min] - 1] = arr[i];
            countArray[arr[i] - min]--;
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        CountSort countSort = new CountSort();
        countSort.demo();
    }
}

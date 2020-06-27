package com.ieugene.algorithmdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class BucketSort {

    public void demo() {
        double[] arr = {4.12, 6.421, 0.0023, 3.0, 2.123, 8.122, 4.12, 10.09};
        System.out.println(Arrays.toString(bucketSort(arr)));
    }

    public double[] bucketSort(double[] array) {
        double max = array[0];
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        //初始化桶
        int bucketNum = array.length;
        double d = max - min;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<Double>());
        }
        //向桶中填充元素
        for (int i = 0; i < array.length; i++) {
            //找出桶的位置（有点难理解）
            int index = (int) ((array[i] - min) * (bucketNum - 1) / d);
            //放入桶中
            bucketList.get(index).add(array[i]);
        }
        //排序
        for (int i = 0; i < bucketList.size(); i++) {
            Collections.sort(bucketList.get(i));
        }
        //输出
        double[] sortedArray = new double[array.length];
        int index = 0;
        for (LinkedList<Double> list : bucketList) {
            for (double element : list) {
                sortedArray[index] = element;
                index++;
            }
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        BucketSort sort = new BucketSort();
        sort.demo();
    }
}

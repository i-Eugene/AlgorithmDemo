package com.ieugene.algorithmdemo;

import java.util.Arrays;

public class FindLostNumber {

    public void demo() {
        int[] array = {4, 1, 2, 2, 5, 1, 4, 3};
        System.out.println("两个数是：" + Arrays.toString(findLostNumber(array)));
    }

    public int[] findLostNumber(int[] array) {
        //存储结果
        int[] reslut = new int[2];
        //第一次做整体异或运算
        int xorResult = 0;
        for (int i = 0; i < array.length; i++) {
            xorResult ^= array[i];
        }
        if (xorResult == 0) return null;//等于0说明输入数据不符合题要求
        //确定两个整数的不同位，以此来做分组
        int separator = 1;
        while (0 == (xorResult & separator)) {
            separator <<= 1;
        }
        //第二次分组，进行异或运算
        for (int i = 0; i < array.length; i++) {
            if (0 == (array[i] & separator)) {
                reslut[0] ^= array[i];
            } else {
                reslut[1] ^= array[i];
            }
        }
        return reslut;
    }

    public static void main(String[] args) {
        new FindLostNumber().demo();
    }
}

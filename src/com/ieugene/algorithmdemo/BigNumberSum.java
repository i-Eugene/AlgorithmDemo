package com.ieugene.algorithmdemo;

import java.util.Arrays;

public class BigNumberSum {

    final int MAX_LENGTH = 9;
    final int CARRY_VALUE = 1000000000;

    public void demo() {
        System.out.println(bigNumberSum("987654321987654321987", "222234567891"));
    }

    public String bigNumberSum(String bigNumberA, String bigNumberB) {
        //拆分大数字
        int[] arrayA = splitBigNumber(bigNumberA);
        int[] arrayB = splitBigNumber(bigNumberB);
        //创建与最大数字等长的数组，用于接收计算结果
        int[] arraySum = new int[Math.max(arrayA.length, arrayB.length)];
        System.out.println("array A: " + Arrays.toString(arrayA));
        System.out.println("array B: " + Arrays.toString(arrayB));
        int minLen = Math.min(arrayA.length, arrayB.length);
        //判断是否需要进位
        boolean isCarry = false;
        for (int i = 0; i < minLen; i++) {
            arraySum[i] = arrayA[i] + arrayB[i];
            if (isCarry) {
                arraySum[i] += 1;
                isCarry = false;
            }
            if (arraySum[i] >= CARRY_VALUE) {
                arraySum[i] -= CARRY_VALUE;
                isCarry = true;
            }
        }
        for (int i = minLen; i < arraySum.length; i++) {
            if (arrayA.length > arrayB.length) {
                arraySum[i] = arrayA[i];
            } else {
                arraySum[i] = arrayB[i];
            }
            if (isCarry) {
                arraySum[i] += 1;
                isCarry = false;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = arraySum.length - 1; i >= 0; i--) {
            if (arraySum[i] == 0) {
                builder.append("000000000");
            } else {
                builder.append(arraySum[i]);
            }

        }
        return builder.toString();
    }

    private int[] splitBigNumber(String number) {
        int length = getArrayLength(number);
        int[] array = new int[length];
        int end = number.length();
        int start;
        for (int i = 0; i < length; i++) {
            start = Math.max(end - MAX_LENGTH, 0);
            array[i] = Integer.parseInt(number.substring(start, end));
            end = start;
        }
        return array;
    }


    private int getArrayLength(String number) {
        int len = 1;
        if (number.length() > MAX_LENGTH) {
            len = number.length() / MAX_LENGTH;
            if (number.length() % MAX_LENGTH != 0)
                len++;
        }
        return len;
    }

    public static void main(String[] args) {
        new BigNumberSum().demo();
    }
}

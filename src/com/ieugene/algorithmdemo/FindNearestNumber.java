package com.ieugene.algorithmdemo;

import java.util.Arrays;

public class FindNearestNumber {

    public void demo() {
//        int[] numbers = {1, 2, 3, 4, 5};
//        int[] numbers = {1, 2, 3, 5, 4};
        int[] numbers = {1, 2, 3, 5, 4, 7, 9};
        System.out.println(Arrays.toString(findNearestNumber(numbers)));
    }

    public int[] findNearestNumber(int[] numbers) {
        //从后向前查找逆序边界
        int index = findTransferPoint(numbers);
        //复制并入参，避免直接修改入参
        int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
        //如果边界值是0，说明当前是最小值
        if (index == 0) return reverseLast(numbersCopy);
        //把逆序区域的前一位和逆序区域中刚刚大于它的数字交换位置
        exchangeHead(numbersCopy, index);
        //把原来逆序区转为顺序
        reverse(numbersCopy, index);
        return numbersCopy;
    }


    private int[] reverseLast(int[] numbers) {
        int len = numbers.length;
        int temp = numbers[len - 1];
        numbers[len - 1] = numbers[len - 2];
        numbers[len - 2] = temp;
        return numbers;
    }

    private int findTransferPoint(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i - 1] > numbers[i]) {
                return i - 1;
            }
        }
        return 0;
    }

    private int[] exchangeHead(int[] number, int index) {
        int head = number[index - 1];
        int nearestIndex = 0;
        int min = Integer.MAX_VALUE;
        for (int i = number.length - 1; i >= index; i--) {
            if (head < number[i] && (number[i] - head) < min) {
                nearestIndex = i;
                min = number[i] - head;
            }
        }
        number[index - 1] = number[nearestIndex];
        number[nearestIndex] = head;
        return number;
    }

    private int[] reverse(int[] number, int index) {
        for (int i = index; i < number.length; i++) {
            boolean isSorted = true;
            for (int j = index; j < number.length - 1; j++) {
                if (number[j] > number[j + 1]) {
                    int temp = number[j];
                    number[j] = number[j + 1];
                    number[j + 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) break;
        }
        return number;
    }

    public static void main(String[] args) {
        FindNearestNumber nearestNumber = new FindNearestNumber();
        nearestNumber.demo();
    }


}

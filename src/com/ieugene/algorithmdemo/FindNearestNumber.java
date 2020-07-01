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
        if (index == 0) return null;
        //把逆序区域的前一位和逆序区域中刚刚大于它的数字交换位置
        exchangeHead(numbersCopy, index);
        //把原来逆序区转为顺序
        reverse(numbersCopy, index);
        return numbersCopy;
    }

    private static int findTransferPoint(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i] > numbers[i - 1]) {
                return i;
            }
        }
        return 0;
    }

    private static int[] exchangeHead(int[] numbers, int index) {
        int head = numbers[index - 1];
        for (int i = numbers.length - 1; i > 0; i--) {
            if (head < numbers[i]) {
                numbers[index - 1] = numbers[i];
                numbers[i] = head;
                break;
            }
        }
        return numbers;
    }

    private static int[] reverse(int[] num, int index) {
        for (int i = index, j = num.length - 1; i < j; i++, j--) {
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }
        return num;
    }

    public static void main(String[] args) {
        FindNearestNumber nearestNumber = new FindNearestNumber();
        nearestNumber.demo();
    }


}

package com.ieugene.algorithmdemo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DivideRedPackage {

    public void demo() {
        List<Integer> amountList = divideRedPackage(1000, 10);
        for (Integer amount : amountList) {
            System.out.println("抢到的金额：" + new BigDecimal(amount).divide(new BigDecimal(100)));
        }
    }

    public List<Integer> divideRedPackage(Integer totalAmount, Integer totalPeopleNum) {
        List<Integer> amountList = new ArrayList<>();
        Integer restAmount = totalAmount;
        Integer restPeopleNum = totalPeopleNum;
        Random random = new Random();
        for (int i = 0; i < totalPeopleNum - 1; i++) {
            int amount = random.nextInt(restAmount / restPeopleNum * 2 - 2) + 1;
            restAmount -= amount;
            restPeopleNum--;
            amountList.add(amount);
        }
        amountList.add(restAmount);
        return amountList;
    }

    public static void main(String[] args) {
        new DivideRedPackage().demo();
    }
}

package com.ieugene.algorithmdemo;

public class GreatestCommonDivisor {

    public void demo() {
        System.out.println(getGCD(25, 5));
        System.out.println(getGCD(100, 80));
        System.out.println(getGCD(27, 14));

        System.out.println(getGCD2(25, 5));
        System.out.println(getGCD2(100, 80));
        System.out.println(getGCD2(27, 14));

        System.out.println(getGCD3(25, 5));
        System.out.println(getGCD3(100, 80));
        System.out.println(getGCD3(27, 14));
    }

    public int getGCD(int a, int b) {
        if (a == b) return a;
        if ((a & 1) == 0 && (b & 1) == 0) {
            return getGCD(a >> 1, b >> 1) << 1;
        } else if ((a & 1) == 0 && (b & 1) != 0) {
            return getGCD(a >> 1, b);
        } else if ((a & 1) != 0 && (b & 1) == 0) {
            return getGCD(a, b >> 1);
        } else {
            int big = Math.max(a, b);
            int small = Math.min(a, b);
            return getGCD(big - small, small);
        }
    }

    /**
     * 辗转相除法
     *
     * @param a 正整数
     * @param b 正整数
     * @return 最大公约数
     */
    public int getGCD2(int a, int b) {
        int big = Math.max(a, b);
        int small = Math.min(a, b);
        if (big % small == 0) return small;
        return getGCD2(big % small, small);
    }

    /**
     * 更相减损术
     *
     * @param a 正整数
     * @param b 正整数
     * @return 最大公约数
     */
    public int getGCD3(int a, int b) {
        if (a == b) return a;
        int big = Math.max(a, b);
        int small = Math.min(a, b);
        return getGCD3(big - small, small);
    }

    public static void main(String[] args) {
        GreatestCommonDivisor divisor = new GreatestCommonDivisor();
        divisor.demo();
    }
}

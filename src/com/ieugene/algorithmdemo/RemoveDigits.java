package com.ieugene.algorithmdemo;

public class RemoveDigits {

    public void demo() {
        System.out.println(removeDigits("1593212", 3));
        System.out.println(removeDigits("30200", 1));
        System.out.println(removeDigits("10", 2));
        System.out.println(removeDigits("541270936", 3));
    }

    public String removeDigits(String num, int k) {
        //创建一个栈用于接收所有数字
        char[] stack = new char[num.length()];
        int top = 0;
        for (int i = 0; i < num.length(); i++) {
            //遍历当前数字
            char c = num.charAt(i);
            //当栈顶数字大于当前遍历的数字，栈顶出栈，新数字入栈
            while (top > 0 && stack[top - 1] > c && k > 0) {
                k -= 1;
                top -= 1;
            }
            stack[top++] = c;
        }
        //找出栈底开始都是0的位置
        int offset = 0;
        int newLen = num.length() - k;
        while (offset < newLen && stack[offset] == '0') {
            offset++;
        }
        return offset == newLen ? "0" : new String(stack, offset, newLen - offset);
    }

    public static void main(String[] args) {
        new RemoveDigits().demo();
    }
}

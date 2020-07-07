package com.ieugene.algorithmdemo;

public class Bitmap {
    //每一个word是一个long类型元素，对应一个64位二进制数据
    private long[] words;
    //Bitmap的位数大小
    private int size;

    public Bitmap(int size) {
        this.size = size;
        this.words = new long[(getWordIndex(size - 1)) + 1];
    }

    /**
     * 判单Bitmap某一位状态
     *
     * @param bitIndex 位图的第bitIndex位（bitIndex=0表示Bitmap左数第一位）
     * @return
     */
    public boolean getBit(int bitIndex) {
        checkBounds(bitIndex);
        int wordIndex = getWordIndex(bitIndex);
        return (words[wordIndex] & (1L << bitIndex)) != 0;
    }

    private void checkBounds(int index) {
        if (index < 0 || index > this.size - 1) {
            throw new IndexOutOfBoundsException("超过Bitmap的有效范围");
        }
    }

    /**
     * 把Bitmap的某一位设置为true
     *
     * @param bitIndex 位图的第bitIndex位（bitIndex=0表示Bitmap左数第一位）
     */
    public void setBit(int bitIndex) {
        checkBounds(bitIndex);
        int wordIndex = getWordIndex(bitIndex);
        words[wordIndex] |= (1L << bitIndex);
    }

    /**
     * 定位Bitmap某一位所对应的word
     *
     * @param bitIndex 位图的第bitIndex位（bitIndex=0表示Bitmap左数第一位）
     * @return
     */
    private int getWordIndex(int bitIndex) {
        return bitIndex >> 6;
    }

    public static void main(String[] args) {
        Bitmap bitmap = new Bitmap(128);
        bitmap.setBit(126);
        bitmap.setBit(75);
        System.out.println(bitmap.getBit(126));
        System.out.println(bitmap.getBit(78));
    }
}

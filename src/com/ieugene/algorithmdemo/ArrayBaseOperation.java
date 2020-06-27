package com.ieugene.algorithmdemo;

import java.util.Arrays;

public class ArrayBaseOperation {

    //数组定义
    private int[] array = new int[]{3, 1, 2, 5, 4, 9, 7, 2};
    //记录元素个数
    private int size = array.length;

    private void demo() {
        //读取
        System.out.println("原始数据：");
        output();
        //更新
        array[2] = 10;
        //插入
        insert(8, 2);
        System.out.println("插入后的数据：");
        output();

        //删除
        delete(5);
        System.out.println("删除后的数据：");
        output();

    }

    /**
     * 删除操作
     *
     * @param index 删除的位置
     * @return
     */
    public int delete(int index) {
        checkIndexBounds(index);
        int deletedElement = array[index];
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return deletedElement;
    }

    private void output(){
//        for (int i = 0; i < size; i++) {
//            System.out.print(array[i] + " ");
//        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * 插入操作
     *
     * @param element 插入的元素
     * @param index   插入的位置
     */
    public void insert(int element, int index) {
        checkIndexBounds(index);
        if (size >= array.length) {
            //扩容
            resize();
        }
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
    }

    private void checkIndexBounds(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出数组实际元素范围!");
        }
    }

    /**
     * 扩容
     */
    private void resize() {
        int[] arrayNew = new int[array.length * 2];
        System.arraycopy(array, 0, arrayNew, 0, array.length);
        array = arrayNew;
    }

    /**
     * @return 获取元素个数
     */
    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        ArrayBaseOperation operation = new ArrayBaseOperation();
        operation.demo();
    }
}

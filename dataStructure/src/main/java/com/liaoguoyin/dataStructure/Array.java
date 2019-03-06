package com.liaoguoyin.dataStructure;

/**
 * 数组Array
 * 实现了:初始化、增加元素、删除元素、查找、更新、输出、排序
 */
public class Array {
    private int[] intArray;
    private int elems;
    private int length;

    public Array(int max) {
        length = max;
        intArray = new int[length];
        elems = 0;
    }

    public static void main(String[] args) {
        Array arr = new Array(5);
        // 初始化
        arr.add(234);
        arr.add(32);
        arr.add(312);
        arr.add(324);
        arr.display();
        arr.insertSort();
    }

    /**
     * 添加
     *
     * @param value
     */
    public void add(int value) {
        if (elems >= length) {
            System.out.println("error");
            return;
        }
        intArray[elems] = value;
        elems++;
    }

    /**
     * 查找
     *
     * @param searchKey
     * @return
     */
    public int find(int searchKey) {
        int i;
        for (i = 0; i < elems; i++) {
            if (searchKey == intArray[i]) {
                break;
            }
        }
        if (i == elems) {
            return -1;
        }
        return i;
    }

    /**
     * 删除
     *
     * @param value
     * @return
     */
    public boolean delete(int value) {
        int i = find(value);
        if (i == -1) {
            return false;
        }
        for (int j = i; j < elems - 1; j++) {
            intArray[j] = intArray[j + 1];
        }
        elems--;
        return true;
    }

    /**
     * 更新
     *
     * @param oldValue
     * @param newValue
     * @return
     */
    public boolean update(int oldValue, int newValue) {
        int i = find(oldValue);
        if (i == -1) {
            return false;
        }
        intArray[i] = newValue;
        return true;
    }

    /**
     * 显示所有
     */
    public void display() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < elems; i++) {
            if (i == 0) {
                stringBuilder.append("[");
            }
            if (i == elems - 1) {
                stringBuilder.append(intArray[i]).append("]");
            } else {
                stringBuilder.append(intArray[i]).append(", ");
            }
        }
        System.out.println(stringBuilder.toString());
    }

    /**
     * 冒泡排序
     * 从大排到小
     */
    public void bubleSort() {
        for (int i = 0; i < elems - 1; i++) {
            for (int j = 0; j < elems - i; j++) {
                if (intArray[j] < intArray[j + 1]) {
                    // 交换
                    int tmp = intArray[j];
                    intArray[j] = intArray[j + 1];
                    intArray[j + 1] = tmp;
                }
            }
        }
        display();
    }

    /**
     * 选择排序
     * 每一趟找出一个最大数/最小数
     */
    public void selectSort() {
        for (int i = 0; i < elems; i++) {
            int max = i;
            // 从i+1开始找里面比max还大的数,准备和max交换
            for (int j = i + 1; j < elems; j++) {
                if (intArray[max] < intArray[j]) {
                    max = j;
                }
            }

            // 如果i不是max,则交换
            if (i != max) {
                int tmp = intArray[i];
                intArray[i] = intArray[max];
                intArray[max] = tmp;
            }
        }
        display();
    }

    /**
     * 插入排序
     */
    public void insertSort() {
        for (int i = 1; i < elems; i++) {
            int tmp = intArray[i];
            int j = i - 1;
            // 给本次的tmp元素找位置
            while (j > 0 && tmp > intArray[j]) {
                intArray[j + 1] = intArray[j];
                j--;
            }
            intArray[j + 1] = tmp;
        }
        display();
    }
}

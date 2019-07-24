package algorithms.sort;

import java.util.Arrays;

/**
 * 1. 选择排序
 * 原理就是每一次从待排序的数据元素中选出最小(或最大)值放在序列的起始位置
 * 过程：
 *  每次遍历选择出最小(大)值和当前位置(i)做交换
 * 不稳定排序:
 *   栗子: 序列 {2, 2, 1}。在第一轮会将 第一位的2 和 第三位的1 交换, 两个2 顺序发生变化了
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 1, 4, 9, 10, 100, 11, 23, 15};

        Arrays.stream(selectionSort(arr)).forEach(System.out::println);
    }

    static int[] selectionSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[minIndex] > arr[j]) minIndex = j;
            }
            if (i != minIndex) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }

        return arr;
    }

}

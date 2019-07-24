package algorithms.sort;

import java.util.Arrays;

/**
 * 2. 冒泡排序
 * 稳定排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 1, 4, 9, 10, 100, 11, 23, 15};

        Arrays.stream(bubbleSort(arr)).forEach(System.out::println);
    }

    static int[] bubbleSort(int[] arr) {
        int len = arr.length;
        boolean isSorted = false;

        for (int i = 0; i < len - 1 && !isSorted; i++) {
            isSorted = true;
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    isSorted = false;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        return arr;
    }
}

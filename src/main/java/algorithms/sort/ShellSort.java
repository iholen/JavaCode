package algorithms.sort;

import java.util.Arrays;

/**
 * 4. 希尔排序
 * 不稳定排序
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 1, 4, 9, 10, 100, 11, 23, 15};

        Arrays.stream(shellSort(arr)).forEach(System.out::println);
    }

    static int[] shellSort(int[] arr) {
        int len = arr.length;
        int step = len / 2;

        while (step >= 1) {
            for (int i = step; i < len; i++) {
                int current = arr[i];
                for (int j = i - step; j >= 0 && arr[j] > current; j -= step) {
                    arr[j + step] = arr[j];
                    arr[j] = current;
                }
            }

            step /= 2;
        }

        return arr;
    }

}

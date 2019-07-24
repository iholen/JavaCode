package algorithms.sort;

import java.util.Arrays;

/**
 * 3. 插入排序
 * 稳定排序，相等的元素顺序不会变化
 * 算法:
 * 1. 从第一个元素开始，该元素可以认为已经被排序
 * 2. 取出下一个元素，在已经排序的元素序列中从后向前扫描
 * 3. 如果该元素（已排序）大于新元素，将该元素移到下一位置
 * 4. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
 * 5. 将新元素插入到该位置后
 * 6. 重复步骤2~5
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 1, 4, 9, 10, 100, 11, 23, 15};

        Arrays.stream(insertionSort(arr)).forEach(System.out::println);
    }

    static int[] insertionSort(int[] arr) {
        int len = arr.length;

        for (int i = 1; i < len; i++) { // 从第一个元素开始
            int current = arr[i];
            for (int j = i - 1; j >= 0 && current < arr[j]; j--) { // 倒序遍历 已排序的数组
                /**
                 * current < arr[j] 条件表示：
                 * 若 当前的元素 小于 已排序数组中j位置的元素。
                 * 之后 将j位置元素后移一个位置
                */
                arr[j + 1] = arr[j];
                arr[j] = current;
            }
        }

        return arr;
    }

}

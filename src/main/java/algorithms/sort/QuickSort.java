package algorithms.sort;

import java.util.Arrays;

/**
 * 快排
 *
 * 算法步骤:
 * 1. 挑选基准值(从数列中挑选一个元素，称为"基准"[pivot])
 * 2. 分割：重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（与基准值相等的数可以到任何一边）。在这个分割结束之后，对基准值的排序就已经完成，
 * 3. 递归排序子序列：递归地将小于基准值元素的子序列和大于基准值元素的子序列排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {1,2,3,0,2,3,9,5,6,4,1,2};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int start, int end) {
        int length = end - start;
        if (arr == null || length < 1) {
            return;
        }

        int head = start;
        int tail = end;
        int pivot = arr[start];
        while(start <= end) {
            // 从左边查找到比基准值大的元素
            while (arr[start] < pivot) {
                start++;
            }
            // 从右边查找到比基准值小的元素
            while (arr[end] > pivot) {
                end--;
            }

            if (start < end) {
                // 满足左指针位于右指针的左边，交换元素值
                int temp = arr[start];
                arr[start++] = arr[end];
                arr[end--] = temp;
            } else if (start == end) {
                // 指针重合时的处理
                start++;
            }
        }

        sort(arr, head, end);
        sort(arr, start, tail);
    }

}

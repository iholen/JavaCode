package algorithms.swordoffer;

/**
 * 数组中重复的数字
 *
 * 题目描述:
 *  在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内
 *  数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次
 *  请找出数组中任意一个重复的数字。
 *
 * @author huliang
 * @date 2019-07-09 16:51
 */
public class Code003 {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 0, 2, 5};
        System.out.println(duplicate(arr, 6));
    }

    static int duplicate(int[] arr, int length) {
        int num;
        for (int i = 0; i < length; i++) {
            while(arr[i] != i) {
                if (arr[i] == arr[arr[i]]) {
                    return arr[i];
                }
                num = arr[i];
                arr[i] = arr[arr[i]];
                arr[num] = num;
            }

            i++;
        }

        return -1;
    }
}

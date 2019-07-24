package algorithms.swordoffer;

/**
 * 二维数组中的查找
 *
 * 题目描述:
 *  给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 *
 * @author huliang
 * @date 2019-07-09 16:51
 */
public class Code004 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 31;
        System.out.println(exist(arr, target));
    }

    static boolean exist(int[][] arr, int target) {
        for (int i = 0, j = 4; i < 5 && j >= 0;) {
            if (arr[i][j] == target) {
                return true;
            } else if (arr[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}

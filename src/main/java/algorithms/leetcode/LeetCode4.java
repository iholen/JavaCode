package algorithms.leetcode;

/**
 * Median of Two Sorted Arrays
 */
public class LeetCode4 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3}, nums2= {2, 3, 4};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, len = m + n;
        boolean isOdd = len % 2 == 1; // 是否是奇数

        int[] pointStart = {0, 0}, pointEnd = {m - 1, n - 1};
        int leftLen = isOdd ? 1 : 2;

        while (pointEnd[0] - pointStart[0] + pointEnd[1] - pointStart[1] + 2 != leftLen) {
            // 若 min 指针 移到 max 指针 后面， 则两个指针都不再移动了。
            boolean isEmpty1 = pointStart[0] > pointEnd[0];
            boolean isEmpty2 = pointStart[1] > pointEnd[1];

            if (!isEmpty1 && isEmpty2) { // 数组1还有空间
                pointStart[0]++;
                pointEnd[0]--;
            } else if (isEmpty1 && !isEmpty2) { // 数组2还有空间
                pointStart[1]++;
                pointEnd[1]--;
            } else { // 都有空间
                int numMin1 = nums1[pointStart[0]];
                int numMin2 = nums2[pointStart[1]];

                if (numMin1 <= numMin2) pointStart[0]++;
                else pointStart[1]++;

                int numMax1 = nums1[pointEnd[0]];
                int numMax2 = nums2[pointEnd[1]];
                if (numMax1 <= numMax2) pointEnd[1]--;
                else pointEnd[0]--;
            }

        }

        int i, sum = 0;
        for (i = pointStart[0]; i <= pointEnd[0]; i++) sum += nums1[i];
        for (i = pointStart[1]; i <= pointEnd[1]; i++) sum += nums2[i];

        return  sum/(leftLen * 1.0);
    }

}

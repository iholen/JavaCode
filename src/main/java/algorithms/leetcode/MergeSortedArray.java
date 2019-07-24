package algorithms.leetcode;

public class MergeSortedArray {

    public static void main(String[] args) {
        int[] arr1 = {0,1,2,3,0,0,0,0,0};
        int m = 4;
        int[] arr2 = {-1,1,2,3,7};
        int n = 5;

        MergeSortedArray array = new MergeSortedArray();
        int[] r = array.merge(arr1, m, arr2, n);

        System.out.print("[");
        for (int i = 0; i < r.length; i++) {
            System.out.print(r[i] + " ");
        }
        System.out.print("]");
        System.out.println();
    }

    int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int[] numsA = new int[m];
        int i = 0;
        int j = 0;

        for (int k = 0; k < m + n; k++) {
            if (k < m) numsA[k] = nums1[k];

            if (i == m && j < n) {
                nums1[k] = nums2[j++];
                continue;
            }
            if (j == n && i < m) {
                nums1[k] = numsA[i++];
                continue;
            }

            nums1[k] = numsA[i] > nums2[j] ? nums2[j++] : numsA[i++];
        }

        return nums1;
    }

}

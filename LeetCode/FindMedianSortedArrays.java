/**
 * 题目：寻找两个有序数组的中位数
 * <p>
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3] nums2 = [2]
 * <p>
 * 则中位数是 2.0 示例 2:
 * <p>
 * nums1 = [1, 2] nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 *
 * 思考：将两个有序数组合并成一个有序数组，时间复杂度为log(m+n)
 */
public class FindMedianSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1 == null) {
            return getValue(nums2, nums2.length);
        }
        if (nums2 == null) {
            return getValue(nums1, nums1.length);
        }
        int m = nums1.length;
        int n = nums2.length;
        int[] arr = new int[m + n];
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                arr[k--] = nums2[j--];
            } else {
                arr[k--] = nums1[i--];
            }
        }
        while (i >= 0) {
            arr[k--] = nums1[i--];
        }
        while (j >= 0) {
            arr[k--] = nums2[j--];
        }
        return getValue(arr, arr.length);
    }

    static double getValue(int[] arr, int n) {
        double res;
        if (n % 2 == 0) {
            res = (arr[n / 2 - 1] + arr[n / 2]) * 1.0 / 2;
        } else {
            res = arr[n / 2];
        }
        return res;
    }
}

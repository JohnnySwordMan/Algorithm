/**
 * 题目：二分查找
 * 题目描述：给定一个整数数组A及它的大小n，同时给定要查找的元素val，请返回它在数组中的位置(从0开始)，若不存在该元素，返回-1。若该元素出现多次，请返回第一次出现的位置。
 *
 * 该题与剑指Offer"数字在排序数组中出现的次数"类似，参考/algorithm/JZOffer/GetNumberOfK.java 
 *
 * @author geyan
 *
 */
public class BinarySearch {

	public int getPos(int[] A, int n, int val) {
		if (A == null || n <= 0) {
			return -1;
		}
		int start = 0, end = n - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (A[mid] < val) {
				start = mid + 1;
			} else if (A[mid] > val) {
				end = mid - 1;
			} else {
				// 当A[mid] == val时，继续向前遍历
				if (mid - 1 >= start && A[mid - 1] == val) {
					end = mid - 1;
				} else {
					return mid;
				}
			}
		}
		return -1;
	}

}

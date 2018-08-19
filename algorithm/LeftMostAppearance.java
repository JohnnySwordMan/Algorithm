/**
 * 二分法练习 
 * 题目：元素最左出现 
 * 题目描述：对于一个有序数组arr，再给定一个整数num，请在arr中找到num这个数出现的最左边的位置。
 * 给定一个数组arr及它的大小n，同时给定num。请返回所求位置。若元素在数组中未出现，请返回-1。
 * 
 * @author geyan
 *
 */
public class LeftMostAppearance {

	/**
	 * 普通做法：遍历，当第一次遍历到与num相等的元素时结束，返回下标。这样做，其实忽略了给定的有序数组这个条件。时间复杂度为O(N)。
	 */
	public int findPos_1(int[] arr, int n, int num) {
		if (arr == null || n < 0)
			return -1;
		for (int i = 0; i < n; i++) {
			if (num == arr[i])
				return i;
		}
		return -1;
	}

	/**
	 * 最优解：二分法，时间复杂度为O(logN)。别忽略有序数组条件
	 */
	public int findPos_2(int[] arr, int n, int num) {
		if (arr == null || n < 0)
			return -1;
		int left = 0, right = n - 1;
		int res = -1;
		while (left <= right) {
			// 尽量不用(left+right)/2，防止left+right过大
			int mid = left + (right - left) / 2;
			if (arr[mid] < num) {
				left = mid + 1;
			} else if (arr[mid] > num) {
				right = mid - 1;
			} else {
				// 假设此时相等，只能知道arr[mid]与num是相等的，但是还不能确定是不是最左边，所以先记录下此时的下标，但是还需要继续判断，直到left>right为止
				res = mid;
				right = mid - 1;
			}
		}
		return -1;
	}
}

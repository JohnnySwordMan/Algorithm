/**
 * 题目：最左原位
 * 题目描述：有一个有序数组arr，其中不含有重复元素，请找到满足arr[i]==i条件的最左的位置。如果所有位置上的数都不满足条件，返回-1。
 * 给定有序数组arr及它的大小n，请返回所求值。
 * 
 * 注意： 
 * 1.该题和元素最左出现题目是类似的，在使用二分法查找到元素的时候，并不能停止循环，因为需要查找到最左元素，所以right = mid-1
 * 2.这类题目都可以用遍历数组来完成，但是时间复杂度为O(N)，并不是最优解 
 * 3.不能忽视其是有序数组，往往遇到有序数组，那么考虑是否可以使用二分法
 * 
 * @author geyan
 *
 */
public class Find {

	/**
	 * 1.考虑边界条件 
	 * 2.二分法，判断arr[mid]与mid的大小关系
	 */
	public int findPos(int[] arr, int n) {
		if (arr == null || n < 0)
			return -1;
		int left = 0, right = n - 1;
		int res = -1;
		if (arr[left] > left) {
			// left是严格以1递增的，而arr数组是至少以1递增，如果arr[left]>left，那么是不可能存在arr[i] == i的
			return -1;
		}
		if (arr[right] < right) {
			// 同理
			return -1;
		}
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] < mid) {
				// 应该在右半部份查找
				left = mid + 1;
			} else if (arr[mid] > mid) {
				right = mid - 1;
			} else {
				// 即使找到arr[mid] = mid，并不代表循环的结束，因为需要找出最左元素
				res = mid;
				right = mid - 1;
			}
		}
		return res;
	}
}

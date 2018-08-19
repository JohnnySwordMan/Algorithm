/**
 * 面试题38：数字在排序数组中出现的次数
 * 题目描述：统计一个数字在排序数组中出现的次数。例如输入排序数组{1,2,3,3,3,3,4,5}和数字3，由于3在这个数组中出现了4次，因此输出4。
 * 
 * @author geyan
 *
 */
public class GetNumberOfKInArray {

	/**
	 * 方法一：遍历数组，时间复杂度为O(N) 
	 * 忽视了有序数组这个条件
	 */
	public int getNumberOfK_1(int[] array, int k) {
		if (array == null || array.length <= 0)
			return 0;
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (k == array[i]) {
				count++;
			}
		}
		return count;
	}

	/**
	 * 方法二：时间复杂度为O(logN) 
	 * 看到有序，应该立马想起二分法
	 */
	public int getNumbersOfK_2(int[] array, int k) {
		if (array == null || array.length <= 0)
			return 0;
		/*
		 * int left = 0, right = array.length - 1; 
		 * int mid = left + (right - left) / 2; 
		 * while (left <= right) { 
		 * 	if (array[mid] > k) { 
		 * 		right = mid - 1; 
		 * 	} else if (array[mid] < k) { 
		 * 		left = mid + 1; 
		 * 	} else { 
		 * 		// mid左右还有元素等于k的情况怎么写，我写不下去了。 
		 * 	} 
		 * }
		 */
		int firstK = getFirst(array, k, 0, array.length - 1);
		int lastK = getLast(array, k, 0, array.length - 1);
		if (firstK != -1 && lastK != -1) {
			return lastK - firstK + 1;
		}
		return 0;
	}

	// 当array[mid] == k时，继续找出0~mid-1位置上第一次出现k的下标
	private int getFirst(int[] array, int k, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = start + (end - start) / 2;
		if (array[mid] > k) {
			return getFirst(array, k, start, mid - 1);
		} else if (array[mid] < k) {
			return getFirst(array, k, mid + 1, end);
		} else {
			// 当array[mid] == k
			if (mid - 1 >= start && array[mid - 1] == k) {
				return getFirst(array, k, start, mid - 1);
			} else {
				return mid;
			}
		}
	}

	private int getLast(int[] array, int k, int start, int end) {
		if (start > end) {
			return -1;
		}
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (array[mid] > k) {
				end = mid - 1;
			} else if (array[mid] < k) {
				start = mid + 1;
			} else {
				// 当array[mid] == k
				if (mid + 1 <= end && array[mid + 1] == k) {
					start = mid + 1;
				} else {
					return mid;
				}
			}
		}
		return -1;
	}
}

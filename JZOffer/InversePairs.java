/**
 * 面试题36:数组中的逆序对
 * 题目描述：在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 
 * @author geyan
 *
 */
public class InversePairs {
	/**
	 * 方法一：时间复杂度为O(N^2) 遍历到当前元素时，继续遍历，找出后面比它小的数字，重复该操作
	 */
	public int inversePairs_1(int[] array) {
		if (array == null || array.length <= 0)
			return 0;
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j])
					count++;
				if (count > 1000000007) {
					count %= 1000000007;
				}
			}
		}
		return count;
	}

	/**
	 * 方法二：基于归并排序，时间复杂度为O(NlogN)
	 * 假设有两个有序的数组A和B，数组A排在数组B的前面，两个指针p1和p2分别指向A.length-1和B.length-1，比较A[p1]和B[p2]的大小 
	 * 1.A[p1] > B[p2]，则说明逆序对的个数count+=数组B的大小，此时将A[p1]加入到辅助数组的最后一位,p1--
	 * 2.A[p1] < B[p2]，直接将B[p2]加入到辅助数组的倒数第二位,p2-- 重复上述操作 最后需要将辅助数组的元素重新插入原数组中
	 */
	public int inversepairs_2(int[] array) {
		if (array == null || array.length <= 0)
			return 0;
		return sort(array, 0, array.length - 1);
	}

	private int sort(int[] arr, int start, int end) {
		if (start >= end)
			return 0;
		int mid = start + (end - start) / 2;
		int leftCount = sort(arr, start, mid);
		int rightCount = sort(arr, mid + 1, end);
		return (leftCount + rightCount + merge(arr, start, mid, end)) % 1000000007;
	}

	private int merge(int[] arr, int start, int mid, int end) {
		// 比较的下标
		int p1 = mid, p2 = end;
		// 辅助数组
		int[] temp = new int[end - start + 1];
		// 逆序对个数
		int count = 0;
		int index = end - start;
		while (p1 >= start && p2 >= mid + 1) {
			if (arr[p1] > arr[p2]) {
				temp[index--] = arr[p1--];
				count += p2 - mid;
				if (count > 1000000007) {
					count %= 1000000007;
				}
			} else {
				temp[index--] = arr[p2--];
			}
		}
		while (p1 >= start) {
			temp[index--] = arr[p1--];
		}
		while (p2 >= mid + 1) {
			temp[index--] = arr[p2--];
		}
		for (int i = 0; i < end - start + 1; i++) {
			arr[start + i] = temp[i];
		}
		return count;
	}
}

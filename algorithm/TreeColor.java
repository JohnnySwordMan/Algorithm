/**
 * 题目：荷兰国旗：现有n个红白蓝三种不同颜色的小球，乱序排列在一起，请通过两两交换任意两个球，使得从左至右，依次是一些红球，一些白球，一些篮球
 * 
 * 有一个只由0，1，2三种元素构成的整数数组，请使用交换、原地排序而不是使用计数进行排序。
 * 给定一个只含0，1，2的整数数组a及它的大小，请返回排序后的数组。保证数组大小小于等于500.
 * 
 * @author geyan
 *
 */
public class TreeColor {

	public static void main(String[] args) {
		int[] a = { 0, 1, 1, 0, 2, 2 };
		int[] arr = sortThreeColor(a, 6);
		for (int i = 0; i < a.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	/**
	 * 快排是依托于partition分治过程，在每一次排序过程中，都会根据切分元素，将数组分成三部分，切分元素的左边<=切分元素<=切分元素的右边
	 * 可以借鉴快排，使用begin，end，current三个指针，begin指向0区域最后一个元素，end指向2区域第一个元素，
	 * current指向当前遍历元素 1. current指向元素0时，与begin指向的元素交换，然后current++，begin++； 2.
	 * current指向元素1时，不做任何交换，然后current++ 3.
	 * current指向元素2时，与end指向的元素交换，然后current指向不变，end--;
	 */
	public static int[] sortThreeColor(int[] a, int n) {
		int begin = 0, current = 0, end = n - 1;
		int temp = 0;
		while (current <= end) {
			if (a[current] == 0) {
				temp = a[current];
				a[current] = a[begin];
				a[begin] = temp;
				// swap(a,current,begin); 引用传递
				current++;
				begin++;
			} else if (a[current] == 1) {
				current++;
			} else {
				temp = a[current];
				a[current] = a[end];
				a[end] = temp;
				// swap(a,current,end);
				end--;
			}
		}
		return a;
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	// 值传递，不能真正改变原数组中元素位置
	public static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}

	/**
	 * 暴力解决，首先遍历数组，分别记录下0，1，2分别个数，然后再重新排列
	 */
	public static int[] sortThreeColor_1(int[] a, int n) {
		int red = 0, white = 0, blue = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] == 0) {
				red++;
			} else if (a[i] == 1) {
				white++;
			} else {
				blue++;
			}
		}

		// 重新排列
		for (int i = 0; i < n; i++) {
			if (red > 0) {
				a[i] = 0;
				red--;
			} else if (white > 0) {
				a[i] = 1;
				white--;
			} else {
				a[i] = 2;
				blue--;
			}
		}
		return a;
	}

}

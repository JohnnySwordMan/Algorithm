/**
 * 冒泡排序是一种交换排序，其基本思想是：相邻两两比较(要求从小到大排序)，后者小于前者，则交换。 平均时间复杂度和最坏时间复杂度均为O(n^2)
 * 控件复杂度为O(1) 稳定
 * 
 * @author geyan
 *
 */
public class BubbleSort {

	/**
	 * 假如待排序的数组是{2,1,3,4,5,6,7,8,9}，可以看出除了1和2需要交换之外，其他的元素是不需要交换的。
	 * 当第一次遍历数组元素时，交换1和2，此时数组应该是有序的，没有必要再去遍历第二次了 改进代码，增加标记flag
	 * 
	 * @param a
	 */
	private static void sort_2(int[] a) {
		// flag为true，表示有数据交换
		boolean flag = true;
		for (int i = 0; i < a.length && flag; i++) {
			flag = false;
			for (int j = a.length - 1; j > i; j--) {
				if (a[j - 1] > a[j]) {
					int temp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = temp;
					// 数据交换
					flag = true;
				}
			}
		}
	}

	// 最初级的写法
	private static void sort_1(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = a.length - 1; j > i; j--) {
				if (a[j - 1] > a[j]) {
					int temp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] a = { 9, 1, 5, 8, 3, 7, 4, 6, 2 };
		System.out.print("排序前：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		// sort_1(a);
		sort_2(a);
		System.out.print("排序后：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

}

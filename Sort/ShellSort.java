/**
 * 希尔排序是一种改进的直接插入排序(将a[i],插入到a[i-h],a[i-2*h]...中)，即交换不相邻的元素以对数组的局部进行排序，
 * 并最终用插入排序将局部有序的数组排序。使数组中任意间隔为h的元素有序
 * 目前还无法准确计算出希尔排序的时间复杂度，不过在最坏的情况下，该算法的比较次数和N^(3/2)成正比 
 * 平均时间复杂度为O(NlogN)
 * 空间复杂度为O(1) 
 * 不稳定
 * 
 * @author geyan
 *
 */
public class ShellSort {
	/**
	 * 希尔排序，改进直接插入排序，使数组中任意间隔为h的元素有序
	 * 
	 * @param a
	 */
	public static void sort(Comparable[] a) {
		int N = a.length;
		int h = 1;
		while (h < N) {
			h = 3 * h + 1;
		}
		while (h >= 1) {
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h; j -= h) {
					if (a[j].compareTo(a[j - h]) < 0) {
						Comparable temp = a[j];
						a[j] = a[j - h];
						a[j - h] = temp;
					}
				}
			}
			h = h / 3;
		}
	}

}

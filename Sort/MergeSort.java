/**
 * 归并排序 
 * 平均时间复杂度为O(NlogN) 
 * 最坏时间复杂度为O(NlogN) 
 * 空间复杂度为O(n)，原地归并的空间复杂度为O(1) 
 * 稳定
 * 
 * @author geyan
 *
 */
public class MergeSort {

	public void mergeSort(int[] a, int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;
			mergeSort(a, left, mid);
			mergeSort(a, mid + 1, right);
			merge(a, left, mid, right);
		}
	}

	public void merge(int[] a, int left, int mid, int right) {
		int[] temp = new int[a.length];
		int i = left, j = mid + 1, k = 0;
		while (i <= mid && j <= right) {
			if (a[i] <= a[j]) {
				temp[k++] = a[i++];
			} else {
				temp[k++] = a[j++];
			}
		}
		while (i <= mid) {
			temp[k++] = a[i++];
		}
		while (j <= right) {
			temp[k++] = a[j++];
		}
		for (i = 0; i < k; i++) {
			a[i + left] = temp[i];
		}
	}
}

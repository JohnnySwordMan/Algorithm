/**
 * �鲢���� 
 * ƽ��ʱ�临�Ӷ�ΪO(NlogN) 
 * �ʱ�临�Ӷ�ΪO(NlogN) 
 * �ռ临�Ӷ�ΪO(n)��ԭ�ع鲢�Ŀռ临�Ӷ�ΪO(1) 
 * �ȶ�
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

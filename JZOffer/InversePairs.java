/**
 * ������36:�����е������
 * ��Ŀ�������������е������������ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�����һ�����飬�����������е�����Ե�������
 * 
 * @author geyan
 *
 */
public class InversePairs {
	/**
	 * ����һ��ʱ�临�Ӷ�ΪO(N^2) ��������ǰԪ��ʱ�������������ҳ��������С�����֣��ظ��ò���
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
	 * �����������ڹ鲢����ʱ�临�Ӷ�ΪO(NlogN)
	 * �������������������A��B������A��������B��ǰ�棬����ָ��p1��p2�ֱ�ָ��A.length-1��B.length-1���Ƚ�A[p1]��B[p2]�Ĵ�С 
	 * 1.A[p1] > B[p2]����˵������Եĸ���count+=����B�Ĵ�С����ʱ��A[p1]���뵽������������һλ,p1--
	 * 2.A[p1] < B[p2]��ֱ�ӽ�B[p2]���뵽��������ĵ����ڶ�λ,p2-- �ظ��������� �����Ҫ�����������Ԫ�����²���ԭ������
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
		// �Ƚϵ��±�
		int p1 = mid, p2 = end;
		// ��������
		int[] temp = new int[end - start + 1];
		// ����Ը���
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

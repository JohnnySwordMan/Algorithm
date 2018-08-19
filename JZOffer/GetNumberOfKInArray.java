/**
 * ������38�����������������г��ֵĴ���
 * ��Ŀ������ͳ��һ�����������������г��ֵĴ���������������������{1,2,3,3,3,3,4,5}������3������3����������г�����4�Σ�������4��
 * 
 * @author geyan
 *
 */
public class GetNumberOfKInArray {

	/**
	 * ����һ���������飬ʱ�临�Ӷ�ΪO(N) 
	 * ���������������������
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
	 * ��������ʱ�临�Ӷ�ΪO(logN) 
	 * ��������Ӧ������������ַ�
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
		 * 		// mid���һ���Ԫ�ص���k�������ôд����д����ȥ�ˡ� 
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

	// ��array[mid] == kʱ�������ҳ�0~mid-1λ���ϵ�һ�γ���k���±�
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
			// ��array[mid] == k
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
				// ��array[mid] == k
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

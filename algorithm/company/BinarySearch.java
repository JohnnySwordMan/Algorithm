/**
 * ��Ŀ�����ֲ���
 * ��Ŀ����������һ����������A�����Ĵ�Сn��ͬʱ����Ҫ���ҵ�Ԫ��val���뷵�����������е�λ��(��0��ʼ)���������ڸ�Ԫ�أ�����-1������Ԫ�س��ֶ�Σ��뷵�ص�һ�γ��ֵ�λ�á�
 *
 * �����뽣ָOffer"���������������г��ֵĴ���"���ƣ��ο�/algorithm/JZOffer/GetNumberOfK.java 
 *
 * @author geyan
 *
 */
public class BinarySearch {

	public int getPos(int[] A, int n, int val) {
		if (A == null || n <= 0) {
			return -1;
		}
		int start = 0, end = n - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (A[mid] < val) {
				start = mid + 1;
			} else if (A[mid] > val) {
				end = mid - 1;
			} else {
				// ��A[mid] == valʱ��������ǰ����
				if (mid - 1 >= start && A[mid - 1] == val) {
					end = mid - 1;
				} else {
					return mid;
				}
			}
		}
		return -1;
	}

}

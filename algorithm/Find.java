/**
 * ��Ŀ������ԭλ
 * ��Ŀ��������һ����������arr�����в������ظ�Ԫ�أ����ҵ�����arr[i]==i�����������λ�á��������λ���ϵ���������������������-1��
 * ������������arr�����Ĵ�Сn���뷵������ֵ��
 * 
 * ע�⣺ 
 * 1.�����Ԫ�����������Ŀ�����Ƶģ���ʹ�ö��ַ����ҵ�Ԫ�ص�ʱ�򣬲�����ֹͣѭ������Ϊ��Ҫ���ҵ�����Ԫ�أ�����right = mid-1
 * 2.������Ŀ�������ñ�����������ɣ�����ʱ�临�Ӷ�ΪO(N)�����������Ž� 
 * 3.���ܺ��������������飬���������������飬��ô�����Ƿ����ʹ�ö��ַ�
 * 
 * @author geyan
 *
 */
public class Find {

	/**
	 * 1.���Ǳ߽����� 
	 * 2.���ַ����ж�arr[mid]��mid�Ĵ�С��ϵ
	 */
	public int findPos(int[] arr, int n) {
		if (arr == null || n < 0)
			return -1;
		int left = 0, right = n - 1;
		int res = -1;
		if (arr[left] > left) {
			// left���ϸ���1�����ģ���arr������������1���������arr[left]>left����ô�ǲ����ܴ���arr[i] == i��
			return -1;
		}
		if (arr[right] < right) {
			// ͬ��
			return -1;
		}
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] < mid) {
				// Ӧ�����Ұ벿�ݲ���
				left = mid + 1;
			} else if (arr[mid] > mid) {
				right = mid - 1;
			} else {
				// ��ʹ�ҵ�arr[mid] = mid����������ѭ���Ľ�������Ϊ��Ҫ�ҳ�����Ԫ��
				res = mid;
				right = mid - 1;
			}
		}
		return res;
	}
}

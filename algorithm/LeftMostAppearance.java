/**
 * ���ַ���ϰ 
 * ��Ŀ��Ԫ��������� 
 * ��Ŀ����������һ����������arr���ٸ���һ������num������arr���ҵ�num��������ֵ�����ߵ�λ�á�
 * ����һ������arr�����Ĵ�Сn��ͬʱ����num���뷵������λ�á���Ԫ����������δ���֣��뷵��-1��
 * 
 * @author geyan
 *
 */
public class LeftMostAppearance {

	/**
	 * ��ͨ����������������һ�α�������num��ȵ�Ԫ��ʱ�����������±ꡣ����������ʵ�����˸����������������������ʱ�临�Ӷ�ΪO(N)��
	 */
	public int findPos_1(int[] arr, int n, int num) {
		if (arr == null || n < 0)
			return -1;
		for (int i = 0; i < n; i++) {
			if (num == arr[i])
				return i;
		}
		return -1;
	}

	/**
	 * ���Ž⣺���ַ���ʱ�临�Ӷ�ΪO(logN)�������������������
	 */
	public int findPos_2(int[] arr, int n, int num) {
		if (arr == null || n < 0)
			return -1;
		int left = 0, right = n - 1;
		int res = -1;
		while (left <= right) {
			// ��������(left+right)/2����ֹleft+right����
			int mid = left + (right - left) / 2;
			if (arr[mid] < num) {
				left = mid + 1;
			} else if (arr[mid] > num) {
				right = mid - 1;
			} else {
				// �����ʱ��ȣ�ֻ��֪��arr[mid]��num����ȵģ����ǻ�����ȷ���ǲ�������ߣ������ȼ�¼�´�ʱ���±꣬���ǻ���Ҫ�����жϣ�ֱ��left>rightΪֹ
				res = mid;
				right = mid - 1;
			}
		}
		return -1;
	}
}

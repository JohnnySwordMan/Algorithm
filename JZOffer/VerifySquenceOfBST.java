/**
 * ������24�������������ĺ����������
 * ��Ŀ����������һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ��������������Yes���������No���������������������������ֶ�������ͬ��
 * 
 * @author geyan
 *
 */
public class VerifySquenceOfBST {

	/**
	 * �������Ԫ���Ǻ�������Ľ������ô���һ��Ԫ���Ǹ��ڵ㡣 1��ȷ��root��
	 * 2���������У���ȥroot��㣩���ҵ���һ������root��λ�ã����λ�����Ϊ���������ұ�Ϊ��������
	 * 3����������������������С��root��ֵ����ֱ�ӷ���false�� 4���ֱ��ж����������������Ƿ����Ƕ��������������ݹ鲽��1��2��3����
	 */
	public boolean verifySquenceOfBST_1(int[] a, int n) {
		if (a == null || n <= 0)
			return false;
		int root = a[n - 1];
		int i = 0;
		for (; i < n - 1; i++) {
			if (a[i] > root)
				break;
		}
		// ��ʱa[i]���ڸ��ڵ㣬��ʾi�Լ�i֮���Ԫ��Ӧ�������������������ж���
		int j = i;
		for (; j < n - 1; j++) {
			if (a[j] < root)
				return false;
		}

		boolean left = true;
		if (i > 0) {
			left = verifySquenceOfBST_1(a, i);
		}

		boolean right = true;
		if (j < n - 1) {
			right = verifySquenceOfBST_1(a, n - 1 - i);
		}
		return left && right;
	}

	// ������������һд������
	public boolean verifySquenceOfBST_2(int[] a, int start, int end) {
		if (a == null || a.length <= 0) {
			return false;
		}
		
		int root = a[end];
		int i = 0;
		for (; i < end; i++) {
			if (a[i] > root) {
				break;
			}
		}

		int j = i;
		for (; j < end; j++) {
			if (a[j] < root) {
				return false;
			}
		}

		// �ݹ�����������
		boolean left = true;
		if (i > start) {
			left = verifySquenceOfBST_2(a, start, i - 1);
		}

		boolean right = true;
		if (j < end) {
			right = verifySquenceOfBST_2(a, j, end - 1);
		}
		return left && right;
	}
}

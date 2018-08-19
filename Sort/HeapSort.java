/**
 * ������Ĺ��̣����ǽ���--->����--->���� ʱ�临�Ӷ�ΪO(N*logN)���ռ临�Ӷ�ΪO(1)�����ȶ�
 * 
 * @author geyan
 *
 */
public class HeapSort {

	public static void main(String[] args) {
		// int[] a = { 110, 100, 90, 40, 80, 20, 60, 10, 30, 50, 70 };
		int[] a = { 50, 10, 90, 30, 70, 40, 80, 60, 20 };
		sort_asc(a, a.length);
		// sort_des(a, a.length);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	/**
	 * ��С�������򣬽������ѣ����Ѷ�Ԫ������ĩԪ�ؽ������Գ����һ��Ԫ�����Ԫ�����½��ѡ�
	 * 
	 * @param a
	 * @param n
	 */
	public static void sort_asc(int[] a, int n) {

		for (int i = n / 2 - 1; i >= 0; i--) {
			maxHeapDown(a, i, n - 1); // ��������
		}

		// �������ٽ���
		for (int i = n - 1; i > 0; i--) {
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			maxHeapDown(a, 0, i - 1);
		}
	}

	/**
	 * �Ӵ�С���򣬽�����С��
	 * 
	 * @param a
	 * @param n
	 */
	public static void sort_des(int[] a, int n) {
		for (int i = n / 2 - 1; i >= 0; i--) {
			minHeapDown(a, i, n - 1); // ������С��
		}

		// �������ٽ���
		for (int i = n - 1; i > 0; i--) {
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			minHeapDown(a, 0, i - 1);
		}
	}

	/**
	 * �������� �����±��0��ʼ�����ڵ��±�Ϊc����ô�ڵ�c�����ӵ��±�Ϊ2*c+1��(����Ӧ����+1)
	 * 
	 * @param a
	 * @param start
	 * @param end
	 */
	private static void maxHeapDown(int[] a, int start, int end) {
		int c = start, l = 2 * c + 1, temp = a[c];
		for (; l <= end; c = l, l = 2 * l + 1) {
			// ���ҵ��ڵ�c�����Һ��ӽڵ��нϴ�ĺ���
			if (l < end && a[l] < a[l + 1])
				l++;
			// ���ڵ���ϴ�ĺ��ӽڵ�Ƚ�
			if (temp >= a[l])
				break;
			else {
				a[c] = a[l];
				a[l] = temp;
			}
		}
	}

	private static void minHeapDown(int[] a, int start, int end) {
		int c = start, l = 2 * c + 1, temp = a[c];
		for (; l <= end; c = l, l = 2 * l + 1) {
			// ���ҵ��ڵ�c�����Һ��ӽڵ��н�С�ĺ���
			if (l < end && a[l] > a[l + 1])
				l++;
			// ���ڵ����С�ĺ��ӽڵ�Ƚ�
			if (temp <= a[l])
				break;
			else {
				a[c] = a[l];
				a[l] = temp;
			}
		}
	}
}

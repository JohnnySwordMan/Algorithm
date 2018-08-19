import java.util.Deque;
import java.util.LinkedList;

/**
 * ��Ŀ���������� ��һ���������� arr ��һ����СΪ w �Ĵ��ڴ����������߻������ұ�,����ÿ�����ұ߻�һ��λ�á�
 * ����һ������Ϊn-w+1������res��res[i]��ʾÿһ�ִ���״̬�µ����ֵ��
 * ������Ϊ[4,3,5,4,3,3,6,7]��w=3Ϊ������Ϊ��һ������[4,3,5]�����ֵΪ5���ڶ�������[3,5,4]�����ֵΪ5������������[5,4
 * ,3]�����ֵΪ5�����ĸ�����[4,3,3]�����ֵΪ4��
 * ���������[3,3,6]�����ֵΪ6������������[3,6,7]�����ֵΪ7���������շ���[5,5,5,4,6,7]��
 * ������������arr�����Ĵ�Сn��ͬʱ����w���뷵��res���顣��֤wС�ڵ���n��ͬʱ��֤�����СС�ڵ���500�� ����������
 * [4,3,5,4,3,3,6,7]��8��3 ���أ� [5,5,5,4,6,7] ע�⣺�߽��������ڱ�̹����У�ע���±��ȡֵ�����޵ȺŴ���
 * 
 * @author geyan
 *
 */
public class SlideWindow {

	// ��ͨ�ⷨ��ʱ�临�Ӷ�ΪO(N*w)��Ҳ����ÿ�ζ�ÿһ�����ڱ������е�w������ѡ�����ֵ��
	public int[] slide_1(int[] arr, int n, int w) {
		int[] res = new int[n - w + 1];
		int index = 0;
		for (int i = 0; i < n - w + 1; i++) { // i<n-w+1��������i<n-w��ѭ��n-w+1��
			res[index++] = max(arr, i, i + w - 1);
		}
		// res[index] = max(arr,n-w-1,n-1);
		return res;
	}

	/**
	 * ���Ž�ʱ�临�Ӷȿ�������O(N)��ʹ��˫�˶��� ˫�˶���qmax={}��˫�˶��д���������е��±�ֵ�����赱ǰ��Ϊarr[i]������������£�
	 * 1.���qmaxΪ�գ�ֱ�Ӱ��±�i����qmax��
	 * 2.���qmax��Ϊ�գ�ȡ����ǰqmax��β��ŵ��±�j�����arr[j]>arr[i]��ֱ�Ӱ��±�i�Ž�qmax�Ķ�β
	 * 3.���arr[j]<=arr[i]����һֱ��qmax�Ķ�β�����±ֱ꣬��ĳ���±���qmax�ж�Ӧ��ֵ����arr[i]����i����qmax�Ķ�β��
	 * ���qmax��ͷ���±����i-w������qmax��ǰ��ͷ�±�
	 */
	public int[] slide(int[] arr, int n, int w) {
		int[] res = new int[n - w + 1];
		if (arr == null || w > n)
			return res;
		int index = 0;
		// ����˫�˶���
		Deque<Integer> deque = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			// β�����Ԫ��
			if (deque.isEmpty() || arr[deque.peekLast()] > arr[i]) {
				deque.offerLast(i);
			} else {
				// β��ɾ��Ԫ��
				while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
					deque.pollLast();
				}
				deque.offerLast(i);
			}
			if (i >= w - 1) {
				// �����ͷԪ�أ��������±����i-w���򵯳���ǰ��ͷ�±�
				while (!deque.isEmpty() && deque.peekFirst() == i - w) {
					deque.pollFirst();
				}
				res[index++] = arr[deque.peekFirst()];
			}

		}
		return res;
	}

	// �ҵ������У����±�start��end�����ֵ��ֻ���ҳ����ֵ������Ҫ����
	public static int max(int[] a, int start, int end) {
		int max = start;
		for (int i = start + 1; i <= end; i++) { // i<=end������i<end
			if (a[max] < a[i])
				max = i;
		}
		return a[max];
	}
}

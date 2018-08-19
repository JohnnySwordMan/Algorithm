/**
 * ��Ŀ��С��Χ����
 * ��֪һ��������������飬����������ָ������������ź�˳��Ļ���ÿ��Ԫ���ƶ��ľ�����Բ�����k������k�����������˵�Ƚ�С����ѡ��һ�����ʵ������㷨���������ݽ�������
 * ����һ��int����A��ͬʱ����A�Ĵ�С�������е�k���뷵�����������顣
 * ����������
 * [2,1,4,3,6,5,8,7,10,9],10,2
 * 
 * ���أ�
 * [1,2,3,4,5,6,7,8,9,10]
 *
 * 
 * ����������������ź�˳��Ļ���ÿ��Ԫ���ƶ��ľ�����Բ�����k����ô��Сֵ�ض������±�0~k-1֮��(����0��k-1)
 * ��ô�����Ȱ�a[0]~a[k-1]������С�ѣ�����Ѷ�Ԫ�أ��ٽ�a[k]���룬���½�����С�ѣ��ٴ�����Ѷ�Ԫ�ء�
 */
import java.util.*;

public class ScaleSort {
	public static void main(String[] args) {
		int[] a = { 2, 1, 4, 3, 6, 5, 8, 7, 10, 9 };
		int[] arr = sortElement(a, 10, 2);
		for (int i = 0; i < 10; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static int[] sortElement(int[] a, int n, int k) {
		if (n == 0 || n < k)
			return a;

		// ��ȡ����a��ǰk����ʼ����heap������Ԫ�ؽ���
		int[] heap = Arrays.copyOf(a, k);

		// ������С�ѣ���С�ѽ���֮�󣬶Ѷ�Ԫ��Ҳ����heap[0]����Сֵ��
		for (int i = k / 2 - 1; i >= 0; i--) {
			minHeapDown(heap, i, k - 1);
		}

		// ÿ��ȡ����С�ѵĸ�����Ϊ�µ�Ԫ�أ��ٵ���minHeapDownά����С��
		for (int i = 0; i < n - k; i++) {
			a[i] = heap[0];
			heap[0] = a[i + k]; // ��i=n-k-1ʱ����heap[0] = a[n-1]ʱ��������С��
			minHeapDown(heap, 0, k - 1);
		}

		// ������β�ڵ㽻������ɶ����򡣽�heap���������k��Ԫ��Ԫ�������Һ���û��Ԫ�ؼ���
		for (int i = n - k; i < n; i++) {
			a[i] = heap[0];
			// ����heap[0]��heap[k-1]����ȥ��ԭ�Ѷ�Ԫ��(��С��)
			swap(heap, 0, k - 1);
			k--;
			minHeapDown(heap, 0, k - 1);
		}
		return a;
	}

	/**
	 * ������С��
	 * 
	 * @param a
	 *            [description]
	 * @param start
	 *            [description]
	 * @param end
	 *            [description]
	 * @return [description]
	 */
	public static void minHeapDown(int[] a, int start, int end) {
		int c = start;
		int l = 2 * c + 1; // �����±��0��ʼ
		int temp = a[c];
		for (; l <= end; c = l, l = 2 * l + 1) {
			// �ҳ����Һ����н�С���Ǹ�
			if (l < end && a[l] > a[l + 1]) {
				l++;
			}
			if (temp <= a[l]) { // ���׽ڵ��ֵС�ڵ��ں��ӽڵ��ֵ
				break;
			} else {
				a[c] = a[l];
				a[l] = temp;
			}
		}
	}

	private static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

}
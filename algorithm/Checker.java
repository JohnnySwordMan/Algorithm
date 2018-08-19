import java.util.*;

/**
 * ��Ŀ���ظ�ֵ�ж���ϰ�� �����һ����Ч�㷨���ж��������Ƿ����ظ�ֵ�����뱣֤����ռ临�Ӷ�ΪO(1)��
 * ����һ��int����a�����Ĵ�Сn���뷵�����Ƿ����ظ�ֵ��
 *
 * �����������ظ�ֵ�жϣ����ڼ��ַ��� ����һ��ʹ��HashMap�������е�Ԫ����Ϊkeyֵ��Ԫ�س��ֵĴ���������Ϊvalueֵ
 * ��������ʹ�ñ���count������(��ʱ����֪���ܲ�����)
 * ���������Ƚ�����������Ϊ�ظ�Ԫ�ؿ϶����������ġ�ð�ݣ�ѡ�񣬲��룬ϣ����������Ŀռ临�Ӷȶ�ΪO(1)�����ŵĿռ临�Ӷ���O(logN)~O(N)��
 * �ݹ���Ҫ�õ�ջ��ջ�Ĵ�С��Ӱ�쵽�ռ临�Ӷ� Ч����ߵıض��Ƕ���������Ķ�������ʹ�õݹ�ķ�����ֻ��ʹ�÷ǵݹ鷽�� �����ģ�����ֱ��ʹ��set����
 * 
 * ���������� [1,2,3,4,5,5,6],7
 *
 * ���أ� true
 * 
 * @author geyan
 *
 */
public class Checker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// ���������������ٱ���
	public static boolean checkDuplicate(int[] a, int n) {
		for (int i = n / 2 - 1; i >= 0; i--) {
			maxHeapDown(a, i, n - 1);
		}

		for (int i = n - 1; i > 0; i--) {
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			maxHeapDown(a, 0, i - 1); // ���һ��λ�ù̶��ˣ���ÿ��ѭ�������ֵ
		}

		// �������Ƿ�����ظ�Ԫ��
		for (int i = 1; i < n; i++) {
			if (a[i - 1] == a[i]) {
				return true;
			} /*
				 * else { return false; ���ܼ� }
				 */
		}
		return false;
	}

	// ��������
	public static void maxHeapDown(int[] a, int start, int end) {
		int c = start;
		int l = 2 * c + 1;
		int temp = a[c];
		for (; l <= end; c = l, l = 2 * l + 1) {
			if (l < end && a[l] < a[l + 1])
				l++;
			if (temp >= a[l]) {
				break;
			} else {
				a[c] = a[l];
				a[l] = temp;
			}
		}
	}

	// �����ģ�set����
	public static boolean checkDuplicate_2(int[] a, int n) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			if (set.contains(a[i])) {
				return true;
			} else {
				set.add(a[i]);
			}
		}
		return false;
	}

	/**
	 * ����һ��ʹ��HashMap HashMap����ռ临�Ӷ�Ӧ��ΪO(n)����Ϊ����keyֵ��hashֵȷ����elementData�����е�λ��
	 * 
	 * @param a
	 *            [description]
	 * @param n
	 *            [description]
	 * @return [description]
	 */
	public static boolean checkDuplicate_1(int[] a, int n) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (!map.containsKey(a[i])) {
				map.put(a[i], 1);
			} else {
				// ֻ��Ҫֱ�ӷ���true or false����ΪֻҪ�ж��������Ƿ�����ظ�ֵ
				return true;
			}
		}
		return false;
	}
}

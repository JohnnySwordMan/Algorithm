import java.util.LinkedList;
import java.util.List;

/**
 * ������45��ԲȦ�����ʣ�µ�����(Լɪ��)
 * ��Ŀ������0��1��...n-1��n�������ĳ�һ��ԲȦ��������0��ʼÿ�δ����ԲȦ��ɾ����m�����֡�������ԲȦ��ʣ�µ����һ������
 * 
 * @author geyan
 *
 */
public class LastRemaining {

	/**
	 * ʹ������ģ��
	 */
	public int lastRemaining_1(int n, int m) {
		if (n < 1 || m < 1)
			return -1;
		// ����һ��������ģ�⻷��ɾ��Ԫ�أ�����Խ���Ӧ�±��Ԫ����Ϊ-1
		int[] array = new int[n];
		// i��¼�����±꣬step��¼��������Ч����count��ʾʣ������
		int i = -1, step = 0, count = n;
		while (count > 0) {
			i++;
			// ģ�⻷
			if (i >= n)
				i = 0;
			// �Ƿ�ɾ����
			if (array[i] == -1)
				continue;
			step++;
			if (step == m) {
				array[i] = -1;
				step = 0;
				count--;
			}
		}
		return i;
	}

	/**
	 * ʹ��LinkedList
	 */
	public int lastRemaining_2(int n, int m) {
		if (n < 1 || m < 1)
			return -1;
		List<Integer> list = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			list.add(i);
		}
		// Ҫɾ��Ԫ�ص�λ��
		int index = 0;
		while (list.size() > 1) {
			// ��m-1��
			for (int i = 1; i < m; i++) {
				// %ģ��Բ
				index = (index + 1) % list.size();
			}
			list.remove(index);
		}
		return list.get(0);
	}

	public int lastRemaining_3(int n, int m) {
		if (n < 1 || m < 1)
			return -1;
		if (n == 1)
			return 0;
		return ((lastRemaining_3(n - 1, m) + m) % n);
	}

	public int lastRemaining_4(int n, int m) {
		if (n < 1 || m < 1)
			return -1;
		int last = 0;
		for (int i = 2; i <= n; i++) {
			last = (last + m) % i;
		}
		return last;
	}
}

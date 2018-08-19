import java.util.Arrays;

/**
 * �����⣺�˿���˳�� 
 * ��Ŀ���������˿���������� 5 ���ƣ��ж��ǲ���һ��˳�ӣ� ���� 5 �����ǲ��������ġ�2��10 Ϊ���ֱ��� A Ϊ 1�� J Ϊ
 * 11��Q Ϊ 12�� KΪ 13����С�����Կ����������֡�Ϊ�˷��������������Ϊ��С����0.
 * 
 * ��������ô�ж���5�������Ƿ���������ֱ�۵ķ���������������0���Ե����������֣�������0ȥ������п�ȱ�����֡�
 * ��ô��������Ҫ���Ĺ������ǣ� 
 * 1.�������飬����0�ĸ���
 * 2.�������飬��������λ���ϵ����ֿ�ȱ��������Щ��ȱ���������С�ڵ���0�ĸ������������������ģ������ǲ������� 
 * 3.��������д�����ͬ�ķ�0���֣�����˳��
 * 
 * @author geyan
 *
 */
public class IsContinuous {

	public boolean isContinuous(int[] numbers) {
		if (numbers == null || numbers.length < 5)
			return false;
		sort_asc(numbers, numbers.length);
		// Arrays.sort(numbers);
		// ��¼0�ĸ���
		int count = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 0)
				count++;
		}
		// ��¼����֮��Ŀ�ȱ����
		int sum = 0;
		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i] != 0 && numbers[i + 1] != 0) {
				// temp��ʾ��ȱ����������������-1
				int temp = numbers[i + 1] - numbers[i] - 1;
				/*
				 * if (temp == 1) { // 1,3 sum++; }
				 */
				if (temp >= 1) {
					sum += temp;
				} else if (temp == 0) {
					// 1,2
					continue;
				} else if (temp == -1) {
					// 1,1
					// ������ͬ�ķ�0 ������
					return false;
				}
			}
		}
		// ��ȱ����С�ڵ���0�ĸ���
		if (sum <= count) {
			return true;
		} else {
			return false;
		}
	}

	// ����������һ����д�����ÿ�����ϰ
	private void sort_asc(int[] arr, int n) {
		// ����
		for (int i = n / 2 - 1; i >= 0; i--) {
			maxHeapDown(arr, i, n - 1);
		}
		// ����������
		for (int i = n - 1; i > 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			maxHeapDown(arr, 0, i - 1);
		}
	}

	// ����
	private void maxHeapDown(int[] arr, int start, int end) {
		int c = start, l = 2 * c + 1;
		int temp = arr[c];
		for (; l <= end; c = l, l = 2 * l + 1) {
			if (l < end && arr[l] < arr[l + 1])
				l++;
			if (temp >= arr[l]) {
				break;
			} else {
				arr[c] = arr[l];
				arr[l] = temp;
			}
		}
	}
}

package LeetCode;

/**
 * ��Ŀ��λ����
 * @author geyan
 *
 */
public class SingleNumber {

	/**
	 * �������飬������ֻ��һ��Ԫ�س���һ�Σ�����Ԫ�ض���������
	 */
	public int singleNumber_1(int[] arr) {
		if (arr == null || arr.length <= 0) {
			return 0;
		}
		int res = arr[0];
		for (int i = 1; i < arr.length; i++) {
			res = res ^ arr[i];
		}
		return res;
	}

	/**
	 * �������飬������ֻ��һ��Ԫ�س���һ�Σ�����Ԫ�ض�����3��
	 * ����һ��Ҳ��������λ�����������ظ�3�ε�����
	 * ��һ������[14,14,14,9]Ϊ������ÿ�������Զ����Ʊ� 
	 * 1110 
	 * 1110 
	 * 1110
	 * 1001
	 * 
	 * ���������������� 
	 * 4331 ��ÿһλ��� 
	 * 1001 ��ÿһλ�ĺ���%3���㣬�������ظ�3�ε���
	 */
	public int singleNumber_2(int[] A) {
		int res = 0;
		for (int i = 0; i < 32; i++) {
			// mask, ��iλΪ1������λ��Ϊ0
			int c = 0, mask = 1 << i; 
			for (int j = 0; j < A.length; j++) {
				int val = (A[j] & mask);
				// �����������һλ��Ϊ1���������ͼ�һ
				// val<0�������ǣ���Ϊ�������ڴ����Բ������ʽ��š�
				if (val > 0 || val < 0) { 
					c++;
				}
			}
			// ��һλ�ļ�������3ȡ������������ֻ����Ϊ0��1
			if (c % 3 > 0) 
				res |= mask;
		}
		return res;
	}

	/**
	 * �������飬������ֻ��һ��Ԫ�س���һ�Σ�����Ԫ�ض���������
	 * �����������������ֱ��¼����һ�ε������������ε����ͳ������ε�����
	 * ����һ��ones�������㷽����I��һ���ģ��������ˡ�
	 * ��������twos��������ones���и������������ֳ����ˡ�
	 * ��������threes�������Ǽ�������ones���ֳ���twos�
	 * ���һ����������3�Σ����Ǿ�Ҫ��ones��twos�����������
	 */
	public int singleNumber_3(int[] A) {
		int ones = 0, twos = 0, threes = 0;
		for (int i = 0; i < A.length; i++) {
			// ��������twos��������ones���и������������ֳ�����
			twos |= ones & A[i];
			// ����һ��ones�������㷽����I��һ���ģ���������
			ones ^= A[i];
			// ��������threes�������Ǽ�������ones���ֳ���twos��
			threes = ones & twos;
			// ���������ε�����ones��twos��ȥ��
			twos &= ~threes;
			ones &= ~threes;
		}
		return ones;
	}

	/**
	 * �������飬������������Ԫ�س���һ�Σ�����Ԫ�ض���������
	 */
	public String singleNumber_4(int[] A) {
		if (A == null || A.length <= 0) {
			return null;
		}
		int res = A[0];
		for (int i = 1; i < A.length; i++) {
			res ^= A[0];
		}
		int index = 0;
		// resΪֻ����һ�ε���������������Աض�����0�������Ը��ݸ���������λ��λ1��λ�ã���������ֳ�������
		// �Ǿ���res�Ķ����ƴ���ʼ��һ�γ���1��λ����������ֳ�������
		while ((res & 1) == 0) {
			res = res >> 1;
			index++;
		}
		int res1 = 0, res2 = 0;
		// ����Ԫ�صĶ����Ƶĵ�indexλ�Ƿ�Ϊ1�����Խ�array����ֳ���������
		// ֻ����һ�ε����ֱض���ֵ������������У�������ͬʱ��һ��������ҳ������ε����ֱض�ȫ��ͬһ���������������ͻ�����һ���������ҳ�ֻ����һ�ε����֡�
		for (int i = 0; i < A.length; i++) {
			if (isBit1(A[i], index)) {
				res1 ^= A[i];
			} else {
				res2 ^= A[i];
			}
		}
		return res1 + "," + res2;
	}

	// �ж�����num�ڵ�indexλ���Ƿ�Ϊ1
	private boolean isBit1(int num, int index) {
		num = num >> index;
		return (num & 1) == 1 ? true : false;
	}
}

/**
 * ������40��������ֻ����һ�ε�����
 * ��Ŀ������һ�����������������������֮�⣬���������ֶ����������Ρ���д�����ҳ�������ֻ����һ�ε����֡�Ҫ��ʱ�临�Ӷ�ΪO(N)���ռ临�Ӷ�ΪO(1)
 * 
 * @author geyan
 *
 */
public class FindNumsAppearOnce {

	public static void main(String[] args) {
		int[] array = { 2, 2, 3, 2, 3, 4, 5, 4, 5 };
		System.out.print(findNumAppearOnce(array));
	}

	/**
	 * ���꣺����һ���飬��������ֻ��һ�������ֹ�һ�Σ������Ķ�����2�Ρ� n��0���->n n��n���->0 ����������㽻���ɺͽ����
	 * �����ֻ��һ�������������Σ����������ֹ�ż���Σ�����������д��
	 * 
	 * @param array
	 */
	public static int findNumAppearOnce(int[] array) {
		int res = 0;
		for (int i = 0; i < array.length; i++) {
			res ^= array[i];
		}
		return res;
	}

	/**
	 * ��������ֻ���ֹ�һ�Σ����������ֹ�����
	 * 
	 * @param array
	 *            ��������
	 * @param num1
	 *            num1[0]ֻ���ֹ�һ�ε���
	 * @param num2
	 *            num2[0]ֻ���ֹ�һ�ε���
	 */
	public void findNumsAppearOnce(int[] array, int[] num1, int[] num2) {
		if (array == null || array.length <= 0)
			return;
		int res = array[0];
		for (int i = 1; i < array.length; i++) {
			res ^= array[i];
		}

		int index = 0;
		// ��ʱresΪ����ֻ����һ�ε���������������Աض���Ϊ0����ô�ҳ���ֵ��������Ϊ1��λ��
		while ((res & 1) == 0) {
			res = res >> 1; // ����1λ
			index++;
		}

		num1[0] = 0;
		num2[0] = 0;
		// ����Ԫ�صĶ����Ƶĵ�indexλ�Ƿ�Ϊ1�����Խ�array����ֳ���������
		// ֻ����һ�ε����ֱض���ֵ������������У�������ͬʱ��һ��������ҳ������ε����ֱض�ȫ��ͬһ���������������ͻ�����һ���������ҳ�ֻ����һ�ε����֡�
		for (int i = 0; i < array.length; i++) {
			if (isBit1(array[i], index)) {
				num1[0] ^= array[i];
			} else {
				num2[0] ^= array[i];
			}
		}
	}

	/**
	 * ����һ���������ж�����num�ڵ�indexλ���Ƿ�Ϊ1
	 */
	private boolean isBit1(int num, int index) {
		num = num >> index;
		return (num & 1) == 1 ? true : false;
	}
}

/**
 * ������34������
 * ��Ŀ���������ǰ�ֻ��������2��3��5�����������������С�����˳��ĵ�1500������������6��8���ǳ�������14���ǣ���Ϊ����������7��ϰ�������ǰ�1������һ��������
 * @author geyan
 *
 */
public class GetUglyNumber {

	/**
	 * ����һ������һ�����ǲ��ǳ���������Ҫ���㣬Ч�ʱȽϵ���
	 * @param index
	 * @return
	 */
	public int getUglyNumber_1(int index) {
		if (index <= 0)
			return 0;
		int num = 1;
		int count = 0;
		while (count < index) {
			if (isUgly(num)) {
				count++;
			}
			num++;
		}
		return num;
	}

	/**
	 * ���������ÿռ任ʱ��Ľⷨ
	 * �������飬���������Ѿ��ҵ��ĳ�������Ȼ��һ�������Ǳ���С�ĳ�����2/��3/��5�Ľ����
	 * ����˵����
	 * arr[0] = 1 ��һ����������ô�ڶ���������һ����min(arr[0]*2,arr[0]*3,arr[0]*5)�Ľ��
	 * arr[1] = 2 �ڶ�����������ô������������һ����arr[0]/arr[1]��2/��3/��5����Сֵ
	 * 
	 * ��min(arr[p2]*2,arr[p3]*3,arr[p5]*5)
	 * @param index
	 * @return
	 */
	public int getUglyNumber_2(int index) {
		if (index <= 0)
			return 0;
		int[] uglyNumbers = new int[index];
		// 1�ǵ�һ������
		uglyNumbers[0] = 1;
		int nextUglyIndex = 1;
		int p2 = 0, p3 = 0, p5 = 0;
		while (nextUglyIndex < index) {
			int min = Math.min(uglyNumbers[p2] * 2, Math.min(uglyNumbers[p3] * 3, uglyNumbers[p5] * 5));
			uglyNumbers[nextUglyIndex] = min;
			// ����p2,p3,p5��ֵ��ֻҪ�����һ�����ڵ�ǰ�������¸��µ�Ԫ�ؼ���
			while (uglyNumbers[p2] * 2 <= uglyNumbers[nextUglyIndex]) {
				p2++;
			}
			while (uglyNumbers[p3] * 3 <= uglyNumbers[nextUglyIndex]) {
				p3++;
			}
			while (uglyNumbers[p5] * 5 <= uglyNumbers[nextUglyIndex]) {
				p5++;
			}
			nextUglyIndex++;
		}
		return uglyNumbers[nextUglyIndex - 1];
	}

	public boolean isUgly(int number) {
		while (number % 2 == 0) {
			number /= 2;
		}
		while (number % 3 == 0) {
			number /= 3;
		}
		while (number % 5 == 0) {
			number /= 5;
		}
		return (number == 1) ? true : false;
	}
}

/**
 * ��Ŀ��������31�����������������
 * ��Ŀ����������һ���������飬������������Ҳ�и�����������һ���������Ķ���������һ�������顣������������ĺ͵����ֵ��Ҫ��ʱ�临�Ӷ�ΪO(N)
 * 
 * @author geyan
 *
 */
public class FindGreatestSumOfSubArray {

	/**
	 * cur:��ǰ����Ԫ�غ� res:�洢����Ԫ�غ� ��������ʼ����res = cur = array[0]�� ��ʼ��������Ԫ�أ�cur =
	 * cur+array[i]�����cur
	 * <0����ô����curΪ0������ǰ���Ԫ�أ����cur>res��˵����ʱ��curҪ����֮ǰ��������Ԫ�غͣ�����res
	 */
	public int findGreatestSumOfSubArray_1(int[] array) {
		if (array == null || array.length < 0)
			return 0;
		int cur = array[0];
		int res = cur;
		for (int i = 1; i < array.length; i++) {
			// �����ǰ����Ԫ�غ�С��0��������cur������ǰ�������Ԫ��
			if (cur < 0)
				cur = 0;
			cur = cur + array[i];
			if (cur > res)
				res = cur;
		}
		return res;
	}

	/**
	 * ��curSumΪ��ǰ���������ͣ�maxSumΪ����������
	 * �Ե�i��Ԫ�ؽ�β������������ѡ��Ҫô�Ƿ���ǰ����������У�curSum+array[i]��Ҫô��Ϊ�µ�������ĵ�һ��Ԫ��array[i]
	 */
	public int findGreatestSumOfSubArray_2(int[] array) {
		if (array == null || array.length < 0)
			return 0;
		int curSum = array[0];
		int maxSum = curSum;
		for (int i = 1; i < array.length; i++) {
			curSum = Math.max(curSum + array[i], array[i]);
			maxSum = Math.max(maxSum, curSum);
		}
		return maxSum;
	}
}

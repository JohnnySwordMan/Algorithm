/**
 * ��Ŀ�����ǹ� 
 * ��Ŀ������n��С����վ��һ�ţ�ÿ��С���ѱ���������һ���ǹ����÷ָߵ�С����Ҫ�������ڵ�С�����ǹ��ࡣ��������Ҫ�����ǹ���
 * 
 * @author geyan
 *
 */
public class Candy {

	public int candy(int[] ratings) {
		// ���ֻ��һ��С���ѻ���û��С����
		if (ratings.length <= 1) {
			return ratings.length;
		}
		int[] candy = new int[ratings.length];
		candy[0] = 1;
		// �ȴ������ұ������÷ֽϸߵĶ���һ���ǣ������i��С���ȼ��ȵ�i-1���ߣ���ôi���ǹ���Ŀ����i-1���ǹ���Ŀ+1
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				candy[i] = candy[i - 1] + 1;
			} else {
				candy[i] = 1;
			}
		}
		// �ȴ�������������ǣ������i��С���ĵȼ��ȵ�i+1��С���ߣ������ǹ�����ĿȴС����ȣ���ôi���ǹ���Ŀ����i+1���ǹ�+1
		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1] && candy[i] <= candy[i + 1]) {
				candy[i] = candy[i + 1] + 1;
			}
		}
		int result = 0;
		for (int i = 0; i < ratings.length; i++) {
			result += candy[i];
		}
		return result;
	}
}

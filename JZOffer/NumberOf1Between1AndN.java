/**
 * ������32����1��n������1���ֵĴ��� 
 * ��Ŀ����������һ������n�����1��n��n��������ʮ���Ʊ�ʾ��1���ֵĴ�����
 * ��������12����1��12��Щ�����а���1��������1��10��11��12
 * 
 * @author geyan
 *
 */
public class NumberOf1Between1AndN {

	/**
	 * ����һ��������ʱ��Ч�����ж�һ����������λ�����Ƿ�Ϊ1
	 * 
	 * @param n
	 * @return
	 */
	public int numberOf1Between1AndN_1(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			count += numberOf1_1(i);
		}
		return count;
	}

	// �жϸ���������n�ĸ���λ�����Ƿ�Ϊ1
	private int numberOf1_1(int n) {
		int count = 0;
		while (n != 0) {
			if (n % 10 == 1) {
				// ˵����λ�Ƿ�Ϊ1
				count++;
			}
			// �ж�ʮλ���Ƿ�Ϊ1
			n /= 10;
		}
		return count;
	}

}

/**
 * ��Ŀ���жϻ������� 
 * ��Ŀ���������������֣��ж���������Ƿ�Ϊ�������֣���121�ǻ������֣�122���ǻ�������
 * 
 * ˼·���������ֳ���10���õ���������������10�����ϸ������ٳ���10��������
 * 
 * @author geyan
 *
 */
public class PalindromeNumber {

	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		} else if (x == 0) {
			return true;
		} else {
			int temp = x;
			// ����
			int y = 0;
			while (x != 0) {
				y = y * 10 + x % 10;
				x = x / 10;
			}
			if (temp == y) {
				return true;
			} else {
				return false;
			}
		}
	}
}

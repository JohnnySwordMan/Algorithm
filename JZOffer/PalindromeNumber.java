/**
 * ��Ŀ���жϻ������� 
 * ��Ŀ���������������֣��ж���������Ƿ�Ϊ�������֣���121�ǻ������֣�122���ǻ�������
 * 
 * ˼·������ǻ������֣���Ȼ��ʮ��λ��ɵ�����Ϊ121����ô��ʮ��λ��ɵ�����Ӧ��Ҳ��121
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
				// ȡ��λ�ϵ�����
				y = y * 10 + x % 10;
				x = x / 10;
			}
			// ��ʮ��λ��ɵ��������ʮ��λ��ɵ�������ȣ����ǻ�������
			if (temp == y) {
				return true;
			} else {
				return false;
			}
		}
	}
}

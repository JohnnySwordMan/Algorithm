/**
 * ��Ŀ�����ַ���ת��������
 * ��Ŀ��������һ���ַ���ת����һ��������Ҫ����ʹ���ַ���ת�������Ŀ⺯���� ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0
 * @author geyan
 *
 */
public class StrToInt {

	public int strToInt(String str) {
		if (str == null || str.length() <= 0) {
			return 0;
		}
		int sum = 0;
		char[] c = str.toCharArray();
		// �жϸ������ַ�����һ���ַ��Ƿ�Ϊ'+','-'
		boolean flag = false;
		/*
		 * if (c[0] == '+') { flag = true; }
		 */
		// �ж��Ƿ�Ϊ-�����翼���ж��Ƿ�Ϊ+�������һ��Ϊ���֣���ôflag�ͻ�Ϊfalse����Ȼ����
		if (c[0] == '-') {
			flag = true;
		}
		for (int i = 0; i < c.length; i++) {
			if (i == 0 && c[0] == '+' || c[0] == '-') {
				continue;
			}
			if (c[i] < '0' || c[i] > '9') {
				return 0;
			}
			sum = sum * 10 + (c[i] - '0');
		}
		return flag ? -sum : sum;
	}
}

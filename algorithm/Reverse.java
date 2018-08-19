/**
 * ��Ŀ�����ӵ����� 
 * ����һ���ַ����������һ���㷨��ֻ���ַ����ĵ��ʼ������������Ҳ����˵���ַ�����һЩ�ɿո�ָ��Ĳ�����ɣ�����Ҫ����Щ��������
 * ����һ��ԭ�ַ���A�����ĳ��ȣ��뷵���������ַ����� ���������� "pig loves dog",13 ���أ� "dog loves pig"
 * 
 * ������ 
 * 1.ʵ�ֽ��ַ����ֲ������ַ�����ĺ���f 
 * 2.����f���ַ��������ַ����� "pig loves dog" ---> "god sevol gip"
 * 3.�ҵ��������ַ�����ÿһ�����ʵ���������f��ÿһ�����ʵ��������� "god sevol gip" ---> "dog loves pig"
 * 
 * @author geyan
 *
 */
public class Reverse {
	public String reverseSentence(String A, int n) {
		if (n == 0)
			return null;
		String str = reverse(A);
		String[] sstr = str.split(" ");
		String result = " ";
		for (int i = 0; i < sstr.length; i++) {
			result += reverse(sstr[i]);
			result += " ";
		}
		return result.trim();
	}

	public static String reverse(String str) {
		char[] c = str.toCharArray();
		for (int i = 0; i < c.length / 2; i++) {
			char temp = c[i];
			c[i] = c[c.length - 1 - i];
			c[c.length - 1 - i] = temp;
		}
		return new String(c);
	}
}

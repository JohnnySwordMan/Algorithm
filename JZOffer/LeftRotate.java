/**
 * ������42���꣺����ת�ַ��� 
 * ��Ŀ�����������ַ�����s���뽫��ѭ������kλ������������
 * 
 * ������Ŀ��Learning/algorithm/string/Translation.java
 * @author geyan
 *
 */
public class LeftRotate {

	public String LeftRotateString(String str, int n) {
		if (str.length() < n)
			return "";
		String str1 = "";
		String str2 = "";
		for (int i = 0; i < n; i++) {
			str1 += str.charAt(i);
		}
		for (int i = n; i < str.length(); i++) {
			str2 += str.charAt(i);
		}
		return reverse(reverse(str1) + reverse(str2));
	}

	/**
	 * ʵ���ַ�������
	 */
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

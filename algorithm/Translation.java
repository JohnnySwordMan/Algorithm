/**
 * ��Ŀ���ַ�����λ ����һ���ַ����������һ���㷨�����ַ����ĳ���Ϊlen��ǰ׺ƽ�Ƶ��ַ��������
 * ����һ���ַ���A�����ĳ��ȣ�ͬʱ����len���뷵��ƽ�ƺ���ַ����� ���������� "ABCDE",5,3 ���أ� "DEABC"
 * 
 * ������
 * ����һ���ַ���str��������i��i����str�е�λ�ã���str[0...i]�ƶ����Ҳ࣬str[i+1...N-1]�ƶ�����ࡣҪ��ʱ�临�Ӷ�ΪO(N),����ռ临�Ӷ�ΪO(1) 
 * 1.��str[0...i]�����ַ����� "ABCDE"--->"CBADE" 
 * 2.��str[i+1...N-1]�����ַ����� "CBADE" --->"CBAED"
 * 3.��str������ַ����� "CBAED" --->"DEABC"
 * 
 * @author geyan
 *
 */
public class Translation {
	public String stringTranslation(String A, int n, int len) {
		// String str1 = null;
		// String str2 = null;
		String str1 = "";
		String str2 = "";
		for (int i = 0; i < len; i++) {
			str1 += A.charAt(i);
		}
		for (int i = len; i < n; i++) {
			str2 += A.charAt(i);
		}
		return reverse(reverse(str1) + reverse(str2));
	}

	/**
	 * ʵ���ַ�������
	 * 
	 * @param str
	 * @return
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

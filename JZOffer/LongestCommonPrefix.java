/**
 * ��Ŀ���������ַ����������ǰ׺ 
 * ��Ŀ�������������飬��{"abcd","abcdef","abcde"}����������ַ����������ǰ׺
 * 
 * @author geyan
 *
 */
public class LongestCommonPrefix {

	/**
	 * ��Ȼ�������ǰ׺����ô������Ҳ�����������ַ����� ����һ���ַ�����Ϊ��׼�����������ıȽϣ���͵ڶ����ַ����Ƚϣ��õ��������ַ����Ĺ���ǰ׺��
	 * Ȼ�󽫸�ǰ׺��������ַ����Ƚ�
	 */
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length <= 0) {
			return "";
		}
		// ����һ���ַ�����Ϊ��׼
		String prefix = strs[0];
		int j = 0;
		for (int i = 1; i < strs.length; i++) {
			while (j < prefix.length() && j < strs[i].length() && prefix.charAt(j) == strs[i].charAt(j)) {
				j++;
			}
			// û�й���ǰ׺
			if (j == 0) {
				return "";
			}
			// ���¹���ǰ׺
			prefix = prefix.substring(0, j);
		}
		return prefix;
	}
}

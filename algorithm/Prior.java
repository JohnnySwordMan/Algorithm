/**
 * ��Ŀ��ƴ����С�ֵ��� 
 * ����һ���������ַ������飬���ҵ�һ��ƴ��˳��ʹ����С�ַ���ƴ�ӳɵĴ��ַ��������п��ܵ�ƴ�����ֵ�����С�ġ�
 * ����һ���ַ�������strs��ͬʱ�������Ĵ�С���뷵��ƴ�ӳɵĴ��� ���������� ["abc","de"],2 ���أ� "abcde"
 * 
 * ������ 
 * ������ str={"abc","de"};����ƴ�ӳ�"abcde"��Ҳ����ƴ�ӳ�"deabc"������ǰ��˳���С�����Է���"abcde"
 * str={"b","ba"};����ƴ��"bba"��Ҳ����ƴ��"bab"��ѡ���� 
 * --->���ԱȽ�str1��str2�Ĵ�С��˭С����ǰ�档 ���Ǵ���ġ�
 * ��ȷ�ıȽϷ�����str1+str2��str2+str1�Ƚϴ�С ���str1+str2<str2+str1����str1����ǰ��
 * 
 * ����һ����������
 * 
 * @author geyan
 *
 */
public class Prior {

	// ����һ����������Ƚ����������⣬ʱ�临�Ӷ�ΪO(N^2)
	public String findSmallest_1(String[] strs, int n) {
		String result = "";  // ����ʹ��StringBuilder
		for (int i = 1; i < n; i++) {
			for (int j = i; j > 0; j--) {
				if ((strs[j - 1] + strs[j]).compareTo(strs[j] + strs[j - 1]) <= 0) {
					continue;
				} else {
					// ����strs[j-1]��strs[j]λ��
					String temp = strs[j - 1];
					strs[j - 1] = strs[j];
					strs[j] = temp;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			result += strs[i];
		}
		return result;
	}
}

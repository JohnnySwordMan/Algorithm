/**
 * 
 * ������33���������ų���С����
 * ��Ŀ����������һ�����������飬����������������ƴ�������ĳ�һ��������ӡ��ƴ�Ӵ���������������С��һ����������������{3,32,321}�����ӡ���������������ĳɵ���С����Ϊ321332.
 * ����Ŀ��Learning/algorithm/string/Prior.java ƴ����С�ֵ������һ������ͬ���ǣ�������Ҫ������ת�����ַ���������Ƚϡ�
 * 
 * ��ȷ�ıȽϷ����Ǹ��������ַ���str1��str2�����str1+str2<str2+str1����str1����ǰ�棬����str2����ǰ�档�����ǵ����ıȽ�str1��str2�Ĵ�С��
 * 
 * @author geyan
 *
 */
public class PrintMinNumber {

	public String printMinNumber(int[] numbers) {
		String result = "";
		for (int i = 1; i < numbers.length; i++) {
			for (int j = i; j > 0; j--) {
				String str1 = numbers[j - 1] + "";
				String str2 = numbers[j] + "";
				if ((str1 + str2).compareTo(str2 + str1) <= 0) {
					continue;
				} else {
					int temp = numbers[j - 1];
					numbers[j - 1] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
		for (int i = 0; i < numbers.length; i++) {
			result += numbers[i];
		}
		return result;
	}
}

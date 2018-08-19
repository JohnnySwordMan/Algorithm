package LeetCode;

/**
 * ��Ŀ�����������ַ�����ʾ�ķǳ���Ĵ�������������ǵĳ˻���Ҳ�����ַ�����ʾ��������ϵͳ�Դ��Ĵ��������͡� ������ĿҲ�ǳ�����
 * 
 * @author geyan
 *
 */
public class Multiply {

	public String multiply(String num1, String num2) {
		char[] c1 = num1.toCharArray();
		char[] c2 = num2.toCharArray();
		int[] arr = new int[c1.length + c2.length - 1];
		for (int i = c1.length - 1; i >= 0; i--) {
			int k1 = c1[i] - '0';
			for (int j = c2.length - 1; j >= 0; j--) {
				int k2 = c2[j] - '0';
				arr[i + j] += k1 * k2;
			}
		}

		// ��λ
		int carry = 0;
		// arr[0]�������10��û��Ҫ��λ��
		for (int i = arr.length - 1; i > 0; i--) {
			arr[i] += carry;
			// ��λ
			carry = arr[i] / 10;
			arr[i] = arr[i] % 10;
		}
		// arr[0]
		arr[0] += carry;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}
		return sb.toString();
	}
}

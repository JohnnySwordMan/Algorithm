/**
 * ��Ŀ���׸��ظ��ַ�
 * ��Ŀ����������һ���ַ���(��һ��ȫΪ��ĸ)A�����ĳ���n��
 * �뷵�ص�һ���ظ����ֵ��ַ�����֤�ַ��������ظ��ַ����ַ����ĳ���С�ڵ���500��
 * 
 * ������HashMap��HashSet������[256]
 * ���Ҳ���Ҫ����char���飬�������ַ�����������ִ�����Ȼ����ȥ����arr���顣
 * ֻ��Ҫ�ڱ���char�����ʱ���ж϶�Ӧ��arr[c[i]]�Ƿ�Ϊ0
 * @author geyan
 *
 */
public class FirstRepeat {

	// ����ʵ�֣�����Ҫȫ������c֮����ȥ��������arr
	public char findFirstRepeat(String A, int n) {
		int[] arr = new int[256];
		char[] c = A.toCharArray();
		for (int i = 0; i < n; i++) {
			if (arr[c[i] - '0'] == 0) {
				arr[c[i] - '0'] = 1;
			} else {
				return c[i];
			}
		}
		return '\n';
	}
}

/**
 * ��Ŀ��������ʽƥ��
 * ��Ŀ��������ʵ��һ����������ƥ�����'.'��'*'��������ʽ��ģʽ�е��ַ�'.'��ʾ����һ���ַ�����'*'��ʾ��ǰ����ַ����Գ��������(����0��)��
 * �ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ�����磬�ַ���"aaa"��ģʽ"a.a"��"ab*ac*a"ƥ�䣬������"aa.a"��"ab*a"����ƥ��
 * 
 * ������ 
 * ��ģʽ�еĵڶ����ַ�����'*'ʱ�� 
 * 1.����ַ�����һ���ַ���ģʽ�еĵ�һ���ַ���ƥ�䣬��ô�ַ�����ģʽ������һ���ַ�
 * 2.����ַ�����һ���ַ���ģʽ�еĵ�һ���ַ���ƥ�䣬ֱ�ӷ���false
 * 
 * ��ģʽ�еĵڶ����ַ���'*'ʱ�� 
 * 1.����ַ�����һ���ַ���ģʽ��һ���ַ���ƥ�䣬��ģʽ����2���ַ�������ƥ��
 * 2.����ַ�����һ���ַ���ģʽ��һ���ַ�ƥ�䣬������3��ƥ�䷽ʽ�� 
 * 	1.ģʽ����2λ���൱��x*������
 * 	2.�ַ�������һλ��ģʽ����2λ���൱��'*'����1 
 * 	3.�ַ�������1λ��ģʽ���䣬����ƥ�䣬�൱��'*'��������1
 * 
 * ʱ�̼�������Ƿ�Խ��
 * @author geyan
 *
 */
public class Match {

	public boolean match(char[] str, char[] pattern) {
		if (str == null || pattern == null) {
			return false;
		}
		return matchCore(str, 0, pattern, 0);
	}

	public boolean matchCore(char[] str, int i, char[] pattern, int j) {
		// ƥ�䴮��ģʽ�������������˵��ƥ��ɹ�
		if (i >= str.length && j >= pattern.length) {
			return true;
		}
		// ֻ��ģʽ���ﵽ��β����ƥ��ʧ�ܡ�ƥ�䴮�ﵽ��β��һ��ʧ�ܣ���Ϊ�п���ģʽ���������'*'
		if (i != str.length && j >= pattern.length) {
			return false;
		}

		// -------------------
		// ģʽ����һ���ַ�Ϊ'*'
		if (j + 1 < pattern.length && pattern[j + 1] == '*') {
			// ƥ�䴮�Ѿ�����
			if (i >= str.length) {
				return matchCore(str, i, pattern, j + 2);
			} else {
				// ƥ�䴮û�н���
				if (str[i] == pattern[j] || pattern[j] == '.') {
					// ��3��ƥ�䷽ʽ
					boolean result = matchCore(str, i, pattern, j + 2) || matchCore(str, i + 1, pattern, j + 2)
							|| matchCore(str, i + 1, pattern, j);
					return result;
				} else {
					// ƥ�䴮��һ���ַ���ģʽ����һ���ַ���ƥ��
					return matchCore(str, i, pattern, j + 2);
				}
			}
		}

		// --------------------
		// ģʽ����һ���ַ�����'*'
		// ��Ҫ�ж�ƥ�䴮�Ƿ����
		if (i >= str.length) {
			return false;
		} else {
			if (str[i] == pattern[j] || pattern[j] == '.') {
				return matchCore(str, i + 1, pattern, j + 1);
			}
		}
		return false;
	}
}

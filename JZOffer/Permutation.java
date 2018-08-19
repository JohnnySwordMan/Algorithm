import java.util.ArrayList;
import java.util.Collections;

/**
 * ������28���ַ���������
 * ��Ŀ����������һ���ַ��������ֵ����ӡ�����ַ������ַ����������С�
 * ���������ַ���abc�����ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba��
 * 
 * 
 * �������Ȳ������ֵ����ӡ�����ǰ�һ���ַ�����������������ɣ���һ����Ϊ���ĵ�һ���ַ����ڶ������Ǻ���������ַ���
 * 1.����������п��ܳ����ڵ�һ��λ�õ��ַ������ѵ�һ���ַ���������е��ַ�����
 * 2.�̶���һ���ַ�������������ַ�������
 * 
 * ���磺abc
 * ��a�ڵ�һ��λ�ã�abc,�̶�a��λ�ã���bc���У���bc,cb
 * bac,cba
 * ����������һ���ݹ�
 * @author geyan
 *
 */
public class Permutation {
	public ArrayList<String> permutation(String str) {
		ArrayList<String> al = new ArrayList<>();
		if (str != null && str.length() > 0) {
			permutation(str.toCharArray(), 0, al);
		}
		Collections.sort(al);
		return al;
	}

	// �ݹ飺1.�ݹ����ʱ����Ҫ��ʲô��2.�ݹ������
	public void permutation(char[] c, int start, ArrayList<String> al) {
		if (start == c.length - 1) {
			// �Ѿ��������һ��Ԫ�أ���ֱ�ӽ����ַ�������ӵ�list��
			al.add(String.valueOf(c));
		} else {
			for (int i = start; i < c.length; i++) {
				// �ظ��ַ���������i==startʱ��Ҳ��Ҫ���������������ַ�����i!=startʱ���Ƚ����������в�����c[start]���ַ������ڵ�һ����Ȼ���ڱ������������ַ�
				if (i == start || c[i] != c[start]) {
					// ��iλ���ַ���startλ���ַ��������̶�ס���ڴ�start+1��ʼ�ݹ�
					swap(c, i, start);
					permutation(c, start + 1, al);
					// Ϊ�˷�ֹ�ظ������������Ҫ��start����Ԫ�����»�����
					swap(c, i, start);
				}

			}
		}
	}

	public void swap(char[] c, int i, int j) {
		char temp = c[i];
		c[i] = c[j];
		c[j] = temp;
	}
}

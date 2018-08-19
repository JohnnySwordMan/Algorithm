import java.util.*;

/**
 * ��Ŀ���������
 * ���������ַ���A��B�����A��B�г��ֵ��ַ�������ͬ��ÿ���ַ����ֵĴ�����ͬ����A��B��Ϊ���δʣ������һ����Ч�㷨��������������Ƿ�Ϊ���δʡ�
 * ���������ַ���A��B�����ǵĳ��ȣ��뷵��һ��boolֵ�����������Ƿ�Ϊ���δʡ�
 * 
 * @author geyan
 *
 */
public class Transform {

	// ʹ���������ģ��HashMap
	public boolean chkTransform(String a, int lena, String b, int lenb) {
		// ģ��map
		int[] map = new int[256];
		char[] charA = a.toCharArray();
		char[] charB = b.toCharArray();
		for (int i = 0; i < lena; i++) {
			map[charA[i]]++;
		}
		for (int i = 0; i < lenb; i++) {
			map[charB[i]]--;
		}
		for (int i = 0; i < 256; i++) {
			if (map[i] != 0)
				return false;
		}
		return true;

	}

	// ʹ��HashMap����������������ô�ж�����map����һ��
	public boolean chkTransform_1(String A, int lena, String B, int lenb) {
		Map<Character, Integer> mapA = new HashMap<>();
		Map<Character, Integer> mapB = new HashMap<>();
		for (int i = 0; i < lena; i++) {
			if (!mapA.containsKey(A.charAt(i))) {
				mapA.put(A.charAt(i), 1);
			} else {
				mapA.put(A.charAt(i), mapA.get(A.charAt(i)) + 1);
			}
		}

		for (int i = 0; i < lenb; i++) {
			if (!mapB.containsKey(B.charAt(i))) {
				mapB.put(B.charAt(i), 1);
			} else {
				mapB.put(B.charAt(i), mapB.get(B.charAt(i)) + 1);
			}
		}

		// ��ô�ж�����map�е������Ƿ�һ����
		// �һ�û�뵽��ô�Ϻõ��ж�����map��k-vֵ��ȫһ��
		return true;
	}

}

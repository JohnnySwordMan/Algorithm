import java.util.HashSet;
import java.util.Set;

/**
 * ��Ŀ������ظ��ַ��Ӵ� ����һ���ַ����������һ����Ч�㷨���ҵ��ַ���������ظ��ַ����Ӵ����ȡ�
 * ����һ���ַ���A�����ĳ���n���뷵����������ظ��ַ��Ӵ����ȡ���֤A���ַ�ȫ��ΪСдӢ���ַ����ҳ���С�ڵ���500��
 * 
 * ���������� "aabcb",5 ���أ� 3 "pwwkew" "pwpkew"
 * 
 * @author geyan
 *
 */
public class DistinctSubstring {
	// ����һ��set����
	public int longestSubstring_1(String A, int n) {
		Set<Character> set = new HashSet<>();
		int i = 0, j = 0, max = 0;
		while (j < A.length()) {
			if (!set.contains(A.charAt(j))) {
				// ���set������û�и��ַ��������
				set.add(A.charAt(j++));
				max = Math.max(max, set.size());
			} else {
				// �����ǰ�ַ��Ѿ�������set�����У�����ַ�����һ���ַ���ʼɾ����ֱ�����Ѵ���set���ϵĸ��ַ�ɾ��
				// �����ַ�ɾ�����ٴν���if�жϣ�����ǰ�ַ���ӵ������У�ÿһ�ε���ӣ���Ҫ���max��set.size()�нϴ�ֵ
				set.remove(A.charAt(i++));
			}
		}
		return max;
	}

	// û����
	public int longestSubstring_2(String A, int n) {
		if (A == null || n == 0)
			return 0;
		char[] chas = A.toCharArray();
		int[] map = new int[256]; // ģ��map����
		for (int i = 0; i < n; i++) {
			map[i] = -1;
		}
		int len = 0;
		int pre = -1;
		int cur = 0;
		for (int i = 0; i < n; i++) {
			pre = Math.max(pre, map[chas[i]]);
			cur = i - pre;
			len = Math.max(len, cur);
			map[chas[i]] = i;
		}
		return len;
	}
}

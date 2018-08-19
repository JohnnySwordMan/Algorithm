/**
 * ��Ŀ�����˽ṹ��ͬ������ �������ñ˴˶����Ķ�����A��B�����дһ����Ч�㷨�����A���Ƿ����һ��������B�������˽ṹ��ȫ��ͬ��
 * �������ö�������ͷ�ڵ��B���뷵��һ��boolֵ������A���Ƿ����һ��ͬ����B��������
 * 
 * ���������Ž�ʱ�临�Ӷ�ΪO(N+M)�������������л�+KMP�㷨 �����ö��������л����ַ�������ʽ���ж��ַ���B�Ƿ����ַ���A���Ӵ���
 * ע�⣺���ﲻ��ͨ����������������ʽ�������ַ�������Ϊ��ƾһ�ֱ�����ʽ�ǲ���ȷ��һ�������ġ� ʵ�֣�
 * ���������л���"#"����սڵ㣬"!"����һ���ڵ�Ľ��� ������ǰ������ķ�ʽ�������л���ǰ���������������������սڵ㣬���ַ���ĩβ����"#!"�����ַ�
 * 
 * @author geyan
 *
 */
public class IdenticalTree {

	public boolean chkIdentical(TreeNode A, TreeNode B) {
		String strA = serialByOreOrder(A);
		String strB = serialByOreOrder(B);
		// return strA.contains(strB);
		// ����ֱ��ʹ���ַ�����contains���������ж��Ӵ����⡣Ҳ����ʹ��KMP�㷨��
		int t = KMP_Index(strA.toCharArray(), strB.toCharArray());
		if (t != -1)
			return true;
		else
			return false;
	}

	/**
	 * ��ǰ������ķ�ʽ���ж��������л�
	 */
	private static String serialByOreOrder(TreeNode head) {
		if (head == null)
			return "#!";
		String result = head.val + "!";
		/*
		 * if (head.left != null) result += serialByOreOrder(head.left); if
		 * (head.right != null) result += serialByOreOrder(head.right);
		 */
		// ��ֻ��ǰ�����������ʱ����Ҫ�ж�head.left��head.right�Ƿ�Ϊ��
		// ���ﲻ��Ҫ������ж��ˣ���ô�ͻ���ִ������Ϊ�գ�������Ҫ���"#!"�ַ�
		result += serialByOreOrder(head.left);
		result += serialByOreOrder(head.right);
		return result;
	}

	// KMP�㷨
	private static int KMP_Index(char[] s, char[] p) {
		int[] next = getNextVal(p);
		int i = 0, j = 0;
		while (i < s.length && j < p.length) {
			if (j == -1 || s[i] == p[j]) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}
		if (j == p.length)
			return i - j;
		else
			return -1;
	}

	// ��ȡKMP�㷨�е�next����
	private static int[] getNextVal(char[] p) {
		int[] next = new int[p.length];
		next[0] = -1;
		int k = -1, j = 0;
		while (j < p.length - 1) {
			if (k == -1 || p[j] == p[k]) {
				++j;
				++k;
				if (p[j] != p[k]) {
					next[j] = k;
				} else {
					next[j] = next[k];
				}
			} else {
				k = next[k];
			}
		}
		return next;
	}
}

class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;
	}
}

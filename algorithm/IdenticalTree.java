/**
 * 题目：拓扑结构相同的子树 对于两棵彼此独立的二叉树A和B，请编写一个高效算法，检查A中是否存在一棵子树与B树的拓扑结构完全相同。
 * 给定两棵二叉树的头节点和B，请返回一个bool值，代表A中是否存在一颗同构于B的子树。
 * 
 * 分析：最优解时间复杂度为O(N+M)，二叉树的序列化+KMP算法 将两棵二叉树序列化成字符串的形式，判断字符串B是否是字符串A的子串。
 * 注意：这里不能通过遍历二叉树的形式来构造字符串，因为单凭一种遍历方式是不能确定一颗子树的。 实现：
 * 二叉树序列化："#"代表空节点，"!"代表一个节点的结束 假设用前序遍历的方式进行序列化，前序遍历二叉树，如果遇到空节点，在字符串末尾加上"#!"特殊字符
 * 
 * @author geyan
 *
 */
public class IdenticalTree {

	public boolean chkIdentical(TreeNode A, TreeNode B) {
		String strA = serialByOreOrder(A);
		String strB = serialByOreOrder(B);
		// return strA.contains(strB);
		// 可以直接使用字符串的contains方法，来判断子串问题。也可以使用KMP算法。
		int t = KMP_Index(strA.toCharArray(), strB.toCharArray());
		if (t != -1)
			return true;
		else
			return false;
	}

	/**
	 * 以前序遍历的方式进行二叉树序列化
	 */
	private static String serialByOreOrder(TreeNode head) {
		if (head == null)
			return "#!";
		String result = head.val + "!";
		/*
		 * if (head.left != null) result += serialByOreOrder(head.left); if
		 * (head.right != null) result += serialByOreOrder(head.right);
		 */
		// 当只是前序遍历二叉树时，需要判断head.left和head.right是否为空
		// 这里不需要，如果判断了，那么就会出现错误。如果为空，我们需要添加"#!"字符
		result += serialByOreOrder(head.left);
		result += serialByOreOrder(head.right);
		return result;
	}

	// KMP算法
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

	// 获取KMP算法中的next数组
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

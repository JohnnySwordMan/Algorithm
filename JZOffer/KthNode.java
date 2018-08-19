import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目：二叉搜索树的第k个节点
 * 题目描述：给定一棵二叉搜索树，请找出其中的第k大的节点。
 * 
 * 分析：中序遍历
 * @author geyan
 *
 */
public class KthNode {

	// 先中序遍历，再去遍历数组，找出第k个大小
	public TreeNode kthNode(TreeNode pRoot, int k) {
		ArrayList<TreeNode> al = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		if (pRoot == null) {
			return pRoot;
		}
		if (k <= 0) {
			return null;
		}
		TreeNode cur = pRoot;
		while (!stack.empty() || cur != null) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop();
				al.add(cur);
				cur = cur.right;
			}
		}
		if (al.size() < k) {
			return null;
		}
		// 找出第k个大小节点值
		return al.get(k - 1);
	}
}

import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目：按之字形顺序打印二叉树
 * 题目描述：请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行依次类推。
 * 
 * 分析： 
 * 按之字形顺序打印二叉树需要两个栈。我们在打印某一行节点时，把下一层的子节点保存到相应的栈里。
 * 如果当前打印的是奇数层，则先保存左子节点再保存右子节点到一个栈里。 
 * 如果当前打印的是偶数层，则先保存右子节点再保存左子节点到第二个栈里。
 * 
 * @author geyan
 *
 */
public class PrintTreeByZhi {

	public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
		// s1存奇数层节点
		Stack<TreeNode> s1 = new Stack<>();
		// s2存偶数层节点
		Stack<TreeNode> s2 = new Stack<>();
		if (pRoot == null) {
			return arrayList;
		}
		int layer = 1;
		s1.push(pRoot);
		while (!s1.empty() || !s2.empty()) {
			// 奇数层
			if (layer % 2 != 0) {
				ArrayList<Integer> temp = new ArrayList<>();
				while(!s1.empty()){
					TreeNode node = s1.pop();
					if(node != null){
						temp.add(node.val);
						// 先存左子节点，再存右子节点
						s2.push(node.left);
						s2.push(node.right);
					}
				}
				if(!temp.isEmpty()){
					arrayList.add(temp);
					layer++;
				}
			}
			// 偶数层
			else {
				ArrayList<Integer>  temp = new ArrayList<>();
				while(!s2.empty()){
					TreeNode node = s2.pop();
					if(node != null){
						temp.add(node.val);
						s1.push(node.right);
						s1.push(node.left);
					}
				}
				if(!temp.isEmpty()){
					arrayList.add(temp);
					layer++;
				}
			}
		}
		return arrayList;
	}
}

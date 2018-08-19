import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 题目：把二叉树打印成多行(层次遍历，参考/algorithm/binaryTree/LevelOrder.java)
 * 题目描述：从上到下按层打印二叉树，同一层节点从左至右输出。每一层输出一行。
 * 
 * @author geyan
 *
 */
public class Print {
	public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
		ArrayList<Integer> al = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if(pRoot == null){
			return arrayList;
		}
		// 设置last
		TreeNode last = pRoot;
		TreeNode nlast = null;
		queue.offer(pRoot);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			al.add(cur.val);
			if (cur.left != null) {
				queue.offer(cur.left);
				nlast = cur.left;
			}
			if (cur.right != null) {
				queue.offer(cur.right);
				nlast = cur.right;
			}
			if(cur == last){
				// 换行
				last = nlast;
				arrayList.add(al);
				al = new ArrayList<>(); 
			}
		}
		return arrayList;
	}
}

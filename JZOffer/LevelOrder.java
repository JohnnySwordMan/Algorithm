import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 题目：把二叉树打印成多行(层次遍历)
 * 题目描述：从上到下按层打印二叉树，同一层节点从左至右输出。每一层输出一行。
 * 
 * @author geyan
 *
 */
public class LevelOrder {
	
	/**
	 * 难点在于：什么时候换行
	 * 实现：定义两个变量last和nlast，last表示正在打印的当前行的最右节点；nlast表示下一行的最右节点
	 * 每一层从左到右遍历，如果遍历到last节点，则换行；换行之后，令last = nlast，重复上述步骤即可。
	 * nlast：跟踪记录层次遍历每次新加入队列的节点即可。
	 */
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
		// 在遍历树的时候，一般都是先让节点添加到队列或者栈中，然后出队列或栈的时候再去进行具体的逻辑
		queue.offer(pRoot);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			al.add(cur.val);
			// 若左子树不为空，则进入队列，更新nlast的值
			if (cur.left != null) {
				queue.offer(cur.left);
				nlast = cur.left;
			}
			// 若右子树不为空
			if (cur.right != null) {
				queue.offer(cur.right);
				nlast = cur.right;
			}
			// 如果已经遍历到当前行的最右节点，则换行
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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：有一棵二叉树，请设计一个算法，按照层次打印这棵二叉树。
 * 给定二叉树的根结点root，请返回打印结果，结果按照每一层一个数组进行存储，所有数组的顺序按照层数从上往下，且每一层的数组内元素按照从左往右排列。
 * 保证结点数小于等于500。
 * 
 * 分析：难点就是判断什么时候该换行 last表示正在打印的当前行的最右结点，nlast表示下一行的最右结点。
 * 假设每一层从左向右遍历，如果遍历到last结点，表示该换行了，换行之后，只要令last = nlast即可，重复上述步骤。
 * --->那么问题来了，如何正确地更新last和nlast呢？其实只需要让nlast跟踪记录宽度优先遍历(层次遍历)最新加入队列的结点。
 * 这是因为最新加入队列的结点一定是下一行最右结点。
 * 
 * 
 * @author geyan
 *
 */
public class LevelOrder {

	public static void main(String[] args) {
	}

	public static int[][] printTree(TreeNode root) {
		if (root == null)
			return null;
		// 存放所有行的列表，每一行存放的是ArrayList对象
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

		// 存放每一行元素的数组
		ArrayList<Integer> array = new ArrayList<>();

		// 队列实现
		Queue<TreeNode> queue = new LinkedList<>();

		// 设置last
		TreeNode last = root;
		TreeNode nlast = null;

		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();
			array.add(current.val);
			if (current.left != null) {
				// nlast表示最新加入队列的结点
				nlast = current.left;
				queue.offer(current.left);
			} /*
				 * else if (current.right != null) { // 这里怎么可以用else，else表示两者选其一
				 * 
				 * queue.offer(current.right); nlast = current.right; }
				 */

			if (current.right != null) { // 这里怎么可以用else，else表示两者选其一
				nlast = current.right;
				queue.offer(current.right);
			}

			if (current == last) {
				last = nlast;
				arrayList.add(array);
				array = new ArrayList<>();
			}
		}

		// 遍历结束后，将arrayList转换成二维数组的形式
		int[][] result = new int[arrayList.size()][];
		for (int i = 0; i < arrayList.size(); i++) {
			result[i] = new int[arrayList.get(i).size()];
			for (int j = 0; j < result[i].length; j++) {
				result[i][j] = arrayList.get(i).get(j);
			}
		}
		return result;
	}

	// 二叉树的层次遍历，类似于图的宽度优先遍历
	public static void levelIterator(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode cur = null;
		queue.offer(root);
		while (!queue.isEmpty()) {
			cur = queue.poll();
			System.out.print(cur.val + " ");
			if (cur.left != null) {
				queue.offer(cur.left);
			}
			// 这里同样不能用else啊
			if (cur.right != null) {
				queue.offer(cur.right);
			}
		}
	}

}

/**
 * 自定义二叉树的结点类 值，左右链接
 * 
 * @author geyan
 *
 */
class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;
	}
}

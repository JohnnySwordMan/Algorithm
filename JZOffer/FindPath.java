import java.util.ArrayList;

/**
 * 面试题25：二叉树中和为某一值的路径
 * 题目描述：输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。路径定义为从属的根节点开始往下一直到也节点所经多的节点形成的一条路径
 * 
 * 分析： 当用先序遍历的方式访问到某一节点时，我们把该节点添加到路径上，并累加该节点的值。
 * 如果该节点为叶节点并且路径中节点值的和刚刚好等于输入的整数，则当前的路径符合要求，我们把它打印出来。
 * 如果当前节点不是叶节点，则继续访问它的子节点。当前节点访问结束后，递归函数将自动回到它的父节点。
 * 因此，我们在函数退出之前要在路径上删除当前节点并减去当前节点的值，以确保返回父节点时路径刚好是从根节点到父节点的路径。
 * 
 * @author geyan
 *
 */
public class FindPath {

	public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {

		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> al = new ArrayList<>();
		return findPath(root, 0, target, arrayList, al);
	}

	public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int curSum, int target,
			ArrayList<ArrayList<Integer>> arrayList, ArrayList<Integer> al) {
		if (root == null)
			return arrayList;
		al.add(root.val);
		curSum += root.val;
		if (curSum < target) {
			// 左子树路径
			findPath(root.left, curSum, target, arrayList, al);
			// 右子树路径
			findPath(root.right, curSum, target, arrayList, al);
		} else if (curSum == target) {
			// 判断此时root是否为叶节点
			if (root.left == null && root.right == null)
				// 已经找到一条路径
				arrayList.add(new ArrayList<Integer>(al));
		} /*else {		
			al.remove(al.size() - 1);
		}*/
		// 移除当前节点，不能将它放在else中，因为如果此时已经找到一条路径，那么curSum==target成立，我们为了找另外一条路径，也需要删除最后一个节点
		al.remove(al.size()-1);
		return arrayList;
	}
}

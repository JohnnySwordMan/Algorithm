import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/**
 * 题目：树中两个节点的最低公共祖先
 * 多种情况
 * @author geyan
 *
 */
public class LCA {

	/**
	 * 假设该树是二叉查找树 分析： 1.如果root的值大于u,v的值，则u,v的最低公共祖先在root的左子树中
	 * 2.如果root的值小于u,v的值，则u,v的最低公共祖先在root的右子树中
	 * 3.如果root的值在u,v的值之间，则u,v在root的两侧，u,v的最低公共祖先就是root
	 */
	public TreeNode getLCA_1(TreeNode root, TreeNode u, TreeNode v) {
		int left = u.val;
		int right = v.val;
		// 使得left < right
		if (left > right) {
			int temp = left;
			left = right;
			right = temp;
		}
		while (true) {
			if (root.val < left) {
				// 条件2
				root = root.right;
			} else if (root.val > right) {
				// 条件1
				root = root.left;
			} else {
				// 条件3，left < root.val < right
				return root;
			}
		}
	}

	/**
	 * 假设是二叉树，但是不是二叉查找树 在root为根的二叉树中找u,v的LCA，
	 * 如果找到了就返回这个LCA，如果只碰到u，就返回u，如果只碰到v，就返回v，如果都没有，就返回null
	 */
	public TreeNode getLCA_2(TreeNode root, TreeNode u, TreeNode v) {
		if (root == null || root == u || root == v) {
			return root;
		}
		TreeNode left = getLCA_2(root.left, u, v);
		TreeNode right = getLCA_2(root.right, u, v);
		if (left != null && right != null) {
			return root;
		}
		if (left != null) {
			return left;
		}
		if (right != null) {
			return right;
		}
		return null;

	}

	// -------------求树中两个结点的最低公共祖先，此树不是二叉树，并且没有指向父节点的指针--------
	
	public TreeNodes getLastCommonParent(TreeNodes root, TreeNodes p1,TreeNodes p2){
		if(root == null || p1 == null || p2 == null){
			return null;
		}
		List<TreeNodes> path1 = new LinkedList<>();
		List<TreeNodes> path2 = new LinkedList<>();
		getNodePath(root,p1,path1);
		getNodePath(root,p2,path2);
		return getLastCommonNode(path1,path2);
	}

	/**
	 * 找目标节点的路径，即根节点到目标节点的路径
	 * 
	 * @param root
	 * @param target
	 * @param path
	 */
	public void getNodePath(TreeNodes root, TreeNodes target, List<TreeNodes> path) {
		if (root == null) {
			return;
		}
		path.add(root);
		List<TreeNodes> children = root.children;
		// 处理子节点
		for(TreeNodes node:children){
			if(node == target){
				path.add(node);
				return;
			} else {
				getNodePath(node,target,path);
			}
		}
		path.remove(path.size()-1);
	}
	
	/**
	 * 根据两条路径，找到该路径中最后一个相同节点
	 */
	public TreeNodes getLastCommonNode(List<TreeNodes> p1,List<TreeNodes> p2){
		Iterator<TreeNodes> ite1 = p1.iterator();
        Iterator<TreeNodes> ite2 = p2.iterator();
        TreeNodes last = null;
        while (ite1.hasNext() && ite2.hasNext()) {
            TreeNodes tmp = ite1.next();
            if (tmp == ite2.next()) {
                last = tmp;
            }
        }
        return last;
	}
}

class TreeNodes {
	int val;
	TreeNodes left;
	TreeNodes right;
	List<TreeNodes> children = new LinkedList<>();

	TreeNodes(int x) {
		val = x;
	}
}

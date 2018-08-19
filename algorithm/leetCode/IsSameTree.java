package LeetCode;

/**
 * 题目：判断两个二叉树是否是同一个
 * @author geyan
 *
 */
public class IsSameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q != null || p != null && q == null){
            return false;
        }
        if(p == null && q == null){
            return true;
        }
        if(p.val != q.val){
            return false;
        } else {
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
    }
}

/**
 * 树的子结构
 * Created by geyan on 2018/8/19.
 */
public class HasSubTree {

    /**
     * 题目：输入两颗二叉树A、B，判断B是不是A的子结构。空树不是任意一个树的子结构
     */
    public boolean hasSubTree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = isTree1ContainTree2(root1, root2);
            }
            if (!result) {
                result = isTree1ContainTree2(root1.left, root2);
            }
            if (!result) {
                result = isTree1ContainTree2(root1.right, root2);
            }
        }
        return result;
    }

    public boolean isTree1ContainTree2(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 != null) {
            return false;
        }
        if (root2 == null) {
            return true;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isTree1ContainTree2(root1.left, root2.left) && isTree1ContainTree2(root1.right, root2.right);
    }
}

import java.util.ArrayList;
import java.util.Stack;

/**
 * 面试题39：输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 *
 * @author geyan
 */
public class IsBalanced {

    public boolean isBalanced(TreeNode root) {
        boolean[] res = new boolean[1];
        // 初始认为是平衡的
        res[0] = true;
        getHeight(root, 1, res);
        return res[0];
    }

    /**
     * 后序遍历，判断根节点的左右子树高度差是否小于等于1
     * 在遍历一个节点之前，我们就已经知道该节点的左右子树的高度
     */
    private int getHeight(TreeNode root, int level, boolean[] res) {
        if (root == null)
            return level;
        int leftHeight = getHeight(root.left, level + 1, res);
        // 初始res[0]=true,如果高度差大于1，则为false
        if (!res[0]) {
            return leftHeight;
        }
        int rightHeight = getHeight(root.right, level + 1, res);
        if (!res[0]) {
            return rightHeight;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            // 左右子树高度差大于1
            res[0] = false;
            return Math.max(leftHeight, rightHeight);
        }
        return Math.max(leftHeight, rightHeight);
    }

    /**
     * 判断是否是二叉排序树 中序遍历每个节点，如果节点的值一直比上一个遍历的节点值要大，则说明是二叉排序树，否则不是。
     * 为了方便同时得到当前节点和上一个遍历的节点，二叉树中序遍历非递归实现较为合适。
     */
    private boolean isBinarySortTree(TreeNode root) {
        if (root == null)
            return false;
        ArrayList<Integer> al = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                al.add(cur.val);
                cur = cur.right;

            }
        }
        for (int i = 1; i < al.size(); i++) {
            if (al.get(i - 1) > al.get(i))
                return false;
        }
        return true;
    }
}

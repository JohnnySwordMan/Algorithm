/**
 * 二叉树的镜像
 * Created by geyan on 2018/8/19.
 */
public class Mirror {

    /**
     * 操作给定的二叉树，将其变换为原二叉树的镜像
     */

    public void mirror(TreeNode root){
        if(root == null){
            return;
        }

        // 交换左右子树
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 递归结束的标志
        if(root.left == null && root.right == null){
            return;
        }
        mirror(root.left);
        mirror(root.right);
    }
}

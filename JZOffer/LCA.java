import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/**
 * ��Ŀ�����������ڵ����͹�������
 * �������
 * @author geyan
 *
 */
public class LCA {

	/**
	 * ��������Ƕ�������� ������ 1.���root��ֵ����u,v��ֵ����u,v����͹���������root����������
	 * 2.���root��ֵС��u,v��ֵ����u,v����͹���������root����������
	 * 3.���root��ֵ��u,v��ֵ֮�䣬��u,v��root�����࣬u,v����͹������Ⱦ���root
	 */
	public TreeNode getLCA_1(TreeNode root, TreeNode u, TreeNode v) {
		int left = u.val;
		int right = v.val;
		// ʹ��left < right
		if (left > right) {
			int temp = left;
			left = right;
			right = temp;
		}
		while (true) {
			if (root.val < left) {
				// ����2
				root = root.right;
			} else if (root.val > right) {
				// ����1
				root = root.left;
			} else {
				// ����3��left < root.val < right
				return root;
			}
		}
	}

	/**
	 * �����Ƕ����������ǲ��Ƕ�������� ��rootΪ���Ķ���������u,v��LCA��
	 * ����ҵ��˾ͷ������LCA�����ֻ����u���ͷ���u�����ֻ����v���ͷ���v�������û�У��ͷ���null
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

	// -------------����������������͹������ȣ��������Ƕ�����������û��ָ�򸸽ڵ��ָ��--------
	
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
	 * ��Ŀ��ڵ��·���������ڵ㵽Ŀ��ڵ��·��
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
		// �����ӽڵ�
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
	 * ��������·�����ҵ���·�������һ����ͬ�ڵ�
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

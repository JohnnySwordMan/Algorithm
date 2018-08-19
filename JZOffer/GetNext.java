package JZOffer;

/**
 * ��Ŀ������������һ���ڵ�
 * ��Ŀ����������һ�������������е�һ���ڵ㣬���ҳ��������˳�����һ���ڵ㲢�ҷ��ء�ע�⣬���еĽڵ㲻�����������ӽڵ㣬ͬʱ����ָ�򸸽ڵ��ָ�롣
 * 
 * ������
 * 1.������Ϊ�գ��򷵻ؿ�
 * 2.����ýڵ�������������ô��һ���ڵ���������������е������ӽڵ�
 * 3.����ýڵ�û��������������ýڵ����丸�ڵ���������ڵ㣬��ô��һ���ڵ�����丸�ڵ�
 * 4.����ýڵ�û��������������ýڵ����丸�ڵ���������ڵ㣬��ô��������ָ�򸸽ڵ��ָ��һֱ���ϱ�����ֱ���ҵ�һ���������ڵ�����ӽڵ�Ľڵ㣬
 * ��������Ľڵ���ڣ���ô����ڵ�ĸ��ڵ����Ҫ�ҵ���һ���ڵ�
 * @author geyan
 *
 */
public class GetNext {

	public TreeLinkNode getNext(TreeLinkNode pNode) {
		if (pNode == null) {
			return null;
		}
		// ����Ҫ���ҵ���һ���ڵ�
		TreeLinkNode target = null;
		// ���1������ýڵ����������Ϊ�գ���Ҫ�ҵĽڵ���Ǹýڵ���������е�����ڵ�
		if (pNode.right != null) {
			target = pNode.right;
			while (target.left != null) {
				target = target.left;
			}
			// ����target��������Ҫ�ҵĸýڵ����������˳���е���һ���ڵ�
			return target;
		}
		// �ڵ�û�������������ϱ���
		else if (pNode.parent != null) {
			target = pNode.parent;
			// cur��target���ӽڵ�
			TreeLinkNode cur = pNode;
			while (target != null && target.left != cur) {
				// �ýڵ�û������������θýڵ����丸�ڵ���������ڵ�
				// ����ָ�򸸽ڵ��ָ��һֱ���ϱ�����ֱ���ҵ�һ���������ڵ�����ӽڵ�Ľڵ㣬
				// ��������Ľڵ���ڣ���ýڵ�ĸ��ڵ��������Ҫ�ҵ���һ���ڵ�
				cur = target;
				target = target.parent;
			}
			return target;
		}
		return null;
	}
}

class TreeLinkNode {
	int val;
	TreeLinkNode left = null;
	TreeLinkNode right = null;
	TreeLinkNode parent = null;

	TreeLinkNode(int val) {
		this.val = val;
	}
}
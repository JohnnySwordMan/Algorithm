public class TreeToListNode {
	public TreeNode Convert(TreeNode pRootOfTree) {
		// 用于保存转换后的双向链表的尾节点
		// 思考为什么会用到数组，而不是直接使用TreeNode tail = null;
		TreeNode[] lastNode = new TreeNode[1];
		convertNode(pRootOfTree,lastNode);
		// 根据双向链表的尾节点，找到头节点，注意该链表并不是循环链表
		TreeNode head = lastNode[0];
		while(head != null && head.left != null){
			head = head.left;
		}
		return head;
	}
	
	/**
	 * 分析：将二叉搜索树转换成排序的双向链表，中序遍历该二叉树
	 * @param node 当前的根节点
	 * @param lastNode 已经转换后的链表的尾节点
	 */
	public void convertNode(TreeNode node,TreeNode[] lastNode){
		if(node != null){
			// 若左子树不为null, 处理左子树
			if(node.left != null){
				convertNode(node.left,lastNode);
			}
			
			/*这样写是有问题的，开始lastNode[0] == null的，应该先设置好前驱，再去设置后继
			 * lastNode[0].right = node;
			 * node.left = lastNode[0];
			 * lastNode[0] = node;*/
			
			// 将当前节点的前驱指向已经处理好的双向链表的尾节点
			node.left = lastNode[0];
			// 若左子树转换成的双向链表不为空，设置尾节点的后继
			if(lastNode[0] != null){
				lastNode[0].right = node;
			}
			// 当前节点记为尾节点
			lastNode[0] = node;
			
			// 处理右子树
			if(node.right != null){
				convertNode(node.right,lastNode);
			}
		}			
	}
}

public class TreeToListNode {
	public TreeNode Convert(TreeNode pRootOfTree) {
		// ���ڱ���ת�����˫�������β�ڵ�
		// ˼��Ϊʲô���õ����飬������ֱ��ʹ��TreeNode tail = null;
		TreeNode[] lastNode = new TreeNode[1];
		convertNode(pRootOfTree,lastNode);
		// ����˫�������β�ڵ㣬�ҵ�ͷ�ڵ㣬ע�����������ѭ������
		TreeNode head = lastNode[0];
		while(head != null && head.left != null){
			head = head.left;
		}
		return head;
	}
	
	/**
	 * ������������������ת���������˫��������������ö�����
	 * @param node ��ǰ�ĸ��ڵ�
	 * @param lastNode �Ѿ�ת����������β�ڵ�
	 */
	public void convertNode(TreeNode node,TreeNode[] lastNode){
		if(node != null){
			// ����������Ϊnull, ����������
			if(node.left != null){
				convertNode(node.left,lastNode);
			}
			
			/*����д��������ģ���ʼlastNode[0] == null�ģ�Ӧ�������ú�ǰ������ȥ���ú��
			 * lastNode[0].right = node;
			 * node.left = lastNode[0];
			 * lastNode[0] = node;*/
			
			// ����ǰ�ڵ��ǰ��ָ���Ѿ�����õ�˫�������β�ڵ�
			node.left = lastNode[0];
			// ��������ת���ɵ�˫������Ϊ�գ�����β�ڵ�ĺ��
			if(lastNode[0] != null){
				lastNode[0].right = node;
			}
			// ��ǰ�ڵ��Ϊβ�ڵ�
			lastNode[0] = node;
			
			// ����������
			if(node.right != null){
				convertNode(node.right,lastNode);
			}
		}			
	}
}

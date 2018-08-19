package LeetCode;

/**
 * ��Ŀ������������ת����ƽ�������
 * 
 * ������ͨ������ָ���ҵ�������м�ڵ㣬���м�ڵ���Ϊ�������ĸ��ڵ㣬Ȼ����Ҫ��ԭ����Ͽ����ֳ�ǰ�������������ܱ����м�ڵ㣬�ٷֱ��ǰ���������ݹ�
 * @author geyan
 *
 */
public class SortedListToBST {
	public TreeNode sortedListToBST(ListNode head) {
		return toBST(head, null);
	}

	private TreeNode toBST(ListNode head, ListNode tail) {
		if (head == tail) {
			return null;
		}
		// ����ָ��
		ListNode slow = head;
		ListNode fast = head;
		while (fast != tail && fast.next != tail) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// ���м�ڵ�Ϊ���ڵ�
		TreeNode root = new TreeNode(slow.val);
		root.left = toBST(head, slow);
		root.right = toBST(slow.next, tail);
		return root;

	}
}

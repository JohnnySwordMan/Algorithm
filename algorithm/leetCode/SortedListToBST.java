package LeetCode;

/**
 * 题目：将有序单链表转换成平衡二叉树
 * 
 * 分析：通过快慢指针找到链表的中间节点，以中间节点作为二叉树的根节点，然后需要把原链表断开，分成前后两个链表，不能保护中间节点，再分别对前后链表做递归
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
		// 快慢指针
		ListNode slow = head;
		ListNode fast = head;
		while (fast != tail && fast.next != tail) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// 以中间节点为根节点
		TreeNode root = new TreeNode(slow.val);
		root.left = toBST(head, slow);
		root.right = toBST(slow.next, tail);
		return root;

	}
}

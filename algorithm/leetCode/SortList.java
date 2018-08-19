package LeetCode;

/**
 * 题目：链表排序
 * 题目描述：使用恒定的空间复杂度，时间复杂度为O(nlogn)
 * 
 * 分析：由时间复杂度为O(nlogn)，可以想出根据归并排序来实现，先找到链表的中间节点，使用slow和fast可以将原来的链表分成一般
 * @author geyan
 *
 */
public class SortList {

	public ListNode sortList(ListNode head) {
		// 链表为空，或只有一个节点，因为使用归并，只有一个节点，不好二分法呀
		if (head == null || head.next == null) {
			return head;
		}
		ListNode prev = null;
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = null;

		ListNode left = sortList(head);
		ListNode right = sortList(slow);
		
		return merge(left, right);
	}

	// 有序链表的合并
	private ListNode merge(ListNode head1, ListNode head2) {
		ListNode root = new ListNode(0);
		ListNode node = root;
		while (head1 != null && head2 != null) {
			if (head1.val < head2.val) {
				node.next = head1;
				head1 = head1.next;
			} else {
				node.next = head2;
				head2 = head2.next;
			}
			// 不能少了这一步
			node = node.next;
		}
		if (head1 != null) {
			node.next = head1;
		}
		if (head2 != null) {
			node.next = head2;
		}
		return root.next;
	}
}

package listNode;

/**
 * 题目：链表指定值清楚 题目描述：现在有一个单链表。链表中每个节点保持一个整数，再给定一个值val，把所有等于val的节点删除。
 * 给定一个单链表的头节点head，同时给定一个值val，请返回清楚后的链表的头节点，保证链表中有不等于该值的其他值。请保证其他元素的相对顺序。
 * 
 * @author geyan
 *
 */
public class ClearValue {

	/**
	 * 分析：遍历链表，判断节点的值是否等于给定val，在遍历链表的过程中，记录当前节点的前一个节点。同时需要判断删除的节点中是否含有头节点和尾节点
	 * 对于链表，在操作的过程中，可以分头节点，中间节点，尾节点
	 */
	public ListNode clear(ListNode head, int val) {
		if (head == null)
			return head;
		// 记录当前节点
		ListNode cur = head;
		// 记录当前节点的前驱节点
		ListNode pre = cur;
		// 暂时不考虑尾节点
		while (cur.next != null) {
			if (cur.val != val) {
				// 记录当前节点的前驱节点
				pre = cur;
				// 指向下一个节点
				cur = cur.next;
			} else {
				// 当头节点的值等于给定val时，并没有将其删除，需要后续操作
				pre.next = cur.next;
				cur = cur.next;
			}
		}
		// 尾节点，尾节点的值正好等于给定的val，则直接将pre.next = null
		if (cur.val == val) {
			pre.next = null;
		}

		// 针对头节点的值等于给定val
		if (head.val == val) {
			return head.next;
		}
		return head;
	}

	/**
	 * 分析：对于链表的操作，可以创建一个辅助节点作为头节点，免去判断头节点的删除，这样可以把head节点当作中间节点
	 */
	public ListNode clear_1(ListNode head, int val) {
		if (head == null)
			return head;
		ListNode node = new ListNode(0);
		node.next = head;
		ListNode cur = node;
		ListNode pre = cur;
		while (cur.next != null) {
			if (cur.val != val) {
				pre = cur;
				cur = cur.next;
			} else {
				pre.next = cur.next;
				cur = cur.next;
			}
		}
		if (cur.val == val) {
			pre.next = null;
		}
		return node.next;
	}
}

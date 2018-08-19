/**
 * 面试题：删除链表中重复的节点
 * 题目描述：在一个排序的链表中，存在重复的节点，请删除该链表中重复的节点，重复的节点不保留，返回链表的头指针。
 * 
 * 如果存在重复节点，全部删除
 * @author geyan
 *
 */
public class DeleteDuplication {

	public ListNode deleteDuplication(ListNode pHead) {
		if (pHead == null)
			return pHead;
		// 如果只有一个节点
		if (pHead.next == null)
			return pHead;
		// 新创建一个辅助节点，可以将第一个节点与之后的节点一起讨论
		ListNode root = new ListNode(-1);
		root.next = pHead;
		// 记录当前处理节点
		ListNode cur = pHead;
		// 记录前驱节点
		ListNode pre = root;
		while (cur != null && cur.next != null) {
			// 有重复节点
			if (cur.val == cur.next.val) {
				// 找到下一个与cur值不同的节点
				while (cur.next != null && cur.val == cur.next.val) {
					cur = cur.next;
				}
				// 不需要判断最后一个节点，原因就在于这个，比如1->2->5->5->5，内层while循环退出，此时cur指向最后一个5，那么pre.next
				// = cur.next，即pre.next = null;
				pre.next = cur.next;
			} else {
				pre = cur;
			}
			cur = cur.next;
		}
		// 这里并不需要判断最后一个节点
		return root.next;
	}
}

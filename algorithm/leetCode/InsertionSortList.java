package LeetCode;

/**
 * 题目：使用插入排序的方式进行链表排序
 * @author geyan
 *
 */
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		// 新建辅助节点
		ListNode dumy = new ListNode(Integer.MIN_VALUE);
		ListNode cur = head;
		ListNode pre = dumy;
		while (cur != null) {
			// 保存当前节点的下一个节点
			ListNode temp = cur.next;
			pre = dumy;

			while (pre.next != null && pre.next.val < cur.val) {
				pre = pre.next;
			}
			// cur节点插在pre与pre.next之间
			cur.next = pre.next;
			pre.next = cur;

			// 处理下一个待插入节点
			cur = temp;
		}
		return dumy.next;
	}
}

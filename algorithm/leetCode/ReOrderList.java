package LeetCode;

/**
 * 题目：链表的重新排序
 * 题目描述：给定链表L0→L1→…→Ln-1→Ln，重新排序后： L0→Ln →L1→Ln-1→L2→Ln-2→…
 * 
 * 分析：
 * 1.快慢指针，找出中间节点
 * 2.逆转后半部分链表
 * 3.合并链表
 * @author geyan
 *
 */
public class ReOrderList {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		// 1.快慢指针，找出中间节点
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// 作为后半部分的链表，等下需要逆转
		ListNode alter = slow.next;
		// 前半部分链表设置
		slow.next = null;

		// 2.逆转后半部分的链表，pre就是最后的头节点
		ListNode pre = null;
		while (alter != null) {
			// 保存下一个节点
			ListNode temp = alter.next;
			alter.next = pre;
			pre = alter;
			alter = temp;
		}

		// 3.合并两个链表
		ListNode first = head;
		alter = pre;
		while (first != null && alter != null) {
			ListNode firstNext = first.next;
			ListNode alterNext = alter.next;

			alter.next = first.next;
			first.next = alter;

			first = firstNext;
			alter = alterNext;
		}
	}
}

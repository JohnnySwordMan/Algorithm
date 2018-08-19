package LeetCode;

/**
 * 题目：判断链表中是否有环，环的起点
 * 
 * 分析：快慢指针
 * 对于判断链表中环的入口节点，详情见/algorithm/JZOffer/EntryNodeOfLoop.java
 * @author geyan
 *
 */
public class HasCycle {
	
	// 判断是否有环
	public boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

	// 找出链表中环的入口
	public ListNode detectCycle(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			// 第一次相遇
			if (slow == fast) {
				fast = head;
				while (fast != slow) {
					slow = slow.next;
					fast = fast.next;
				}
				return slow;
			}
		}
		return null;
	}
}

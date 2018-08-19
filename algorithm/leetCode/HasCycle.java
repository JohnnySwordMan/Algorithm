package LeetCode;

/**
 * ��Ŀ���ж��������Ƿ��л����������
 * 
 * ����������ָ��
 * �����ж������л�����ڽڵ㣬�����/algorithm/JZOffer/EntryNodeOfLoop.java
 * @author geyan
 *
 */
public class HasCycle {
	
	// �ж��Ƿ��л�
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

	// �ҳ������л������
	public ListNode detectCycle(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			// ��һ������
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

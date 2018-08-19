import java.util.Stack;

/**
 * 面试题37：两个链表的第一个公共节点 
 * 题目描述：输入两个链表，找出它们的第一个公共节点
 * 
 * @author geyan
 *
 */
public class FindFirstCommonNode {

	/**
	 * 方法一：两个栈，时间复杂度为O(n+m)，空间复杂度为O(n+m)
	 * 分别将这两个单链表上的节点压入栈中，然后同时出栈，最后一个相同节点，即为两个链表的公共节点
	 */
	public ListNode findFirstCommonNode_1(ListNode pHead1, ListNode pHead2) {
		if (pHead1 == null || pHead2 == null)
			return null;
		Stack<ListNode> s1 = new Stack<>();
		Stack<ListNode> s2 = new Stack<>();
		while (pHead1 != null) {
			s1.push(pHead1);
			pHead1 = pHead1.next;
		}
		while (pHead2 != null) {
			s2.push(pHead2);
			pHead2 = pHead2.next;
		}
		ListNode commonListNode = null;
		// 最后一个相同的节点
		while (!s1.isEmpty() && !s2.isEmpty() && s1.peek() == s2.peek()) {
			commonListNode = s1.pop();
			s2.pop();
		}
		return commonListNode;
	}

	/**
	 * 方法二：先分别遍历两个链表，求出链表长度length1，length2以及它们的长度差len =
	 * length1-length2或length2-length1，让较长的链表先走len步，然后同时遍历两个链表，当第一次遍历到相同节点时，返回该节点。
	 * 时间复杂度为O(n+m)，空间复杂度为O(1)
	 */
	public ListNode findFirstCommonNode_2(ListNode pHead1, ListNode pHead2) {
		if (pHead1 == null || pHead2 == null)
			return null;
		int length1 = getLength(pHead1);
		int length2 = getLength(pHead2);
		ListNode cur1 = pHead1;
		ListNode cur2 = pHead2;
		// 链表1长度大于等于链表2的长度，链表先遍历len长度
		if (length1 >= length2) {
			int len = length1 - length2;
			while (len > 0) {
				cur1 = cur1.next;
				len--;
			}
		} else {
			int len = length2 - length1;
			while (len > 0) {
				cur2 = cur2.next;
				len--;
			}
		}
		while (cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}

	private int getLength(ListNode pHead) {
		int count = 0;
		ListNode cur = pHead;
		while (cur != null) {
			count++;
			cur = cur.next;
		}
		return count;
	}
}

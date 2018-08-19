package LeetCode;

/**
 * ��Ŀ����������ĸ���
 * �����/algorithm/JZOffer/Clone.java
 * @author geyan
 *
 */
public class CopyRandomList {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return head;
		}

		// 1.�ȸ��ƽڵ㣬������randomָ��
		RandomListNode cur = head;
		while (cur != null) {
			RandomListNode temp = cur.next;
			RandomListNode newNode = new RandomListNode(cur.label);
			newNode.next = cur.next;
			cur.next = newNode;
			cur = temp;
		}

		// 2.����random

		cur = head;
		while (cur != null) {
			if (cur.random != null) {
				RandomListNode random = cur.random;
				cur.next.random = random.next;
			}
			cur = cur.next.next;
		}

		// 3.���
		RandomListNode newHead = head.next;
		RandomListNode newCur = newHead;
		head.next = newHead.next;
		head = head.next;
		while (head != null) {
			newCur.next = head.next;
			newCur = newCur.next;
			head.next = newCur.next;
			head = newCur.next;
		}
		return newHead;
	}
}

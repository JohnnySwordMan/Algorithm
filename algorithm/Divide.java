/**
 * 题目：链表的分化
 * 对于一个链表，我们需要用一个特定的阈值完成对它的分化，使得小于等于这个值的节点移到前面，大于该值的节点在后面，同时保证两类节点内部的位置关系不变。
 * 给定一个链表的头节点head，同时给定阈值val，请返回一个链表，使小于等于它的节点在前，大于等于它的在后，保证节点值不重复。
 * 
 * 分析： 链表分化，将链表分成2部分.第一部分是小于等于val的链表，其次是大于val的链表，最后合并链表
 * 
 * @author geyan
 *
 */
public class Divide {

	/**
	 * 指针的赋值，方便理解，直接看成是内存地址的赋值，这样不会出错
	 */
	public ListNode listDivide_1(ListNode head, int val) {
		if (head == null || head.next == null)
			return head;

		// 小于部分
		ListNode leftHead = null;
		ListNode leftTail = null;

		// 大于部分
		ListNode rightHead = null;
		ListNode rightTail = null;

		ListNode p = head;
		ListNode next = null;
		while (p != null) {
			// 先保存p的下一个节点
			next = p.next;
			// p是可以认为是最后一个链表，方便下面的链表分化，如果不将p.next设置为null，那么将p节点赋给leftHead或rightHead的话，比如会将p后面的节点一起链接到leftHead或rightHead上
			p.next = null;
			if (p.val <= val) { // =是对的
				if (leftHead == null) {
					leftHead = p;
					leftTail = p;
				} else {
					leftTail.next = p;
					leftTail = p;
				}
			} else {
				if (rightHead == null) {
					rightHead = p;
					rightTail = p;
				} else {
					rightTail.next = p;
					rightTail = p;
				}
			}
			p = next;
		}
		if (leftTail != null) {
			leftTail.next = rightHead;
		}
		return leftHead != null ? leftHead : rightHead;
	}

	/**
	 * 题目意思其实表达不好，题目原意是将小于等于val，放在左边，大于val的放在右边 测试样例：{1620,1134,861,563,1},1134
	 * 返回应该是{1134,861,563,1,1620} 以下代码输出的是{861,563,1,1134,1620}，改变了节点内部位置关系
	 */
	public ListNode listDivide_2(ListNode head, int val) {
		if (head == null || head.next == null)
			return head;

		// 小于部分
		ListNode leftHead = null;
		ListNode leftTail = null;

		// 等于部分
		ListNode valHead = null;
		ListNode valTail = null;

		// 大于部分
		ListNode rightHead = null;
		ListNode rightTail = null;

		ListNode p = head;
		ListNode next = null;
		while (p != null) {
			// 先保存p的下一个节点
			next = p.next;
			// p是可以认为是最后一个链表，方便下面的链表分化，如果不将p.next设置为null，那么将p节点赋给leftHead或rightHead的话，比如会将p后面的节点一起链接到leftHead或rightHead上
			p.next = null;
			if (p.val < val) {
				if (leftHead == null) {
					leftHead = p;
					leftTail = p;
				} else {
					leftTail.next = p;
					leftTail = p;
				}
			} else if (p.val > val) {
				if (rightHead == null) {
					rightHead = p;
					rightTail = p;
				} else {
					rightTail.next = p;
					rightTail = p;
				}
			} else {
				if (valHead == null) {
					valHead = p;
					valTail = p;
				} else {
					valTail.next = p;
					valTail = p;
				}
			}
			p = next;
		}
		if (leftTail != null) {
			leftTail.next = valHead;
		}
		if (valTail != null) {
			valTail.next = rightHead;
		}
		if (leftHead != null) {
			return leftHead;
		} else if (valHead != null)
			return valHead;
		else
			return rightHead;
	}

	// error写法
	public ListNode listDivide_error(ListNode head, int val) {
		ListNode head1 = null;
		ListNode head2 = null;
		ListNode head3 = null;
		// 遍历的时候，head指向不能移动，而应该p指向头节点，移动p指针
		while (head != null) {
			if (head.val < val) {
				head1 = head;
			} else if (head.val > val) {
				head3 = head;
			} else {
				head2 = head;
			}
			head = head.next;
		}
		ListNode p1 = head1;
		while (p1.next != null) {
			p1 = p1.next;
		}
		ListNode p2 = head2;
		while (p2.next != null) {
			p2 = p2.next;

		}

		p1.next = head2;
		p2.next = head3;
		return head;
	}

}

import java.util.HashSet;

/**
 * 面试题：链表中环的入口节点 
 * 题目描述：一个链表中包含环，请找出该链表的环的入口节点
 * 
 * @author geyan
 */
public class EntryNodeOfLoop {

	/**
	 * 方法一：HashSet 遍历链表，将节点添加到HashSet中，如果在遍历过程中发现某个节点已经存在，则该节点就是链表中环的入口
	 */
	public ListNode entryNodeOfLoop_1(ListNode pHead) {
		HashSet<ListNode> hs = new HashSet<>();
		ListNode cur = pHead;
		while (cur != null) {
			if (!hs.contains(cur)) {
				hs.add(cur);
				cur = cur.next;
			} else {
				return cur;
			}
		}
		return null;
	}

	/**
	 * 方法二：假设链表中节点的值都大于0，该方法需要修改链表，每当我们遍历一个节点时，将该节点的值赋值为0，若在遍历的过程中，发现某个节点的值为0，
	 * 则该节点就是链表中环的入口
	 */
	public ListNode entryNodeOfLoop_2(ListNode pHead) {
		ListNode cur = pHead;
		while (cur != null) {
			if (cur.val != 0) {
				ListNode temp = cur.next;
				cur.val = 0;
				cur = temp;
			} else {
				return cur;
			}
		}
		return null;
	}

	/**
	 * 方法三： 假设单链表中的环有N个节点，可以设置两个指针p1和p2，初始，p1,p2都指向头节点，指针p1先在链表中移动N步，然后p1,
	 * p2再同时移动， 当p2指向环的入口节点时，p1已经沿着环走了一圈又回到了入口节点时，即p1,p2相遇时，此时的节点就是环的入口。
	 * 我们需要知道环的节点数。fast，slow两个指针，fast每次走2步，slow每次走一步，当它们第一次相遇时，必定在环的某个节点处，
	 * 此时fast停止，slow继续走，从现在开始，当第二次相遇时，slow遍历的节点数就是环中节点的个数。这种操作可以求出环中节点的个数
	 * 
	 * 方法四： 
	 * 1.第一步，找到环中相汇点，fast,slow指向链表头节点，fast每次走2步，slow每次走1步，当fast==slow时，
	 * 此时在环中某个节点处相遇 
	 * 2.第二步，找环的入口节点，当fast == slow时，令fast从头节点开始遍历，每次走1步，slow从原来位置继续遍历，当再次相遇时，此时fast，slow指向的就是环的入口节点
	 * 
	 * 分析：当第一次相遇时slow所经历过节点数为x，而fast所经历过节点数为2x，假设环中有n个节点，当第一次相遇，fast比slow多走一个环，所以2x-x = n; 
	 * 即x = n，slow实际上走了一个环的步数(其实在方法三中，可以直接记录slow走的步数，在第一次相遇时，就可以得到环的节点数，没有必要再去进行第二次相遇)
	 * 假设链表头节点到环的入口节点距离为y，那么x-y表示slow在环中走过的距离，那么如果让slow再走y步，正好是走了一圈，那么此时slow指向的不就是环的入口吗？
	 * 怎么才能让slow再走y步呢?怎么控制y步，其实可以直接让fast从头节点开始，因为头节点到环的入口节点正好是y，所以fast，slow同时遍历，那么fast走y步，slow也走了y步，所以当fast==slow时，指向的就是环的入口
	 */
	public ListNode entryNodeOfLoop_4(ListNode pHead) {
		ListNode fast = pHead;
		ListNode slow = pHead;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			// 第一次相遇
			if (fast == slow) {
				fast = pHead;
				while (fast != slow) {
					fast = fast.next;
					slow = slow.next;
				}
				return slow;
			}
		}
		return null;
	}
}

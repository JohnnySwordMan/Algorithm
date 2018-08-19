public class InsertValue {

	public static void main(String[] args) {
		int[] A = { 1, 3, 4, 5, 7 };
		int[] nxt = { 1, 2, 3, 4, 0 };
		ListNode head = insert(A, nxt, 2);
		while (head.next != head) {
			System.out.print(head.val);
		}
	}

	public static ListNode insert(int[] A, int[] nxt, int val) {
		if (A.length == 0) {
			ListNode curNode = new ListNode(val);
			return curNode;
		}

		// 根据数组A和nxt，建立循环链表
		ListNode head = new ListNode(A[0]);
		ListNode tail = head;
		for (int i = 0; i < nxt.length - 1; i++) {
			// nxt数组中最后一位为0，表示节点7指向节点1，所以i<nxt.length-1
			ListNode curNode = new ListNode(A[nxt[i]]);
			tail.next = curNode;
			tail = curNode;
		}

		// 插入值为val的链表
		ListNode node = new ListNode(val);

		// 如果插在头节点前
		if (head.val >= val) {
			// 将值为val的节点插在head节点之前
			node.next = head;
			// 返回头节点
			return node;
		}

		ListNode previous = head;
		ListNode nextNode = previous.next;
		// 疑问：循环链表判断结束，难道不是p.next != head
		// 虽然是循环链表，但是可以按照单链表来实现，因为链表是从小到大排序，如果链表上最后一个节点的值还是小于val，即将新建的节点插入到最后
		// 怎么感觉就是在单链表上执行的，不是循环链表
		while (nextNode != null && nextNode.val < val) {
			previous = nextNode;
			nextNode = nextNode.next;
		}
		node.next = nextNode;
		previous.next = node;
		// 遍历链表
		// 有问题
		/*
		 * ListNode previous = null;
		 * while (head.next != head) { 
		 * 	if (head.val <=val) { 
		 * 		previous = head; 
		 * 		head = head.next; 
		 * 	} 
		 * 	ListNode node = new ListNode(val); 
		 * 	node.next = head; 
		 * 	previous.next = node; 
		 * }
		 */
		return head;
	}
}

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}

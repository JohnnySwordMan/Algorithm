/**
 * 面试题26：复杂链表的复制
 * 题目描述：输入一个复杂链表(每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点)，返回结果为复制后复杂链表的head
 * 
 * 不用辅助空间，时间复杂度为O(N)
 * @author geyan
 *
 */
public class Clone {

	public RandomListNode clone(RandomListNode pHead) {
		if (pHead == null)
			return pHead;
		// 第一步，复制原始链表的节点N，并创建新的节点N'，再把N'链接到N的后面
		cloneNode(pHead);

		// 第二步，如果原始链表上的节点N的random指向S，则它对应的复制节点N'的random指向S的下一个节点S'
		connectSiblingNodes(pHead);

		// 第三步，把第二步得到的链表拆分成两个链表，奇数位置上的节点组成原始链表，偶数位置上的节点组成复制出来的链表
		return reconnectNodes(pHead);
	}

	private static void cloneNode(RandomListNode pHead) {
		RandomListNode cur = pHead;
		while (cur != null) {
			// 创建新节点
			RandomListNode node = new RandomListNode(cur.label);
			// A'->B
			node.next = cur.next;
			// A->A'
			cur.next = node;
			// B
			cur = node.next;
		}
	}

	private static void connectSiblingNodes(RandomListNode pHead) {
		RandomListNode cur = pHead;
		while (cur != null) {
			// A'
			RandomListNode temp = cur.next;
			if (cur.random != null) {
				// A的Random链接
				RandomListNode randomNode = cur.random;
				temp.random = randomNode.next;
			}
			cur = temp.next;
		}
	}

	private static RandomListNode reconnectNodes(RandomListNode pHead) {
		// 用于记录复制链表的头节点
		RandomListNode newHead = pHead.next;
		// 用于记录当前处理的复制节点
		RandomListNode newCur = newHead;
		// 被复制的节点的next指向下一个被复制节点，A->B
		pHead.next = newHead.next;
		// 指向新的被复制节点，B
		pHead = pHead.next;
		while (pHead != null) {
			// A'->B'
			newCur.next = pHead.next;
			// B'
			newCur = newCur.next;
			// B.next = B'.next，即B->C
			// pHead的下一个指向复制节点的下一个节点
			pHead.next = newCur.next;
			// pHead指向下一个原来链表上的节点
			pHead = newCur.next;
		}
		return newHead;
	}
}

class RandomListNode {
	int label;
	RandomListNode next = null;
	RandomListNode random = null;

	RandomListNode(int label) {
		this.label = label;
	}
}

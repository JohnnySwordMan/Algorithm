/**
 * ������26����������ĸ���
 * ��Ŀ����������һ����������(ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ�)�����ؽ��Ϊ���ƺ��������head
 * 
 * ���ø����ռ䣬ʱ�临�Ӷ�ΪO(N)
 * @author geyan
 *
 */
public class Clone {

	public RandomListNode clone(RandomListNode pHead) {
		if (pHead == null)
			return pHead;
		// ��һ��������ԭʼ����Ľڵ�N���������µĽڵ�N'���ٰ�N'���ӵ�N�ĺ���
		cloneNode(pHead);

		// �ڶ��������ԭʼ�����ϵĽڵ�N��randomָ��S��������Ӧ�ĸ��ƽڵ�N'��randomָ��S����һ���ڵ�S'
		connectSiblingNodes(pHead);

		// ���������ѵڶ����õ��������ֳ�������������λ���ϵĽڵ����ԭʼ����ż��λ���ϵĽڵ���ɸ��Ƴ���������
		return reconnectNodes(pHead);
	}

	private static void cloneNode(RandomListNode pHead) {
		RandomListNode cur = pHead;
		while (cur != null) {
			// �����½ڵ�
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
				// A��Random����
				RandomListNode randomNode = cur.random;
				temp.random = randomNode.next;
			}
			cur = temp.next;
		}
	}

	private static RandomListNode reconnectNodes(RandomListNode pHead) {
		// ���ڼ�¼���������ͷ�ڵ�
		RandomListNode newHead = pHead.next;
		// ���ڼ�¼��ǰ����ĸ��ƽڵ�
		RandomListNode newCur = newHead;
		// �����ƵĽڵ��nextָ����һ�������ƽڵ㣬A->B
		pHead.next = newHead.next;
		// ָ���µı����ƽڵ㣬B
		pHead = pHead.next;
		while (pHead != null) {
			// A'->B'
			newCur.next = pHead.next;
			// B'
			newCur = newCur.next;
			// B.next = B'.next����B->C
			// pHead����һ��ָ���ƽڵ����һ���ڵ�
			pHead.next = newCur.next;
			// pHeadָ����һ��ԭ�������ϵĽڵ�
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

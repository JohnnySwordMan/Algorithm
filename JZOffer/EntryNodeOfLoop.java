import java.util.HashSet;

/**
 * �����⣺�����л�����ڽڵ� 
 * ��Ŀ������һ�������а����������ҳ�������Ļ�����ڽڵ�
 * 
 * @author geyan
 *
 */
public class EntryNodeOfLoop {

	/**
	 * ����һ��HashSet �����������ڵ���ӵ�HashSet�У�����ڱ��������з���ĳ���ڵ��Ѿ����ڣ���ýڵ���������л������
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
	 * �����������������нڵ��ֵ������0���÷�����Ҫ�޸�����ÿ�����Ǳ���һ���ڵ�ʱ�����ýڵ��ֵ��ֵΪ0�����ڱ����Ĺ����У�����ĳ���ڵ��ֵΪ0��
	 * ��ýڵ���������л������
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
	 * �������� ���赥�����еĻ���N���ڵ㣬������������ָ��p1��p2����ʼ��p1,p2��ָ��ͷ�ڵ㣬ָ��p1�����������ƶ�N����Ȼ��p1,
	 * p2��ͬʱ�ƶ��� ��p2ָ�򻷵���ڽڵ�ʱ��p1�Ѿ����Ż�����һȦ�ֻص�����ڽڵ�ʱ����p1,p2����ʱ����ʱ�Ľڵ���ǻ�����ڡ�
	 * ������Ҫ֪�����Ľڵ�����fast��slow����ָ�룬fastÿ����2����slowÿ����һ���������ǵ�һ������ʱ���ض��ڻ���ĳ���ڵ㴦��
	 * ��ʱfastֹͣ��slow�����ߣ������ڿ�ʼ�����ڶ�������ʱ��slow�����Ľڵ������ǻ��нڵ�ĸ��������ֲ�������������нڵ�ĸ���
	 * 
	 * �����ģ� 
	 * 1.��һ�����ҵ��������㣬fast,slowָ������ͷ�ڵ㣬fastÿ����2����slowÿ����1������fast==slowʱ��
	 * ��ʱ�ڻ���ĳ���ڵ㴦���� 
	 * 2.�ڶ������һ�����ڽڵ㣬��fast == slowʱ����fast��ͷ�ڵ㿪ʼ������ÿ����1����slow��ԭ��λ�ü������������ٴ�����ʱ����ʱfast��slowָ��ľ��ǻ�����ڽڵ�
	 * 
	 * ����������һ������ʱslow���������ڵ���Ϊx����fast���������ڵ���Ϊ2x�����軷����n���ڵ㣬����һ��������fast��slow����һ����������2x-x = n; 
	 * ��x = n��slowʵ��������һ�����Ĳ���(��ʵ�ڷ������У�����ֱ�Ӽ�¼slow�ߵĲ������ڵ�һ������ʱ���Ϳ��Եõ����Ľڵ�����û�б�Ҫ��ȥ���еڶ�������)
	 * ��������ͷ�ڵ㵽������ڽڵ����Ϊy����ôx-y��ʾslow�ڻ����߹��ľ��룬��ô�����slow����y��������������һȦ����ô��ʱslowָ��Ĳ����ǻ��������
	 * ��ô������slow����y����?��ô����y������ʵ����ֱ����fast��ͷ�ڵ㿪ʼ����Ϊͷ�ڵ㵽������ڽڵ�������y������fast��slowͬʱ��������ôfast��y����slowҲ����y�������Ե�fast==slowʱ��ָ��ľ��ǻ������
	 */
	public ListNode entryNodeOfLoop_4(ListNode pHead) {
		ListNode fast = pHead;
		ListNode slow = pHead;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			// ��һ������
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

import java.util.ArrayList;

/**
 * ��Ŀ����ӡ��������Ĺ���ֵ
 * ��Ŀ�����������������������������о����ظ�Ԫ�ء������һ����Ч���㷨����ӡ��������Ĺ������֡�
 * �������������ͷָ��headA��headB���뷵��һ��vector��Ԫ��Ϊ��������Ĺ������֡��뱣֤����������������������Ԫ�ظ�����С�ڵ���500.��֤һ���й���ֵ
 * ����������
 * {1,2,3,4,5,6,7} , {2,4,6,8,10}
 * 
 * ���أ�
 * [2,4,6]
 * @author geyan
 *
 */
public class FindCommonParts {
	/**
	 * �������ֱ����������ͷ�ڵ㿪ʼ����
	 * ��headA.val > headB.valʱ��headB = headB.next;
	 * ��headA.val < headB.valʱ��headA = headA.next;
	 * ��headA.val == headB.valʱ������Ԫ����ӵ������У�ͬʱheadA = headA.next;headB = headB.next;
	 * @param headA
	 * @param headB
	 * @return
	 */
	public int[] findCommonParts(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		ArrayList<Integer> al = new ArrayList<>();
		while (headA != null && headB != null) {
			if (headA.val < headB.val) {
				headA = headA.next;
			} else if (headA.val > headB.val) {
				headB = headB.next;
			} else {
				al.add(headA.val);
				headA = headA.next;
				headB = headB.next;
			}
		}
		int[] result = new int[al.size()];
		for (int i = 0; i < al.size(); i++) {
			result[i] = al.get(i);
		}
		return result;
	}
}

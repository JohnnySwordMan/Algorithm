import java.util.ArrayList;

/**
 * 题目：打印两个链表的公共值
 * 题目描述：现有两个升序链表，且链表中均无重复元素。请设计一个高效的算法，打印两个链表的公共部分。
 * 给定两个链表的头指针headA和headB，请返回一个vector，元素为两个链表的公共部分。请保证返回数组的升序。两个链表的元素个数均小于等于500.保证一定有公共值
 * 测试样例：
 * {1,2,3,4,5,6,7} , {2,4,6,8,10}
 * 
 * 返回：
 * [2,4,6]
 * @author geyan
 *
 */
public class FindCommonParts {
	/**
	 * 分析：分别从两个链表头节点开始遍历
	 * 当headA.val > headB.val时，headB = headB.next;
	 * 当headA.val < headB.val时，headA = headA.next;
	 * 当headA.val == headB.val时，将该元素添加到数组中，同时headA = headA.next;headB = headB.next;
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

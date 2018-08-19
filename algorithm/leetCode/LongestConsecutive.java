package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * ��Ŀ�����������
 * ��Ŀ����������һ��û����������飬�������������У�����[100,4,200,1,3,2]�������������Ϊ[1,2,3,4]�����Է���4�����Ӷ�ΪO(n)
 * 
 * ����������ʱ�临�Ӷ�ΪO(n)�����Բ���ʹ������
 * ʹ��Set���ϣ���������Ԫ�ض���ӵ�set�����У��������飬���������е�����һ��Ԫ��a������Set������ɾ����Ȼ����Set�����в���a-1��a+1�Ƿ�Ҳ�������У�����ڣ���������a-2,a+2�Ƿ���Set�����У�
 * ֱ����Set�����в��Ҳ�����
 * @author geyan
 *
 */
public class LongestConsecutive {
	public int longestConsecutive(int[] num) {
		Set<Integer> set = new HashSet<>();
		for (int item : num) {
			set.add(item);
		}
		int ans = 0;
		for (int item : num) {
			if (set.contains(item)) {
				set.remove(item);
				int pre = item - 1;
				int next = item + 1;
				while (set.contains(pre)) {
					set.remove(pre);
					pre--;
				}
				while (set.contains(next)) {
					set.remove(next);
					next++;
				}
				ans = Math.max(ans, next - pre - 1);
			}
		}
		return ans;
	}
}

package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ��Ŀ��������������(��ʼ���ʺͽ�������)��һ���ֵ䣬�ҳ��ӿ�ʼ���ʵ�����������̵�ת�����еĳ���
 * ע�⣺
 * 1.ÿ��ֻ�ܸı�һ����ĸ
 * 2.ÿһ���м�ĵ��ʱ������ֵ��еġ�
 * 
 * ���磺
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * 
 * ������̵�ת��Ϊ"hit"->"hot"->"dot"->"dog"->"cog"
 * ���س���Ϊ5.
 * 
 * ������
 * ��ÿ��������Ϊ�ڵ����BFS����ȡ�õ�ǰ�ַ���ʱ��������ÿһλ�ַ����д�a~z���滻��������ֵ����棬����ӣ�nextNum++(ͳ����һ��ĸ�������������)��
 * Ϊ�˱��⻷·����Ҫ�����ֵ����⵽�ĵ��ʴ��ֵ���ɾ�����Ѿ��滻�ַ�����ӵĵ��ʾ���Ϊ��һ����Ҫ�����ĵ��ʡ�
 * ����ΪBFS�ܹ���һ�����п����Զ������ˣ�����һ���ҵ���equals end�ĵ��ʣ���return ·����
 * �����ڲ�α�·���������ҵ����ȱ�������Ҷ�Ӳ�������������С�߶ȡ�
 * 
 *    	hit
 *    /     \
 *   hot
 *  /   \
 * dot  lot
 * /     /log
 * dog
 * /
 * cog
 * 
 * @author geyan
 *
 */
public class WordLadder {

	public int ladderLength(String start, String end, HashSet<String> dict) {
		if (start == null || end == null || start.length() <= 0 || end.length() <= 0
				|| start.length() != end.length()) {
			return 0;
		}
		Queue<String> q = new LinkedList<>();
		int level = 1;  // ��ǰ�Ĳ㼶
		int curNum = 1;  // ��ǰ��Ľڵ���
		int nextNum = 0;  // ��һ��Ľڵ���
		q.offer(start);
		while (!q.isEmpty()) {
			String s = q.poll();
			curNum--;  // ��ǰ��Ľڵ���-1
			// ��ÿ���ַ��滻��'a'~'z'
			for (int i = 0; i < s.length(); i++) {
				char[] c = s.toCharArray();
				for (char j = 'a'; j <= 'z'; j++) {
					c[i] = j;
					String str = new String(c);
					if (str.equals(end)) {
						// �Ѿ�ƥ��
						return level + 1;
					}
					if (dict.contains(str)) {
						q.offer(str);
						nextNum++;
						dict.remove(str);
					}
				}
			}
			if (curNum == 0) {
				curNum = nextNum;
				nextNum = 0;
				level++;
			}
		}
		return 0;
	}
}

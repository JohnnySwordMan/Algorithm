package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：给定两个单词(开始单词和结束单词)和一个字典，找出从开始单词到结束单词最短的转换序列的长度
 * 注意：
 * 1.每次只能改变一个字母
 * 2.每一个中间的单词必须是字典中的。
 * 
 * 例如：
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * 
 * 其中最短的转化为"hit"->"hot"->"dot"->"dog"->"cog"
 * 返回长度为5.
 * 
 * 分析：
 * 把每个单词作为节点进行BFS。当取得当前字符串时，对它的每一位字符进行从a~z的替换，如果在字典里面，就入队，nextNum++(统计下一层的个数，类似于树)，
 * 为了避免环路，需要把在字典里检测到的单词从字典里删除。已经替换字符并入队的单词就作为下一层需要遍历的单词。
 * 正因为BFS能够把一层所有可能性都遍历了，所以一旦找到了equals end的单词，就return 路径。
 * 类似于层次边路二叉树，找到最先遍历到的叶子层数就是树的最小高度。
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
		int level = 1;  // 当前的层级
		int curNum = 1;  // 当前层的节点数
		int nextNum = 0;  // 下一层的节点数
		q.offer(start);
		while (!q.isEmpty()) {
			String s = q.poll();
			curNum--;  // 当前层的节点数-1
			// 将每个字符替换成'a'~'z'
			for (int i = 0; i < s.length(); i++) {
				char[] c = s.toCharArray();
				for (char j = 'a'; j <= 'z'; j++) {
					c[i] = j;
					String str = new String(c);
					if (str.equals(end)) {
						// 已经匹配
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

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring {

    // 错误示范，以abcabcbb为例，可以看到这种写法，是将前后对比的
    public int lengthOfLongestSubstring(String s) {

        char[] chars = s.toCharArray();
        int count = 1;
        int start = 0;
        int end = 0;
        int maxLength = 1;
        char pre = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (pre != chars[i]) {
                count++;
                end = i;
                pre = chars[i];
            } else {
                pre = chars[i];
                count = i;
                maxLength = Math.max(maxLength, end - start);
                start = i;
                end = i;
            }
        }
        return maxLength;
    }

    /**
     * 假设S[i..j-1]没有重复字符，那么如果想要判断S[i...j]是否是没有重复字符，只需要判断S[j]是否存在S[i...j-1]字符串中，
     * 可以使用HashSet的方式，判断某个字符是否在字符串中，时间复杂度为O(1)。
     * 使用滑动窗口，[i, j)，在遍历过程中，如果没有Set集合中不存在当前遍历字符，则添加到Set集合中，j++；
     * 否则，从i开始依次删除Set集合中的元素，直到将Set集合中与当前遍历字符相同的字符删除。
     * <p>
     * 时间复杂度为O(n)，空间复杂度为O(n)
     */
    public int lengthOfLongestSubstring_1(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int i = 0, j = 0, res = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                res = Math.max(res, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return res;
    }

    public int lengthOfLongestSubstring_2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int i = 0, j = 0, res = 0;
        while (i < n && j < n) {
            // 不能因为包含，就不添加到map集合中
//            if (!map.containsKey(s.charAt(j))) {
//                map.put(s.charAt(j), j);
//                res = Math.max(res, j - i+1);
//            } else {
//                i = Math.max(i, map.get(s.charAt(j))+1);
//            }
//            j++;
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)) + 1);
            }
            map.put(s.charAt(j), j);
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }


    /**
     * 滑动窗口是数组/字符串问题中常用的抽象概念。
     * 窗口通常是在数组/字符串中由开始和结束索引定义的一系列元素的集合，即 [i, j)[i,j)（左闭，右开）。
     * 而滑动窗口是可以将两个边界向某一方向“滑动”的窗口
     */
}

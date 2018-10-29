/**
 * 分析详见笔记
 */
public class KMP {

    public int kmp(char[] s, char[] p) {
        // 获取next数组
        int[] next = getNext(p);
        int i = 0, j = 0;
        while (i < s.length && j < p.length) {
            if (j == -1 || s[i] == p[j]) {
                i++;
                j++;
            } else {
                // 调整j的大小
                j = next[j];
            }
        }
        if (j == p.length) {
            return i - j;
        }
        return -1;
    }

    /**
     * next数组求值，未优化
     */
    public int[] getNext(char[] p) {
        int[] next = new int[p.length];
        next[0] = -1;
        int k = -1, j = 0;
        while (j < p.length - 1) {
            // 前缀和后缀相等
            if (k == -1 || p[k] == p[j]) {
                ++k;
                ++j;
                // 代表p[j]之前的模式串子串中，有长度为k的相同前缀后缀
                next[j] = k;
            } else {
                // 如果前缀后缀不相等，则递归前缀索引，就能找出更短的相同前缀后缀
                k = next[k];
            }
        }
        return next;
    }

    /**
     * 优化next数组
     */
    public int[] getNextBetter(char[] p) {
        int[] next = new int[p.length];
        next[0] = -1;
        int k = -1, j = 0;
        while (j < p.length - 1) {
            if (k == -1 || p[k] == p[j]) {
                ++k;
                ++j;
                if (p[k] != p[j]) {
                    next[j] = k;
                } else {
                    next[j] = next[k];
                }
            } else {
                k = next[k];
            }
        }
        return next;
    }
}

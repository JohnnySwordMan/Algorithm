/*
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 
 * 示例:
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */
class MaxArea {

    // 暴力解法，时间复杂度为O(n^2)，空间复杂度为O(1)
    public int maxArea_1(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                res = Math.max(res, (j - i) * Math.min(arr[i], arr[j]));
            }
        }
        return res;
    }

    /**
     * 双指针法，时间复杂度为O(n)，空间复杂度为O(1)
     * 
     * 每次移动高度较短对应的指针
     * 
     * area = width * height，初始化width最大，随着慢慢收缩，width再减少，所以需要找到比之前大的height，
     * 这样才能保证可能存在这样一种情况：随着width的较少，面积比之前大。
     */
    public int maxArea_2(int[] arr) {
        int left = 0, right = arr.length - 1;
        int res = 0;
        while (left < right) {
            res = Math.max(res, (right - left) * Math.min(arr[left], arr[right]));
            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}

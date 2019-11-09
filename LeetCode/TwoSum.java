import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * <p>
 * 思考：该题并没有表示整数数组是有序的，因此不能使用arr[start] + arr[end] 是否等于target的二分法来解决
 */
public class TwoSum {

    // 暴力解决，时间复杂度为O(n^2)
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target - nums[i] == nums[j]) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

    // 使用HashMap，键值对为<nums[i],i>，时间复杂度为O(n)，空间复杂度为O(n)
    public int[] twoSum_1(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
            }
        }
        return res;
    }
}

import java.util.ArrayList;

/**
 * 最小的k个数
 * Created by geyan on 2018/8/14.
 */
public class GetLeastNumbers_Solution {

    /**
     * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
     * <p>
     * 分析：定义容量为k的数组temp，遍历数组，如果temp数组未满，则将数组中的元素直接加入到temp数组中；
     * 如果temp数组已满，则将数组中的元素与temp数组中的最大值进行比较，如果大于等于temp数组中的最大值，则不加入temp数组中，继续下一个元素；
     * 如果小于temp数组中的最大值，则替换temp数组中的最大值。
     * <p>
     * 实现方式：数组+最大堆
     *
     *
     * 补充说明：
     * 时间复杂度为O(NlogK)，特别适合处理海量数据
     * 创建一个大小为k的数据容器来存储最小的k个数字。遍历数组，如果容器未满时，将遍历的数字添加进去，如果容器已满，
     * 那么需要找出容器中最大值和当前遍历的值比较，如果当前遍历的值比容器中的最大值小，
     * 则用当前遍历的值替换容器中的最大值，如果当前遍历的值大于容器中的最大值，那么这个数不可能是最小的k个整数之一，所以跳过。
     *
     * 当容器满了，我们需要做：在k个数中找到最大值，要么替换掉最大值，要么什么都不做。
     * 可以用最大堆来实现找出k个整数中的最大值，那么我们可以在O(1)的时间内找到最大值，在O(logK)的时间内删除，插入
     *
     * 该算法的优点在于：
     * 1.没有修改输入的数据，只是读取数据，在容器中操作
     * 2.适合海量数据的输入。假设从海量数据中找出最小的k个数字，由于内存的大小是有限的，有可能不能把这些海量数据一次性全部载入内存。
     * 那么此时可以从辅助存储空间中每次读入一个数字或一些数字，根据该方法判断是不是需要放入内存。比较适合解决n很大，k很小的情况。
     */
    public ArrayList<Integer> getLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        if (input == null || input.length <= 0 || input.length < k || k == 0) {
            return al;
        }
        int[] arr = new int[k];
        int index = 0;
        for (int i = 0; i < input.length; i++) {
            if (index < k) {
                arr[index] = input[i];
                index++;
            } else {
                // 找出arr数组中的最大值
                maxHeadDown(arr);
                if (arr[0] > input[i]) {
                    arr[0] = input[i];
                }
            }
        }
        for (int i : arr) {
            al.add(i);
        }
        return al;
    }

    /** 最大堆实现*/
    public void maxHeadDown(int[] arr) {
        int c = 0, l = 2 * c + 1;
        int temp = arr[0];
        for (; l <= arr.length - 1; c = l, l = 2 * l + 1) {
            // 左右孩子中较大的那个孩子
            if (l < arr.length - 1 && arr[l] < arr[l + 1]) {
                l++;
            }
            if (temp > arr[l]) {
                return;
            } else {
                arr[c] = arr[l];
                arr[l] = temp;
            }
        }
    }
}

/**
 * 旋转数组的最小数字
 * Created by geyan on 2018/8/11.
 */
public class MinNumberInRotateArray {

    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     *
     * 分析：
     * 对于一个非递减的排序数组而言，其旋转数组(不是本身)实际上是可以划分为两个有序的子数组的，前面的子数组元素都大于或等于后面的子数组元素，
     * 而最小的元素正好是这两个子数组的分界线。最小元素是前面子数组最后一个元素的下一个，也是后面子数组的第一个元素。
     * 可以用二分法实现时间复杂度为O(logN)的查找。
     * 步骤：
     * 1.设置两个指针start,end分别指向数组的第一个元素和数组的最后一个元素，找到数组中间元素。
     * 2.如果中间元素大于等于start指针指向的第一个元素，则说明中间元素处于第一个子数组中，则将start指向该中间元素。
     * 3.如果中间元素小于等于end指向的元素，则说明中间元素处于第二个子数组中，则将end指向该中间元素。
     * 4.重复上述操作，最终start指针将指向第一个子数组的最后一个元素，而end指针将指向第二个子数组的第一个元素，
     * 如果start和end指向两个相邻的元素，则循环结束，最小元素就是end指向的元素。
     */

    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length <= 0)
            return 0;
        int start = 0, end = array.length - 1;
        while (true) {
            int mid = start + (end - start) / 2;
            if (array[start] <= array[mid]) {
                start = mid;
            } else if (array[end] >= array[mid]) {
                end = mid;
            }
            if (end - start == 1) {
                return array[end];
            }
        }
    }
}

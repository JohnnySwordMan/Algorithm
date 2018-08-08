/**
 * 二维数组的查找
 * Created by geyan on 2018/8/8.
 */
public class Find {

    /**
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     * 分析：选择右上角的元素array[0][array.length-1]与target比较，
     * 如果array[0][array.length-1] < target，则比较array[1][array.length-1]、target
     * 如果array[0][array.length-1] > target，则比较array[0][array.length-2]、target
     * 如果array[0][array.length-1] == target，则存在
     *
     * 时间复杂度为O(n+m)，空间复杂度为O(1)
     */
    public boolean find(int target, int[][] array) {
        if (array == null || array.length <= 0) {
            return false;
        }
        int row = 0, col = array[0].length - 1;

        while (row < array.length && col >= 0) {
            if (target == array[row][col]) {
                return true;
            } else if (target > array[row][col]) {
                row++;
            } else if (target < array[row][col]) {
                col--;
            }
        }
        return false;
    }
}




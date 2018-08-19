/**
 * 调整数组顺序使奇数位于偶数前面
 * Created by geyan on 2018/8/19.
 */
public class ReOrderArray {

    /**
     * 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
     * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     */

    public void reOrderArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                // 利用冒泡的思想，从后遍历，如果当前位置是奇数，并且前一个位置为偶数，才交换
                if(array[j] % 2 == 1 && array[j-1] % 2 == 0){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }
}

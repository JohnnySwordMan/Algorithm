/**
 * 查找第k个大小的元素
 * Created by geyan on 2018/8/19.
 */
public class GetNumberOfK {

    /**
     * 思路：利用快速排序的思想，先找出切分元素a[j]，那么在a[j]左边的元素都小于等于a[j]，在a[j]右边的元素都大于等于a[j]；
     * 将j与k比较，如果j>k，说明第k个大小的元素在a[j]的左边；如果j<k，说明第k个大小的元素在a[j]的右边；如果j=k，说明a[j]就是第k个大小的元素。
     *
     * 时间复杂度为:O(N)
     * N + N/2 + N/4 + ...
     */
    public int sort(int[] a, int left, int right, int k) {
        if (left < right) {
            int j = partition(a, left, right);
            if (j > k) {
                sort(a, left, j - 1, k);
            } else if (j < k) {
                sort(a, j + 1, right, k);
            } else {
                return a[j];
            }
        }
        return -1;
    }

    // 快排，寻找切分元素
    public int partition(int[] a, int left, int right) {
        int i = left, j = right + 1;
        int pivot = a[left];
        while (true) {
            while (a[++i] < pivot) {
                if (i == right)
                    break;
            }
            while (a[--j] > pivot) {
                if (j == left)
                    break;
            }
            if (i >= j)
                break;
            // 交换i,j
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        int temp = a[j];
        a[j] = a[left];
        a[left] = temp;
        return j;
    }

}

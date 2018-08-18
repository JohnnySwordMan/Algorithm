/**
 * 快速排序
 * Created by geyan on 2018/8/18.
 */
public class Quick {

    /**
     * 思想：将一个数组分成两个子数组，将两部分独立排序，当两个子数组有序时，整个数组也就有序了
     * 以数组a[left...right]为例，将a[left]作为切分元素pivot，先从数组的左端开始从左到右遍历，直到找到大于等于切分元素pivot的元素；
     * 再从数组的右端从右到左遍历，直到找到小于等于切分元素pivot的元素，如果左右指针未相遇，则交换左右指针指向的元素，保证左指针左边的元素不大于切分元素，
     * 右指针右侧的元素不小于切分元素。
     *
     * 平均时间复杂度为O(N*logN)，最坏时间复杂度为O(N*N)
     */

    /**
     * 寻找切分元素
     */
    public int partition(int[] arr, int left, int right) {
        int i = left, j = right + 1;
        int pivot = arr[left];
        while (true) {
            while (arr[++i] < pivot) {
                if (i == right) {
                    break;
                }
            }
            while (arr[--j] > pivot) {
                if (j == left) {
                    break;
                }
            }
            if (i >= j)
                break;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        int temp = arr[j];
        arr[j] = arr[left];
        arr[left] = temp;
        return j;
    }

    // M取值在5-15之间，在大多数情况下都不错
    private static final int M = 5;

    /**
     * 找到切分元素后，将一个数组分成两个子数组，然后递归
     */
    public void sort(int[] arr, int left, int right) {
        if (right <= left + M) {
            // 插入排序
            InsertSort(arr);
            return;
        }
        int j = partition(arr, left, right);
        sort(arr, left, j - 1);
        sort(arr, j + 1, right);
    }

    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    /**
     * 插入排序
     */
    public void InsertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 快排的三指针法，荷兰国旗问题
     * 在现实中待排序的关键字可能有很多的重复值，比如说对学生年龄排序、性别排序等，理论上，这些重复的值只需要处理一次即可
     */
    public void sort_3way(int[] arr, int left, int right) {
        if (right - left <= M) {
            InsertSort(arr);
            return;
        }
        int lt = left, i = left + 1, gt = right;
        int pivot = arr[left];
        while (i <= right) {
            if (arr[i] < pivot) {
                int temp = arr[i];
                arr[i] = arr[lt];
                arr[lt] = temp;
                i++;
                lt++;
            } else if (arr[i] > pivot) {
                int temp = arr[i];
                arr[i] = arr[gt];
                arr[gt] = temp;
                gt--;
            } else {
                i++;
            }
        }
        // 循环结束，arr[left...lt-1] < pivot = arr[lt...gt] < arr[gt+1...right]
        sort_3way(arr, left, lt - 1);
        sort_3way(arr, gt + 1, right);
    }
}

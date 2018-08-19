/**
 * 查找第k个大小的元素
 * Created by geyan on 2018/8/19.
 */
public class GetNumberOfK {

    public int sort(int[] a,int left,int right,int k){
        if(left < right){
            int j = partition(a, left, right);
            if(j>k){
                sort(a,left,j-1,k);
            } else if(j<k){
                sort(a,j+1,right,k);
            } else {
                return a[j];
            }
        }
        return -1;
    }

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

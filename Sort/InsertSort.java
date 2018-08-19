/**
 * 插入排序，将a[i]插入到a[i-1]，a[i-2]，a[0]中
 * 平均时间复杂度为O(N^2)
 * 最坏时间复杂度为O(N^2)
 * 空间复杂度为O(1)
 * 稳定
 * 每次循环是不能确定某个元素的固定位置的。
 * @author geyan
 *
 */
public class InsertSort {
	public static void sort(int[] a){
		for(int i=1;i<a.length;i++){
			for(int j=i;j>0;j--){
				if(a[j-1]>a[j]){
					int temp = a[j-1];
					a[j-1] = a[j];
					a[j] = temp;
				}
			}
		}
	}
}

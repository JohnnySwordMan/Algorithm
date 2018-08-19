/**
 * 选择排序，不断选择剩余元素中最小的
 * 1.找到数组中最小的元素
 * 2.将它和数组中的一个元素交换位置
 * 3.在剩余元素中找到最小的元素，将它和数组中的第二个元素交换位置，重复上述步骤。
 *
 * 平均时间复杂度为O(N^2)
 * 最坏时间复杂度为O(N^2)
 * 空间复杂度为O(1)
 * 不稳定的，比如5，8，5，2，9 排序，只有相邻的元素比较才是稳定的，如冒泡
 * 对于选择排序，若用链表实现或新建一个数组，则是稳定的。至于稳定还是不稳定，没必要在这上面争论，具体问题具体分析吧。
 * @author geyan
 *
 */
public class SelectSort {

	public static void sort(int[] a){
		for(int i=0;i<a.length;i++){
			int min = i;
			for(int j=i+1;j<a.length;j++){
				if(a[min]>a[j])
					min = j;
			}
			if(min != i){
				int temp = a[min];
				a[min] = a[i];
				a[i] = temp;
			}
		}
	}
}

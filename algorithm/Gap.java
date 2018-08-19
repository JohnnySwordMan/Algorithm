/**
 * 题目：相邻两数最大差值
 * 有一个整型数组a，请设计一个复杂度为O(n)的算法，算出排序后相邻两数的最大差值。
 * 给定一个int数组a和a的大小n，请返回最大的差值。保证数组元素多余1个。
 *
 * 分析：
 * 方法一：先排序，再计算相邻差值，这里采用堆排序，尽量让时间复杂度更小。时间复杂度为O(N*logN)，空间复杂度为O(1)（堆排序采用的是非递归写法）
 * 方法二：
 * @author geyan
 *
 */
public class Gap {

	public int maxGap(int[] a, int n){
		int max = 0;
		heapSort(a,a.length);
		for(int i=1;i<n;i++){
			max = Math.max(max,a[i]-a[i-1]);
		}
		return max;
	}

	public static void heapSort(int[] a,int n){
		for(int i=n/2-1;i>=0;i--)
			maxHeapDown(a,i,n-1);
		for(int i=n-1;i>0;i--){
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			maxHeapDown(a,0,i-1);
		}
	}

	public static void maxHeapDown(int[] a, int start, int end){
		int c = start;
		int l = 2*c+1;  // 这里设置，堆顶元素为数组下标为0的元素，而不是为1
		int temp = a[start];
		for(;l<=end;c=l,l=2*l+1){
			// 找出左右孩子结点中较大的结点
			if(l<end && a[l]<a[l+1])
				l++;
			// 如果根结点大于等于其左右孩子结点中较大的结点，则已经符合最大堆
			if(temp>=a[l])
				break;
			else {
				a[c] = a[l];
				a[l] = temp;
			}
		}
	}
}

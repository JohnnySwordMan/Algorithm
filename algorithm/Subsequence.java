/**
 * 题目：需要排序的最短子数组
 * 对于一个数组，请设计一个高效算法计算需要排序的最短字数组的长度。
 * 给定一个int数组a和数组大小n，请返回一个二元组，代表所求序列的长度。(原序列位置从0开始标号，若原序列有序，返回0)。保证a中元素均为正整数。
 * 测试样例：
 * [1,4,6,5,9,10],6
 * 返回：2
 * @author geyan
 *
 */
public class Subsequence {
	public static void main(String[] args) {
		int[] a = {1,4,6,5,9,10};
		System.out.println(shortestSubsequence(a,a.length));
	}

	/**
	 * 分析：
	 * 先从头开始遍历，如果遇到后一个元素小于前一个元素，则停止
	 * 从尾开始遍历，如果遇到前一个元素大于后一个元素，则停止
	 * 两次遍历的下标相减
	 */
	public static int shortestSubsequence(int[] a, int n){
		int left=0,right=0;
		int max = 0,min = n-1;
		for(int i=1;i<n;i++){
			if(a[max]<a[i])
				max = i;
			else if(a[max]>a[i])
				right = i;
		}

		for(int j=n-2;j>=0;j--){
			if(a[min]>a[j])
				min = j;
			else if(a[min]<a[j])
				left = j;
		}

		if(right-left==0)
			return 0;
		else 
			return right-left+1;
	}

	// 有问题，不要这样比较数组是否有序
	public static int shortestSubsequence_1(int[] a,int n){
		 int i=1,j=n-1;
			while(i<=j){
				while(a[i-1]<=a[i]){
	                if(i==n-1)
	                    break;
					i++;
				}
				while(a[j-1]<=a[j]){
	                if(j==1)
	                    break;
					//j--;
					--j;
				}
			}
			if(i==n-1 || j==0){
				return 0;
			} 
			return i-j+1;
	}
}

/**
 * 题目：有序数组合并
 * 有两个从小到大排序以后的数组a和b，其中a的末端有足够的缓冲空间容纳b。请编写一个方法，将b合并入a并排序。
 * 给定两个有序int数组a和b，a中的缓冲空用0填充，同时给定a和b的真实大小int n和int m，请返回合并后的数组。
 *
 * 分析：
 * 举例a = 2,4,6,0,0,0   b = 1,3,5。
 * a[n-1]和b[m-1]比较，较大的存放在a[a.length-1]上，然后a[n-2]再和b[m-1]比较，较大的存放在a[a.length-2]上
 *
 * 可以参考归并排序，只不过该题是从后往前遍历
 * 对于两个有序数组，要将其合并为一个有序数组，可以很容易的写出如下代码：
 * public void merge(int[] a,int[] b,int[] c){
     int i=0,j=0,k=0;
     while(i<=a.length && j<=b.length){
          if(a[i]<=b[j]){
               c[k++] = a[i++];
          } else{
               c[k++] = b[j++];
          }
     }
     while(i<=a.length){
          c[k++] = a[i++];
     }
     while(j<=b.length){
          c[k++] = b[j++];
     }
}


 * @author geyan
 *
 */
public class Merge {

	public int[] mergeAB(int[] a, int[] b, int n, int m) {
		int i=n-1,j=m-1;
		int k = a.length-1;
		while(i>=0 && j>=0){
			if(a[i]>=b[j]){
				a[k--] = a[i--];
			} else {
				a[k--] = b[j--];
			}
		}
		
		while(i>=0){
			a[k--] = a[i--];
		}
		while(j>=0){
			a[k--] = b[j--];
		}
		return a;
	}
}

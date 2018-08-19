/**
 * ��Ŀ����Ҫ��������������
 * ����һ�����飬�����һ����Ч�㷨������Ҫ��������������ĳ��ȡ�
 * ����һ��int����a�������Сn���뷵��һ����Ԫ�飬�����������еĳ��ȡ�(ԭ����λ�ô�0��ʼ��ţ���ԭ�������򣬷���0)����֤a��Ԫ�ؾ�Ϊ��������
 * ����������
 * [1,4,6,5,9,10],6
 * ���أ�2
 * @author geyan
 *
 */
public class Subsequence {
	public static void main(String[] args) {
		int[] a = {1,4,6,5,9,10};
		System.out.println(shortestSubsequence(a,a.length));
	}

	/**
	 * ������
	 * �ȴ�ͷ��ʼ���������������һ��Ԫ��С��ǰһ��Ԫ�أ���ֹͣ
	 * ��β��ʼ�������������ǰһ��Ԫ�ش��ں�һ��Ԫ�أ���ֹͣ
	 * ���α������±����
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

	// �����⣬��Ҫ�����Ƚ������Ƿ�����
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

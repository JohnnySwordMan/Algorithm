/**
 * ��Ŀ��������������ֵ
 * ��һ����������a�������һ�����Ӷ�ΪO(n)���㷨������������������������ֵ��
 * ����һ��int����a��a�Ĵ�Сn���뷵�����Ĳ�ֵ����֤����Ԫ�ض���1����
 *
 * ������
 * ����һ���������ټ������ڲ�ֵ��������ö����򣬾�����ʱ�临�Ӷȸ�С��ʱ�临�Ӷ�ΪO(N*logN)���ռ临�Ӷ�ΪO(1)����������õ��Ƿǵݹ�д����
 * ��������
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
		int l = 2*c+1;  // �������ã��Ѷ�Ԫ��Ϊ�����±�Ϊ0��Ԫ�أ�������Ϊ1
		int temp = a[start];
		for(;l<=end;c=l,l=2*l+1){
			// �ҳ����Һ��ӽ���нϴ�Ľ��
			if(l<end && a[l]<a[l+1])
				l++;
			// ����������ڵ��������Һ��ӽ���нϴ�Ľ�㣬���Ѿ���������
			if(temp>=a[l])
				break;
			else {
				a[c] = a[l];
				a[l] = temp;
			}
		}
	}
}

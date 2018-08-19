/**
 * ��Ŀ����������ϲ�
 * ��������С���������Ժ������a��b������a��ĩ�����㹻�Ļ���ռ�����b�����дһ����������b�ϲ���a������
 * ������������int����a��b��a�еĻ������0��䣬ͬʱ����a��b����ʵ��Сint n��int m���뷵�غϲ�������顣
 *
 * ������
 * ����a = 2,4,6,0,0,0   b = 1,3,5��
 * a[n-1]��b[m-1]�Ƚϣ��ϴ�Ĵ����a[a.length-1]�ϣ�Ȼ��a[n-2]�ٺ�b[m-1]�Ƚϣ��ϴ�Ĵ����a[a.length-2]��
 *
 * ���Բο��鲢����ֻ���������ǴӺ���ǰ����
 * ���������������飬Ҫ����ϲ�Ϊһ���������飬���Ժ����׵�д�����´��룺
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

/**
 * �������򣬽�a[i]���뵽a[i-1]��a[i-2]��a[0]��
 * ƽ��ʱ�临�Ӷ�ΪO(N^2)
 * �ʱ�临�Ӷ�ΪO(N^2)
 * �ռ临�Ӷ�ΪO(1)
 * �ȶ�
 * ÿ��ѭ���ǲ���ȷ��ĳ��Ԫ�صĹ̶�λ�õġ�
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

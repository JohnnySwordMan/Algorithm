/**
 * ��Ŀ������������
 * ������һ���к��ж��ź���ľ��������һ����Ч�㷨�����ٲ��Ҿ������Ƿ���ֵx��
 * ����һ��int����mat��ͬʱ���������Сn��m�������ҵ���x���뷵��һ��boolֵ������������Ƿ����x��
 * ���о��������ּ�x��Ϊint��Χ����������֤n��m��С�ڵ���1000��
 *
 * ������
 * ����һ������������findX_1()����
 * ��������findX()�����Žⷨ��ʱ�临�Ӷ�ΪO(n+m)���ռ临�Ӷ�ΪO(1)����Ҫ�����ж������ߣ����������ߡ�
 * @author geyan
 *
 */
public class Finder {
	
	/**
	 * 1 2 3
	 * 4 5 6
	 * 7 8 9
	 * ����������Ͻǿ�ʼ�����x��3С����ô�ж�2��x�Ĵ�С�����x��3�����ж�6��x�Ĵ�С��
	 * ����x��3С�����ж�x��2��С�����x����2������ȥ�ж�x��5�Ĵ�С��
	 * ��Ҫ�Ǿ��ж������ߣ����������ߡ�
	 */
	public boolean findX(int[][] mat, int n, int m, int x){
		// ī�سɹ�����������
		int i=0,j=m-1;
		while(i<n && j>=0){
			if(mat[i][j]>x){
				j--;
			} else if(mat[i][j] < x){
				i++;
			} else {
				return true;
			}
		}
		return false;
	}

	// ����ʱ��103ms��ռ���ڴ�945K
	public boolean findX_1(int[][] mat, int n, int m, int x){
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(mat[i][j] == x){
					return true;
				} else {
					continue;
				}
			}
		}
		return false;
	}

}

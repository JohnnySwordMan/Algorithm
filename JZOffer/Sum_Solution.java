/**
 * �����⣺��1+2+3+...+n
 * ��Ŀ��������1+2+3+...+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж����
 * 
 * ���������ö�·��ֵ���ݹ�
 * @author geyan
 *
 */
public class Sum_Solution {

	public int sum_solution(int n) {
		int sum = n;
		boolean flag = (n > 0) && ((sum += sum_solution(n - 1)) > 0);
		return sum;
	}
}

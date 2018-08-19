/**
 * ��Ŀ���Ϸ����������ж� ����һ���ַ����������һ���㷨���ж����Ƿ�Ϊһ���Ϸ������Ŵ���
 * ����һ���ַ���A�����ĳ���n���뷵��һ��boolֵ�������Ƿ�Ϊһ���Ϸ������Ŵ���
 * ����������
 * "(()())",6
 * ���أ�
 * true
 * 
 * ����������
 * "()a()()",7
 * ���أ�
 * false
 * 
 * ����������
 * "()(()()",7
 * ���أ�
 * fasle
 * 
 * ���������Ž� ʱ�临�Ӷ�ΪO(N)���ռ临�Ӷ�ΪO(1) 
 * 1.���ͱ���num����ʾ'('���ִ�����')'���ִ����Ĳ�ֵ
 * 2.���������У��������'('����num++; 
 * 3.���������У��������')'����num--; 
 * 4.���������У����num<0����ֱ�ӷ���false
 * 5.���û�г������4����һֱ������ȥ 
 * 6.�������������num=0���򷵻�true�����򷵻�false;
 * 
 * @author geyan
 *
 */
public class Parenthesis {

	public boolean chkParentthesis(String A, int n) {
		int num = 0;
		char[] str = A.toCharArray();
		for (int i = 0; i < n; i++) {
			if (str[i] != '(' && str[i] != ')')
				return false;
			if (str[i] == '(')
				num++;
			else
				num--;
			if (num < 0)
				return false;
		}
		if (num == 0)
			return true;
		else
			return false;
	}
}

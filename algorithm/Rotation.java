/**
 * ��Ŀ��������ת
 * �������һ���ַ���A����A��ǰ������һ����Ų�����ȥ�γɵ��ַ�����ΪA����ת�ʡ�����A="12345"��A����ת����"12345","23451",
 * "34512","45123"��"51234"�����������ַ���A��B�����ж�A��B�Ƿ�Ϊ��ת�ʡ�
 * ���������ַ���A��B�����ǵĳ���lena��lenb���뷵��һ��boolֵ�����������Ƿ�Ϊ��ת�ʡ�
 * 
 * ������ֻҪ�ж��ַ���B�Ƿ����ַ���A+A���Ӵ����� 1.�ж��ַ���A���ַ���B�����Ƿ���ȣ��������ȣ�û��Ҫ������
 * 2.�ж��ַ���B�Ƿ����ַ���A+A���Ӵ��� ����ʹ��contains������Ҳ����ʹ��KMP�㷨��
 * 
 * ˼���������ַ����ⲿ����Ŀ��������Ҫѧ��KMP�㷨��
 * 
 * @author geyan
 *
 */
public class Rotation {

	public boolean chkRotation_1(String A, int lena, String B, int lenb) {
		if (lena != lenb)
			return false;
		String str = A+A;
		if(str.contains(B))
			return true;
		else
			return false;
	}
	
	// KMP
	public boolean chkRotation(String A, int lena, String B, int lenb) {
		
	}
}

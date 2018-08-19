/**
 * 题目：两串旋转
 * 如果对于一个字符串A，将A的前面任意一部分挪到后边去形成的字符串称为A的旋转词。比如A="12345"，A的旋转词有"12345","23451",
 * "34512","45123"和"51234"。对于两个字符串A和B，请判断A和B是否互为旋转词。
 * 给定两个字符串A和B及他们的长度lena，lenb，请返回一个bool值，代表他们是否互为旋转词。
 * 
 * 分析：只要判断字符串B是否是字符串A+A的子串即可 1.判断字符串A和字符串B长度是否相等，如果不相等，没必要继续了
 * 2.判断字符串B是否是字符串A+A的子串。 可以使用contains方法，也可以使用KMP算法。
 * 
 * 思考：对于字符串这部分题目，还是需要学会KMP算法的
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

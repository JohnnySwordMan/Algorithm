/**
 * 题目：空格替换
 * 请编写一个方法，将字符串中的空格全部替换成"%20"。假定该字符串有足够的空间存放新增的字符，并且知道字符串的真实长度(小于等于1000)，
 * 同时保证字符串由大小写的英文字母组成。 
 * 测试样例： "Mr John Smith",13 返回： "Mr%20John%20Smith"
 * 
 * 分析：首先遍历str，找到空格数量，得到替换之后的数组大小。然后从后往前遍历
 * 
 * @author geyan
 *
 */
public class Replacement {

	// 需要新建数组
	public String replaceSpace(String str, int n) {
		int spaceNum = 0;
		char[] c = str.toCharArray();
		for (int i = 0; i < n; i++) {
			if (c[i] == ' ') {
				spaceNum++;
			}
		}

		// 新建数组
		char[] newC = new char[n + (3 - 1) * spaceNum];
		int k = 0;
		for (int i = 0; i < n; i++) {
			if (c[i] == ' ') {
				newC[k] = '%';
				newC[k + 1] = '2';
				newC[k + 2] = '0';
				k += 3;
			} else {
				newC[k++] = c[i];
			}
		}
		return new String(newC);
	}

	/**
	 * 需要判断String最后有没有空格，如果没有的话，split成数组的话，是不能在后面加"%20"
	 * 如果String最后是由空格的，那么需要注意的是有几个空格，最后要加几次
	 * "qw"来说，按照我的方法会变成"qw%20"，还是有错误，等我有空在看下
	 * @param str
	 * @param n
	 * @return
	 */
	public String replaceSpace_1(String str, int n) {
		String[] splitStr = str.split(" ");
		int leftSpace = n - splitStr.length;
		StringBuilder sb = new StringBuilder();
		/*
		 * for(int i=0;i<splitStr.length;i++){
		 * sb.append(splitStr[i]).append("%20"); }
		 */
		for (int i = 0; i < splitStr.length - 1; i++) {
			sb.append(splitStr[i]).append("%20");
		}
		sb.append(splitStr[splitStr.length - 1]);
		while (leftSpace > 0) {
			sb.append("%20");
			leftSpace--;
		}
		return sb.toString();
	}
}

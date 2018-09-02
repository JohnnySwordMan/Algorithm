/**
 * 题目：判断回文数字 
 * 题目描述：给定义数字，判断这个数字是否为回文数字，如121是回文数字，122不是回文数字
 * 
 * 思路：如果是回文数字，既然百十个位组成的数字为121，那么个十百位组成的数字应该也是121
 * 
 * @author geyan
 *
 */
public class PalindromeNumber {

	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		} else if (x == 0) {
			return true;
		} else {
			int temp = x;
			// 余数
			int y = 0;
			while (x != 0) {
				// 取个位上的数字
				y = y * 10 + x % 10;
				x = x / 10;
			}
			// 百十个位组成的数字与个十百位组成的数字相等，则是回文数字
			if (temp == y) {
				return true;
			} else {
				return false;
			}
		}
	}
}

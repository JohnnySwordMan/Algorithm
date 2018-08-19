/**
 * 题目：判断回文数字 
 * 题目描述：给定义数字，判断这个数字是否为回文数字，如121是回文数字，122不是回文数字
 * 
 * 思路：将该数字除以10，得到余数，将余数×10，加上该数字再除以10的余数。
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
				y = y * 10 + x % 10;
				x = x / 10;
			}
			if (temp == y) {
				return true;
			} else {
				return false;
			}
		}
	}
}

package LeetCode;

import java.util.Stack;

/**
 * 题目：evalute-reverse-polish-notation
 * 题目描述：Evaluate the value of an arithmetic expression in Reverse Polish Notation.Valid operators are+,-,*,/. Each operand may be an integer or another expression.
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * @author geyan
 *
 */
public class Solution_2 {

	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
				int num2 = stack.pop();
				int num1 = stack.pop();
				stack.push(calculate(num1, num2, tokens[i]));
			} else {
				stack.push(Integer.parseInt(tokens[i]));
			}
		}
		return stack.pop();
	}

	private int calculate(int num1, int num2, String str) {
		if (str.equals("+"))
			return num1 + num2;
		if (str.equals("-"))
			return num1 - num2;
		if (str.equals("*"))
			return num1 * num2;
		if (str.equals("/"))
			return num1 / num2;
		return 0;
	}
}

import java.util.ArrayList;

/**
 * 面试题41引申：和为s的连续正数序列 
 * 题目描述：输入一个正数s，打印出所有和为s的连续正数序列(至少含有两个数)
 * 
 * 
 * @author geyan
 *
 */
public class FindContinuousSequence {

	/**
	 * 和"和为s的两个数"不同，该题是要求出连续的序列，而不是简单的start + end，而是start + ...  +end
	 * 1.初始，start = 1,end = 2,curSum = start+end = 3
	 * 2.如果curSum < sum，此时应该让序列包含更多的数字，所以end++，直到满足，curSum = start + ... + end = sum。注意，不是让start++
	 * 3.如果curSum > sum，此时应该让序列包含更少的数字，所以start++，直到满足，curSum = start + ... + end = sum。注意，不是让end--
	 */
	public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {		
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
		int start = 1, end = 2;
		int mid = (sum+1)/2;
		int curSum = start+end;
		while (start < mid) {
			if(curSum == sum){
				arrayList.add(printContinuousSequence(start,end));
			}	
			// 注意：是连续的数相加，而不是start与end相加
			while(curSum>sum && start<mid){
				// 序列之和大于sum，需要做的就是让序列包含更少的数字，那么start++，直到满足条件为止
				curSum -= start;
				start++;
				if(curSum == sum){
					arrayList.add(printContinuousSequence(start,end));
				}
			}
			// 序列之和小于sum，需要做的就是让序列包含更多的数字，那么end++，直到满足条件为止
			end++;
			curSum += end;
		}
		return arrayList;
	}
	
	private ArrayList<Integer> printContinuousSequence(int start,int end){
		ArrayList<Integer> al = new ArrayList<>();
		for (int i = start; i <= end; i++) {
			al.add(i);
		}
		return al;
	}
}

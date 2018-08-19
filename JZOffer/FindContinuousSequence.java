import java.util.ArrayList;

/**
 * ������41���꣺��Ϊs�������������� 
 * ��Ŀ����������һ������s����ӡ�����к�Ϊs��������������(���ٺ���������)
 * 
 * 
 * @author geyan
 *
 */
public class FindContinuousSequence {

	/**
	 * ��"��Ϊs��������"��ͬ��������Ҫ������������У������Ǽ򵥵�start + end������start + ...  +end
	 * 1.��ʼ��start = 1,end = 2,curSum = start+end = 3
	 * 2.���curSum < sum����ʱӦ�������а�����������֣�����end++��ֱ�����㣬curSum = start + ... + end = sum��ע�⣬������start++
	 * 3.���curSum > sum����ʱӦ�������а������ٵ����֣�����start++��ֱ�����㣬curSum = start + ... + end = sum��ע�⣬������end--
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
			// ע�⣺������������ӣ�������start��end���
			while(curSum>sum && start<mid){
				// ����֮�ʹ���sum����Ҫ���ľ��������а������ٵ����֣���ôstart++��ֱ����������Ϊֹ
				curSum -= start;
				start++;
				if(curSum == sum){
					arrayList.add(printContinuousSequence(start,end));
				}
			}
			// ����֮��С��sum����Ҫ���ľ��������а�����������֣���ôend++��ֱ����������Ϊֹ
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

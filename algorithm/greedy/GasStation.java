/**
 * 题目：加油站问题
 * 题目描述：环形路线上有N个加油站，每个加油站有汽油gas[i]，从每个加油站到下一站消耗汽油cost[i]，问从哪个加油站出发能够回到起始点，
 * 如果都不能则返回-1.
 * 
 * @author geyan
 *
 */
public class GasStation {

	/**
	 * 分析： 
	 * 时间复杂度为O(n)
	 * 1.如果对所有加油站的sum(gas[i]-cost[i])<0，则无解
	 * 2.从0开始计算sum(gas[i]-cost[i])，当i=k时，sum<0，说明从0出发无法到达k。则0～k-1都不是正确的起始点，此时k作为起始点 
	 * 3.将sum清0，并从k出发，以此类推，直到从t出发，可以到达t+1~n-1，则t为起始点。
	 * gas[i]-cost[i]表示在第i站加油，达到第i+1站时，油箱里剩下的油(之前的油不算)
	 * 
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int start = 0, netGasSum = 0, curGasSum = 0;
		for (int i = 0; i < gas.length; i++) {
			// 对所有加油站
			netGasSum += gas[i] - cost[i];
			// 当前油箱里的油
			curGasSum += gas[i] - cost[i];
			if (curGasSum < 0) {
				// 说明从i出发不能达到第i+1站
				start = i + 1;
				curGasSum = 0;
			}			
		}
		if (netGasSum < 0) {
			return -1;
		}
		return start;
	}
}

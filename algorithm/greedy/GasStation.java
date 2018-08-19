/**
 * ��Ŀ������վ����
 * ��Ŀ����������·������N������վ��ÿ������վ������gas[i]����ÿ������վ����һվ��������cost[i]���ʴ��ĸ�����վ�����ܹ��ص���ʼ�㣬
 * ����������򷵻�-1.
 * 
 * @author geyan
 *
 */
public class GasStation {

	/**
	 * ������ 
	 * ʱ�临�Ӷ�ΪO(n)
	 * 1.��������м���վ��sum(gas[i]-cost[i])<0�����޽�
	 * 2.��0��ʼ����sum(gas[i]-cost[i])����i=kʱ��sum<0��˵����0�����޷�����k����0��k-1��������ȷ����ʼ�㣬��ʱk��Ϊ��ʼ�� 
	 * 3.��sum��0������k�������Դ����ƣ�ֱ����t���������Ե���t+1~n-1����tΪ��ʼ�㡣
	 * gas[i]-cost[i]��ʾ�ڵ�iվ���ͣ��ﵽ��i+1վʱ��������ʣ�µ���(֮ǰ���Ͳ���)
	 * 
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int start = 0, netGasSum = 0, curGasSum = 0;
		for (int i = 0; i < gas.length; i++) {
			// �����м���վ
			netGasSum += gas[i] - cost[i];
			// ��ǰ���������
			curGasSum += gas[i] - cost[i];
			if (curGasSum < 0) {
				// ˵����i�������ܴﵽ��i+1վ
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

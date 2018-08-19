/**
 * 题目：分糖果 
 * 题目描述：n个小朋友站成一排，每个小朋友必须至少有一个糖果，得分高的小朋友要比其相邻的小朋友糖果多。求最少需要多少糖果。
 * 
 * @author geyan
 *
 */
public class Candy {

	public int candy(int[] ratings) {
		// 如果只有一个小朋友或者没有小朋友
		if (ratings.length <= 1) {
			return ratings.length;
		}
		int[] candy = new int[ratings.length];
		candy[0] = 1;
		// 先从左向右遍历，得分较高的多拿一颗糖，如果第i个小孩等级比第i-1个高，那么i的糖果数目等于i-1的糖果数目+1
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				candy[i] = candy[i - 1] + 1;
			} else {
				candy[i] = 1;
			}
		}
		// 先从右向左继续分糖，如果第i个小孩的等级比第i+1个小孩高，但是糖果的数目却小或相等，那么i的糖果数目等于i+1的糖果+1
		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1] && candy[i] <= candy[i + 1]) {
				candy[i] = candy[i + 1] + 1;
			}
		}
		int result = 0;
		for (int i = 0; i < ratings.length; i++) {
			result += candy[i];
		}
		return result;
	}
}

/**
 * 题目：有序矩阵查找
 * 现在有一个行和列都排好序的矩阵，请设计一个高效算法，快速查找矩阵中是否含有值x。
 * 给定一个int矩阵mat，同时给定矩阵大小n×m及待查找的数x，请返回一个bool值，代表矩阵中是否存在x。
 * 所有矩阵中数字及x均为int范围内整数。保证n和m均小于等于1000。
 *
 * 分析：
 * 方法一：暴力搜索，findX_1()方法
 * 方法二：findX()，最优解法，时间复杂度为O(n+m)，空间复杂度为O(1)。主要就是判断向左走，还是向下走。
 * @author geyan
 *
 */
public class Finder {
	
	/**
	 * 1 2 3
	 * 4 5 6
	 * 7 8 9
	 * 从数组的右上角开始，如果x比3小，那么判断2和x的大小，如果x比3大，则判断6和x的大小。
	 * 假如x比3小，则判断x和2大小，如果x大于2，则再去判断x和5的大小。
	 * 主要是就判断向左走，还是向下走。
	 */
	public boolean findX(int[][] mat, int n, int m, int x){
		// 墨守成规是最致命的
		int i=0,j=m-1;
		while(i<n && j>=0){
			if(mat[i][j]>x){
				j--;
			} else if(mat[i][j] < x){
				i++;
			} else {
				return true;
			}
		}
		return false;
	}

	// 运行时间103ms，占用内存945K
	public boolean findX_1(int[][] mat, int n, int m, int x){
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(mat[i][j] == x){
					return true;
				} else {
					continue;
				}
			}
		}
		return false;
	}

}

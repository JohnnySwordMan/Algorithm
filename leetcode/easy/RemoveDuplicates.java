/**
 * 从排序数组中删除重复项
 * Created by geyan on 2018/9/2
 */
class RemoveDuplicates{
	/**
	 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
	 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
	 */
	public int removeDuplicates(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		int count = 0;
		for(int i = 0;i < nums.length;i++){
			if(nums[count] != nums[i]){
				nums[++count] = nums[i];
			}
		}
		return count + 1;
	}
}
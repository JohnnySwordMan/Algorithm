/**
 * 跳台阶
 * Created by geyan on 2018/8/12.
 */
public class JumpFloor {

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     * <p>
     * 分析：跳上n级台阶，可以从n-1级台阶上跳1步，也可以从n-2级台阶上跳2步。
     * 因此JumpFloor(n) = JumpFloor(n-1)+JumpFloor(n-2)
     * 其实就是斐波那契额数列
     */
    public int JumpFloor(int target) {
        if (target == 1 || target == 2) {
            return target;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    /** 迭代，类似于斐波那契额数列的问题，使用迭代的时间复杂度远远低于递归的*/
    public int JumpFloor_1(int target){
        if (target == 1 || target == 2) {
            return target;
        }
        // 跳上1级台阶的跳法
        int f1 = 1;
        // 跳上1级台阶的跳法
        int f2 = 2;
        int sum = 0;
        for (int i = 3;i<=target;i++){
            sum = f1+f2;
            f1 = f2;
            f2 = sum;
        }
        return sum;
    }

    /**
     *引申：一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶，...也可以跳上n级台阶，请问青蛙跳上n级台阶有多少种办法？
     *
     * 分析：
     * f(1) = 1
     * f(2) = 2
     * f(3) = f(3-1)+f(3-2)+f(3-3)。跳上3级台阶：如果先跳1级，则有f(3-1)种方法，如果先跳2级，则有f(3-2)种方法，如果先跳3级，则有f(3-3)种方法
     * f(4) = f(4-1)+f(4-2)+f(4-3)+f(4-4) . . .
     * f(n) = f(n-1)+f(n-2)+f(n-3)+...f(n-n)
     *
     * 即，f(n) = f(n-1) + f(n-1) = 2f(n-1)
     * 因此，f(n) = 2^(n-1)
     */
    public int JumpFloor_2(int target){
        return 2^(target-1);
    }
}

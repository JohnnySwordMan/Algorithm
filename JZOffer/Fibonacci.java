/**
 * 斐波那契数列
 * Created by geyan on 2018/8/12.
 */
public class Fibonacci {

    /** 递归，随着n的增大，时间复杂度以n的指数的方式递增的*/
    public int fibonacci(int n) {
        if(n == 0 || n == 1){
            return n;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }

    /**
     * 在递归的时候，会发现重复计算的情况。例如：f(4) = f(3)+f(2),f(3) = f(2)+f(1)；计算f(3)的时候会计算f(2)，
     * 而计算f(4)的时候也会计算f(2)。
     * 最简单的做法：从下往上计算。
     * 运行时间相较于递归，大概提高了100倍（代码测试）
     */
    public int fibonacci_1(int n){
        if(n == 0 || n == 1){
            return n;
        }
        int f1 = 0,f2 = 1;
        int temp = 0;
        for (int i = 2;i<=n;i++){
             temp = f1+f2;
             f1 = f2;
             f2 = temp;
        }
        return temp;
    }
}

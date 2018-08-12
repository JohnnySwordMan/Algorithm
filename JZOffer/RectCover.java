/**
 * 矩形覆盖
 * Created by geyan on 2018/8/12.
 */
public class RectCover {

    /**
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
     * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     *
     * 分析：本质上就是斐波那契数列
     * 当小矩形竖着放，f(n) = f(n-1);
     * 当小矩形横着放，f(n) = f(n-2);
     * 综上，f(n) = f(n-1) + f(n-2)
     * 递归，导致栈溢出
     */
    public int rectCover(int target) {
        if(target == 1 || target == 2){
            return target;
        }
        return rectCover(target-1) + rectCover(target-2);
    }

    /** 迭代*/
    public int rectCover_1(int target){
        if(target == 1 || target == 2){
            return target;
        }
        int f1 = 1,f2 = 2;
        int temp = 0;
        for(int i = 3;i<=target;i++){
            temp = f1+f2;
            f1 = f2;
            f2 = temp;
        }
        return temp;
    }
}

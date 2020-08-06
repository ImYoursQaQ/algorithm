package leetCode.Recursion;

/**
 * @author hubo
 * @date 2020-07-29
 * @description:
 */

public class Solution {

    public static double myPow(double x, int n) {
        if (x == 0){
            return 0;
        }
        long ln = n;
        if (n<0){
            x = 1/x;
            ln = -n;
        }
        double res = 1;
        while (ln>0){
            if ((ln&1) == 1){
                res = res*x;
            }
            x = x*x;
            ln = ln>>1;
        }
        return res;
    }

    private static double doMyPow(double x, long n) {


        double result = x;
        for (int i = 0; i < n; i++) {
            result = result*x;
        }
        return result;
    }

    public static void main(String[] args) {
        double v = myPow(2,
                10);
        System.out.println(v);
    }
}

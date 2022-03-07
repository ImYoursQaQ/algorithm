package leetCode.search;

/**
 * 69
 */
public class Solution69 {

    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        float low = 0, high = x;
        float tmp = 0;
        while (low <= high && Math.abs(tmp - x) > 1e-5) {
            float mid = (low + high) / 2;
            tmp = mid * mid;
            if (tmp == x) {
                return (int) mid;
            }
            if (tmp < x) {
                low = mid;
            }
            if (tmp > x) {
                high = mid;
            }
        }
        return (int) (low + high)/2;
    }

    public static void main(String[] args) {
        Solution69 solution69 = new Solution69();
        int i = solution69.mySqrt(9);
        System.out.println(i);
    }
}

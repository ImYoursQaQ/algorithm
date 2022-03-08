package leetCode.bitCount;

public class Solution7 {


    /**
     * 偷鸡法
     * @param x
     * @return
     */
    public int reverse(int x) {
        if (x == 0) {
            return x;
        }
        boolean isPos = true;
        if (x < 0) {
            isPos = false;
            x *= -1;
        }
        String before = String.valueOf(x);
        String after = new StringBuilder(before).reverse().toString();
        long tmp = Long.parseLong(after);
        int res = (int) tmp == tmp ? (int) tmp : 0;
        return isPos ? res : -1 * res;
    }

    /**
     * 标准答案
     * @param x
     * @return
     */
    public int reverse2(int x){
        long res = 0;
        while (x != 0){
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return (int) res == res ? (int) res:0;
    }
}

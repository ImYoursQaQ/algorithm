package leetCode.bitCount;

/**
 * 数二进制1的个数
 * 191。汉明位
 */
public class Solution {
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        if (n == 0){
            return 0;
        }
        int count = 0;
        while (n !=0){
            count ++;
            n = n & (n -1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(15));
    }
}
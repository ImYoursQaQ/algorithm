package leetCode.Arrays;

/**
 * @author teohubo
 */
public class Solution190 {

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            res |= (n & 1) << (31 - i);
            n = n >>> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int i = 1101;
        String s = Integer.toBinaryString(i);
        System.out.println(i >>> 1);
        System.out.println(s);
        System.out.println(i & 1);
    }
}

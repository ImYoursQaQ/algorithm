package leetCode.bitCount;

/**
 * 231. 2的幂
 */
class Solution4{
    public boolean isPowerOfTwo(int n) {
        int x = n & (n -1);
        return n > 0 && (x == 0);
    }
}
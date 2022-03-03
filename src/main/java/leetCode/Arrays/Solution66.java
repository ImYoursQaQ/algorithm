package leetCode.Arrays;

import java.util.Arrays;

/**
 * @author teohubo
 * 66题
 */
public class Solution66 {

    public int[] plusOne(int[] digits) {

        int length = digits.length;
        int[] res = new int[length];
        int yu = 1;
        for (int i = length - 1; i > -1; i--) {
            int sum = digits[i] + yu;
            yu = sum / 10;
            res[i] = sum % 10;
        }
        if (yu == 0) {
            return res;
        }

        int[] res2 = new int[length + 1];
        res2[0] = 1;
        //这里是不需要的，因为题目要求只会加一，结果只能是 100，1000，···
        for (int i = 1; i < length + 1; i++) {
            res2[i] = res[i - 1];
        }
        return res2;
    }

    public static void main(String[] args) {
        int[] input = {0};
        Solution66 solution66 = new Solution66();
        Arrays.stream(solution66.plusOne(input)).forEach(System.out::println);
    }
}

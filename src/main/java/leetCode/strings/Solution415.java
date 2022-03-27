package leetCode.strings;

/**
 * @author teohubo
 */
public class Solution415 {

    public String addStrings(String num1, String num2) {
        if (num1 == null || "".equals(num1)) {
            return num2;
        }
        if (num2 == null || "".equals(num2)) {
            return num1;
        }
        int length1 = num1.length();
        int length2 = num2.length();
        int i = length1 - 1, j = length2 - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int a = i >= 0?num1.charAt(i) - '0' : 0;
            int b = j >= 0?num2.charAt(j) - '0' : 0;
            int sum = a + b + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        if (carry == 1) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}

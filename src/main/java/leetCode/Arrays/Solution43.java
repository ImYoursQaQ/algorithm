package leetCode.Arrays;

/**
 * @author teohubo
 */
public class Solution43 {

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        String res = "0";
        for (int i = num2.length() - 1; i >= 0; i--) {
            //补0
            StringBuilder sb = new StringBuilder();
            for (int j = num2.length() - 1; j > i; j--) {
                sb.append(0);
            }
            int carry = 0;
            int a = num2.charAt(i) - '0';
            for (int j = num1.length() - 1; j >= 0; j--) {
                int b = num1.charAt(j) - '0';
                int sum = a * b + carry;
                sb.append(sum % 10);
                carry = sum / 10;
            }
            if (carry != 0) {
                sb.append(carry);
            }
            res = addStrings(res, sb.reverse().toString());
        }
        return res;
    }


    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution43 solution43 = new Solution43();
        String s = solution43.multiply("12", "34");
        System.out.println(s);
    }
}

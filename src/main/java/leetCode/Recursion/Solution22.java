package leetCode.Recursion;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution22 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return new ArrayList<>();
        }
        if (n == 1) {
            res.add("()");
        }
        List<String> strings = generateParenthesis(n - 1);
        for (String string : strings) {
            int length = string.length();
            for (int i = 0; i < length + 1; i++) {
                res.add(string.substring(0, i) + "()" + string.substring(i));
            }
        }
        return res.stream().distinct().collect(Collectors.toList());
    }

    public List<String> generateParenthesis2(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        dfsGen("", res, n, n);
        return res;
    }

    private void dfsGen(String tmp, List<String> res, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(tmp);
            return;
        }
        if (left > 0) {
            dfsGen(tmp + "(", res, left - 1, right);
        }
        if (right > left && right > 0) {
            dfsGen(tmp + ")", res, left, right - 1);
        }
    }

    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        solution22.generateParenthesis2(3);
    }
}

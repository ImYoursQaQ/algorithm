package leetCode.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 利用dfs 求 所有的字母组合
 */
public class Solution17 {

    public List<String> letterCombinations(String digits) {
        if (digits == null || "".equals(digits)) {
            return new ArrayList<>();
        }
        Map<Character, String> letterMap = new HashMap<>();
        letterMap.put('2', "abc");
        letterMap.put('3', "def");
        letterMap.put('4', "ghi");
        letterMap.put('5', "jkl");
        letterMap.put('6', "mno");
        letterMap.put('7', "pqrs");
        letterMap.put('8', "tuv");
        letterMap.put('9', "wxyz");
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(res, sb, 0, letterMap, digits);
        return res;
    }

    private void dfs(List<String> res, StringBuilder sb, int index, Map<Character, String> letterMap, String digits) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        char c = digits.charAt(index);
        char[] chars = letterMap.get(c).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
            dfs(res, sb, index + 1, letterMap, digits);
            sb.deleteCharAt(sb.length() -1);
        }
    }
}

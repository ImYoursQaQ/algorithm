package leetCode.stack;

import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author teohubo
 * 20 . 有效括号
 */
public class Solution20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> set = Stream.of('{', '}', '[', ']', '(', ')').collect(Collectors.toSet());
        for (int i = 0; i < s.toCharArray().length; i++) {
            char cur = s.charAt(i);
            if (set.contains(cur)) {
                if (stack.isEmpty()) {
                    stack.push(cur);
                }else {
                    Character top = stack.peek();
                    if ((top == '{' && cur == '}')
                            || (top == '[' && cur == ']')
                            || (top == '(' && cur == ')')
                    ) {
                        stack.pop();
                    }else {
                        stack.push(cur);
                    }
                }

            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String test = "({[)";
        Solution20 solution20 = new Solution20();
        System.out.println(solution20.isValid(test));
    }
}

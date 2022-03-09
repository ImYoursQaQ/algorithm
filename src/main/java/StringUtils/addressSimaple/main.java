package StringUtils.addressSimaple;

import java.util.*;
/**
* 利用栈实现的路径化简算法
*
* */

public class main {
    public static void main(String[] args) {
        String a = "/a/./b/.././c/";
        String b = addressSample(a); //理论：/a/c
        System.out.println(b);
    }

    private static String addressSample(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
        for (String dir : path.split("/")) {
            if ("..".equals(dir) && !stack.isEmpty()) {
                stack.pop();
            } else if (!skip.contains(dir)) {
                stack.push(dir);
            }
        }
        String res = "";
        for (String dir : stack) {
            res = "/" + dir + res;
        }
        return res.isEmpty() ? "/" : res;
    }
}

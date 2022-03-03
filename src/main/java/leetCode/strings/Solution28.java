package leetCode.strings;

/**
 * @author teohubo
 * 模式匹配问题使用kmp 算法即可。
 * todo 掌握kmp算法的原理
 */
public class Solution28 {

    public static int strStr(String haystack, String needle) {
       return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        String a = "aaaaa";
        String b = "bba";
        System.out.println(strStr(a,b));
    }
}

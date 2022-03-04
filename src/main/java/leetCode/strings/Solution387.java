package leetCode.strings;

/**
 * @author teohubo
 *
 * 387
 */
public class Solution387 {

    /**
     *  使用map 统计 每一个字符出现的次数
     *  第二次循环将首个计数为1的字符找出来
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        if (s == null || "".equals(s)){
            return -1;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            boolean flag = true;
            for (int j = 0; j < chars.length; j++) {
                if (j == i){
                    continue;
                }
                if (chars[i] == chars[j]){
                    flag = false;
                    break;
                }
            }
            if (flag){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution387 solution387 = new Solution387();
        System.out.println(solution387.firstUniqChar("aabb"));
    }

}

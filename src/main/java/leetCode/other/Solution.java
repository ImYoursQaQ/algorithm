package leetCode.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author hubo
 * @date 2020-07-29
 * @description:
 */

public class Solution {

    public int majorityElement(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        return nums[length / 2];
    }

    /**
     * 7 整数反转
     * 工程法，暴力法
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        boolean flag = false;
        if (x < 0) {
            flag = true;
            x = x * -1;
        }
        char[] chars = String.valueOf(x).toCharArray();
        int low = 0, high = chars.length - 1;
        while (low < high) {
            char tmp = chars[low];
            chars[low] = chars[high];
            chars[high] = tmp;
            low++;
            high--;
        }
        Integer integer = 0;
        try {

            integer = Integer.valueOf(new String(chars));
        } catch (Exception e) {
            return 0;
        }
        if (flag) {
            integer = integer * -1;
        }
        return integer;
    }

    public static int reverse2(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return (int) res == res ? (int) res : 0;
    }

    /**
     * 13 罗马数字转整数
     *
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int res = 0;
        HashMap<Character, Integer> map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        String str = "IVXLCDM";
        List<Character> list = new ArrayList(Arrays.asList('I', 'V', 'X', 'L', 'C', 'D', 'M'));
        char[] target = s.toCharArray();
        //res += map.get(target[0]);
        //int i = 0;
//        while (i < target.length){
//            if (i)
//        }
        for (int i = 0; i < target.length; i++) {
            if (i < target.length - 1 && list.indexOf(target[i + 1]) > list.indexOf(target[i])) {
                res += map.get(target[i + 1]) - map.get(target[i]);
                i++;
            } else {
                res += map.get(target[i]);
            }
        }
        return res;
    }

    /**
     * 14. 最长公共前缀
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String str0 = strs[0];
        char[] chars = new char[str0.length()];
        for (int k = 0; k < str0.length(); k++) {
            char c = str0.toCharArray()[k];
            for (int i = 1; i < strs.length; i++) {
                if (k > strs[i].length() - 1) {
                    return String.valueOf(chars).trim();
                }
                char c1 = strs[i].toCharArray()[k];
                if (c != c1) {
                    return String.valueOf(chars).trim();
                }
            }
            chars[k] = c;
        }
        return String.valueOf(chars).trim();
    }

    /**
     * 53. 最大子序和
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        return res;
    }

    /**
     * 204 计数质数
     * @param n
     * @return
     */
    public static int countPrimes(int n) {
        int res = 0;
        if (n <= 2) return 0;
        List<Integer> primesList = new ArrayList<>();
        for (int i = 2; i < n; i++) {
           if (isPrimes(i,primesList)){
               res++;
           }
        }
        return res;
    }

    private static boolean isPrimes(int x, List<Integer> primesList) {
        boolean flag = true;
        if(x ==1 || x %2 ==0 && x !=2 ) {
            flag = false;
        }else {
            for (Integer integer : primesList) {
                if (x % integer == 0){
                    flag = false;
                    break;
                }
            }
        }
        primesList.add(x);
        return flag;
    }

    /**
     * 326 3的幂
     * @param n
     * @return
     */
    public static boolean isPowerOfThree(int n) {
        if (n == 1) return true;
        if (n == 0 || n == 2)return false;
        boolean res = true;
        while (n!= 1  ){
            if (n % 3 !=0){
                res = false;
                break;
            }
            n = n/3;

        }
        return res;
    }

    /**
     * 异或法求出现奇数次的元素
     * @param nums
     * @return
     */
    int method(int[] nums){
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }



   static String huiwen1(String str){
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            String sub = str.substring(0,str.length()-i);
            if (huiwen(sub)){
                res =  sub;
                break;
            }
        }
        return res;
    }
     static boolean huiwen(String str){
        if (str.isEmpty() ){
            return true;
        }

        boolean res = true;
        int low = 0, high = str.length()-1;
        while (low < high){
            if (str.charAt(low) != str.charAt(high)){
                res = false;
                break;
            }
            low ++;
            high --;
        }
        return res;
    }


    public static void main(String[] args) {
        String s = huiwen1("abcdefggfedcba");
        System.out.println(s);

    }

}

package leetCode.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution242 {

    /**
     * 使用map进行计数
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (Objects.equals(s, t)) {
            return true;
        }
        if (s.length() != t.length()){
            return false;
        }
        Map<Character, Integer> mapOne = new HashMap<>();
        Map<Character, Integer> mapTwo = new HashMap<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            char c = s.charAt(i);
            Integer count = mapOne.getOrDefault(c, 0);
            mapOne.put(c,count + 1);
        }

        for (int i = 0; i < t.toCharArray().length; i++) {
            char c = t.charAt(i);
            Integer count = mapTwo.getOrDefault(c, 0);
            mapTwo.put(c,count + 1);
        }
       return mapOne.equals(mapTwo);
    }

    /**
     * 使用快排
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t){
        if (Objects.equals(s, t)) {
            return true;
        }
        if (s.length() != t.length()){
            return false;
        }
        char[] charsOne = s.toCharArray();
        Arrays.sort(charsOne);

        char[] charsTwo = t.toCharArray();
        Arrays.sort(charsTwo);
        for (int i = 0; i < charsOne.length; i++) {
            if (charsOne[i] != charsTwo[i]){
                return false;
            }
        }
        return true;
    }

}
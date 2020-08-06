package leetCode.hashtable;

import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public static boolean isAnagram(String s, String t) {
        if (s.isEmpty() && t.isEmpty()){
            return true;
        }
        if (s.length() != t.length()){
            return false;
        }
        HashMap<Character,Integer> map1 = new HashMap();
        HashMap<Character,Integer> map2 = new HashMap();
        for (char c : s.toCharArray()) {
            if (!map1.containsKey(c)){
                map1.put(c,1);
            }else {
                map1.put(c,map1.get(c)+1);
            }
        }
        for (char c : t.toCharArray()) {
            if (!map2.containsKey(c)){
                map2.put(c,1);
            }else {
                map2.put(c,map2.get(c)+1);
            }
        }
//        System.out.println(map1.toString());
//        System.out.println(map2.toString());
        boolean equals = map1.equals(map2);
        return equals;

    }

    public static void main(String[] args) {
        String s = "caar";
        String t = "ccar";
        System.out.println(isAnagram(s,t));
    }
}
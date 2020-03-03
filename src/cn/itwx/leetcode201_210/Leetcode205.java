package cn.itwx.leetcode201_210;

import java.util.HashMap;
import java.util.Map;

public class Leetcode205 {

    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;

        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char temp1 = s.charAt(i);
            char temp2 = t.charAt(i);
            if (!map.containsKey(temp1)) {
                if (map.containsValue(temp2)) return false;
                map.put(temp1, temp2);
            } else {
                if (!map.get(temp1).equals(temp2)) {
                    return false;
                }
            }
        }
        return true;
    }
}

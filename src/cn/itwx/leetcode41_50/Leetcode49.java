package cn.itwx.leetcode41_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Leetcode49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return null;

        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String temp = String.valueOf(ch);
            if (!map.containsKey(temp)) {//题目中不会出现相同的字符串，应该可以这样理解
                map.put(temp, new ArrayList<>());
            }
            map.get(temp).add(s);
        }

        return new ArrayList<>(map.values());
    }
}

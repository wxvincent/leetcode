package cn.itwx.leetcode21_30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode30 {//还未搞懂

    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> res = new ArrayList<>();
        if (words.length == 0 || s.length() == 0) return res;
        int strLen = s.length();
        int wordLen = words[0].length();
        int wordsLen = words.length;
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        HashMap<String, Integer> temp = new HashMap<>();
        for (int i = 0; i < wordLen; i++) {
            int left = i, count = 0;
            temp.clear();
            for (int j = i; j <= strLen - wordLen; j += wordLen) {
                String sub = s.substring(j, j + wordLen);
                if (map.containsKey(sub)) {
                    temp.put(sub, temp.getOrDefault(sub, 0) + 1);
                    if (temp.get(sub) <= map.get(sub)) {
                        count++;

                    } else {
                        while (temp.get(sub) > map.get(sub)) {
                            String first = s.substring(left, left + wordLen);
                            temp.put(first, temp.get(first) - 1);
                            if (temp.get(first) < map.get(first)) count--;
                            left += wordLen;
                        }
                    }
                    if (count == wordsLen) {
                        res.add(left);
                        String first = s.substring(left, left + wordLen);
                        temp.put(first, temp.get(first) - 1);
                        count--;
                        left += wordLen;

                    }
                } else {
                    temp.clear();
                    count = 0;
                    left = j + wordLen;
                }
            }
        }
        return res;
    }
}

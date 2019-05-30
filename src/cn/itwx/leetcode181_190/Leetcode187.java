package cn.itwx.leetcode181_190;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode187 {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String index = s.substring(i, i + 10);
            if (!set.contains(index)) {
                set.add(index);
            } else {
                if (!res.contains(index)) {
                    res.add(index);
                }
            }
        }
        return res;
    }
}

package cn.itwx.leetcode31_40;

import java.util.ArrayList;
import java.util.List;

public class Leetcode38 {

    public String countAndSay(int n) {
        List<String> list = new ArrayList<>();
        list.add("1");
        for (int i = 1; i < n; i++) {
            String s = list.get(i - 1);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                int len = 1;
                while (j < s.length() - 1 && s.charAt(j) == s.charAt(j + 1)) {
                    j++;
                    len++;
                }
                sb.append(String.valueOf(len) + s.charAt(j));
            }
            list.add(sb.toString());
        }
        return list.get(list.size() - 1);
    }
}

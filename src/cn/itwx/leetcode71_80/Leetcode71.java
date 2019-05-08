package cn.itwx.leetcode71_80;

import java.util.LinkedList;

public class Leetcode71 {

    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return path;

        LinkedList<String> list = new LinkedList<>();
        String[] split = path.split("/");//这一步实在是太精髓
        for (String s : split) {
            if (s.equals(".") || s.equals("")) {
                continue;
            }
            if (s.equals("..")) {
                list.pollLast();
                continue;
            }
            list.add(s);
        }
        StringBuilder sb = new StringBuilder();
        while (!list.isEmpty()) {
            sb.append("/" + list.pollFirst());
        }
        String ans = sb.toString();
        if (ans.length() == 0) return "/";
        return ans;
    }
}

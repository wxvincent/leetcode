package cn.itwx.leetcode1_10;

import java.util.ArrayList;
import java.util.List;

public class Leetcode6 {

    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows == 1) return s;

        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            list.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            list.get(curRow).append(c);
            if (curRow == 0 || curRow == list.size() - 1) goingDown = !goingDown;
            curRow = curRow + (goingDown ? 1 : -1);
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : list) {
            res.append(sb);
        }

        return res.toString();
    }
}

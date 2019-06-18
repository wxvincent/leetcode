package cn.itwx.leetcode91_100;

import java.util.ArrayList;
import java.util.List;

public class Leetcode93 {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int len = s.length();
        if (len < 4 || len > 12) return res;
        find(res, s, 0, 3);//num为小数点的个数
        return res;
    }

    public void find(List<String> res, String s, int index, int num) {
        int len = s.length();
        if (num == 0 && index >= len - 3 && index <= len - 1) {
            if (index == len - 1) {
                res.add(s);
            } else if (s.charAt(index) != '0' && Integer.parseInt(s.substring(index)) <= 255) {
                res.add(s);
            }
            return;
        }

        if (index < len - 1) {
            StringBuilder sb1 = new StringBuilder(s);
            sb1.insert(index + 1, '.');
            find(res, sb1.toString(), index + 2, num - 1);
        }
        if (index < len - 2 && s.charAt(index) != '0') {
            StringBuilder sb2 = new StringBuilder(s);
            sb2.insert(index + 2, '.');
            find(res, sb2.toString(), index + 3, num - 1);
        }
        if (index < len - 3 && Integer.parseInt(s.substring(index, index + 3)) <= 255 && s.charAt(index) != '0') {
            StringBuilder sb3 = new StringBuilder(s);
            sb3.insert(index + 3, '.');
            find(res, sb3.toString(), index + 4, num - 1);
        }
    }
}

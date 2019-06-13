package cn.itwx.leetcode51_60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Leetcode56 {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<Integer> list = new ArrayList<>();
        list.add(intervals[0][0]);
        list.add(intervals[0][1]);
        for (int i = 0; i < intervals.length - 1; i++) {
            if (list.get(list.size() - 1) < intervals[i + 1][1]) {
                if (list.get(list.size() - 1) >= intervals[i + 1][0]) {
                    list.remove(list.size() - 1);
                    list.add(intervals[i + 1][1]);
                } else {
                    list.add(intervals[i + 1][0]);
                    list.add(intervals[i + 1][1]);
                }
            }
        }

        int[][] res = new int[list.size() / 2][2];
        for (int i = 0; i < list.size() / 2; i++) {
            res[i][0] = list.get(2 * i);
            res[i][1] = list.get(2 * i + 1);
        }

        return res;
    }
}

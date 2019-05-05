package cn.itwx.leetcode51_60;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode57 {

    class Interval {
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int start;
        public int end;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Interval> intervalList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            intervalList.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        List<Interval> resList = insert(intervalList, new Interval(newInterval[0], newInterval[1]));
        int[][] res = new int[resList.size()][2];
        for (int i = 0; i < resList.size(); i++) {
            res[i][0] = resList.get(i).start;
            res[i][1] = resList.get(i).end;
        }
        return res;
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new LinkedList<>();
        int n = intervals.size(), cur = 0;
        for (int i = 0; i < n; ++i) {
            Interval each = intervals.get(i);
            if (each.end < newInterval.start) {//[[1,3],[8,10]]  [4,6]
                res.add(each);
                ++cur;
            } else if (each.start > newInterval.end) {//[[1,3],[8,10]]  [4,6]
                res.add(each);
            } else {//[[1,3],[8,10]]  [2,9]
                newInterval.start = Math.min(newInterval.start, each.start);
                newInterval.end = Math.max(newInterval.end, each.end);
            }
        }
        res.add(cur, newInterval);
        return res;
    }
}

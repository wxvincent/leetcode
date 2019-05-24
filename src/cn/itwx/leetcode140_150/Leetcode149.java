package cn.itwx.leetcode140_150;

public class Leetcode149 {

    public int maxPoints(int[][] points) {
        if (points.length == 0) return 0;
        if (points.length == 1) return 1;
        if (points.length == 2) return 2;
        int ans = 2;
        int Max = -1;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                ans = 2;
                for (int k = 0; k < points.length; k++) {
                    if (k == i || k == j) continue;
                    int x1 = points[i][0];
                    int y1 = points[i][1];
                    int x2 = points[j][0];
                    int y2 = points[j][1];
                    int x3 = points[k][0];
                    int y3 = points[k][1];

                    if (x1 == x2) {
                        if (y1 == y2) {
                            //此处在考虑重复点，如果两个点一样的话，除非第三个点也一样，否则不相加
                            //如果相加的话，会造成多条线的情况。
                            //不相加也不会出现问题，后面的循环还是会把漏掉的加上去
                            if (x2 == x3 && y2 == y3) ans++;
                        } else {
                            if (x2 == x3) ans++;
                        }
                    } else {
                        long tanK1 = ((long) x3 - x1) * ((long) y2 - y1);//把相除换成了相乘，其实一样
                        long tanK2 = ((long) y3 - y1) * ((long) x2 - x1);
                        if (tanK1 == tanK2) ans++;
                    }
                }

                if (Max < ans) Max = ans;
            }
        }
        return Max;
    }
}

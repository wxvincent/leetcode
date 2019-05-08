package cn.itwx.leetcode61_70;

public class Leetcode69 {

    public int mySqrt(int x) {
        if (x < 2) return x;

        int low = 1;
        int high = x;
        int mid = (low + high) / 2;

        while (low <= high) {
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }
        return high;
    }
}

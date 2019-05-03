package cn.itwx.leetcode1_10;

public class Leetcode9 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }

        int ans = 0;
        int temp = x;

        while (x > 0) {
            ans = ans * 10 + x % 10;
            x = x / 10;
        }

        return ans == temp;
    }

}

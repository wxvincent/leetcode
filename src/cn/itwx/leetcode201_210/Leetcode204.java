package cn.itwx.leetcode201_210;

public class Leetcode204 {

    public int countPrimes(int n) {
        boolean[] b = new boolean[n];
        int count = 0;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            //这一步是为了简化，后面的数字中如果有变为true的，前面的数字一定能遍历到它，因此直接跳过
            if (b[i]) continue;
            for (int j = i + i; j < n; j += i) b[j] = true;
        }
        for (boolean c : b) {
            count += !c ? 1 : 0;
        }
        //这里减去的两个是0和1
        return n > 2 ? count - 2 : 0;
    }
}

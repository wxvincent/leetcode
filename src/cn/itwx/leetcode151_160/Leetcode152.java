package cn.itwx.leetcode151_160;

public class Leetcode152 {

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1; //一个保存最大的，一个保存最小的。
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                //如果数组的数是负数，那么会导致最大的变最小的，最小的变最大的。因此交换两个的值。
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            //本质上依旧是动态规划，只是需要有两个数来保存最大和最小值
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }
}

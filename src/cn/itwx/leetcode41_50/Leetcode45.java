package cn.itwx.leetcode41_50;

public class Leetcode45 {

    public int jump(int[] nums) {
        if (nums.length < 2) return 0;
        int times = 0;   //统计次数
        int max_loc = 0;  //能跳到的最大的索引位置
        int next_begin = 0;  //下一次开始跳的索引位置
        for (int i = 0; i < nums.length; i++) {
            max_loc = Math.max(max_loc, i + nums[i]); //当点能跳到的最大的距离
            //超过或者等于的时候 并没有给times＋
            if (max_loc >= nums.length - 1) return times + 1;
            //当i指针指向了下一次跳的位置的时候
            //这里要把当前次数下能跳到的地方都走完，计算出下一次能到的最大值
            if (i == next_begin) {
                times++;
                next_begin = max_loc;
            }
        }
        return times;
    }
}

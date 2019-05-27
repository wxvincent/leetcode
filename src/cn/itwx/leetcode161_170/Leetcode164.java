package cn.itwx.leetcode161_170;

public class Leetcode164 {//还未仔细看

    public int maximumGap(int[] nums) {
        return sort_bucket(nums, nums.length + 1);
    }

    // 桶排序
    private int sort_bucket(int[] nums, int len) {
        // 计算数组中的最小值和最大值
        int minimum = Integer.MAX_VALUE, maximum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minimum)
                minimum = nums[i];
            if (nums[i] > maximum)
                maximum = nums[i];
        }
        if (minimum == maximum)
            return 0;
        // 创建桶 至少存在一个空桶，可确保 最大间距的元素 不在同一个桶中
        int[] mins = new int[len], maxs = new int[len];
        boolean[] hasNumber = new boolean[len];
        // 数据映射到桶中
        int index;
        for (int i = 0; i < nums.length; i++) {
            index = this.mapToBucket(minimum, maximum, nums[i], nums.length);
            mins[index] = hasNumber[index] ? Math.min(mins[index], nums[i]) : nums[i];
            maxs[index] = hasNumber[index] ? Math.max(maxs[index], nums[i]) : nums[i];
            hasNumber[index] = true;
        }
        int maxLen = 0; // 最终结果
        int m = maxs[0], n;
        // 桶的数量 为原数组的长度 + 1，这样可以确保存在一个空桶，有效确保 最大间距的相邻元素 在不同的桶中
        for (int i = 1; i <= nums.length; i++) {
            if (hasNumber[i]) {
                n = mins[i] - m;
                if (maxLen < n)
                    maxLen = n;
                m = maxs[i];
            }
        }
        return maxLen;
    }

    /**
     * 映射到桶中
     *
     * @param min 数组中的最小值
     * @param max 数组中的最大值
     * @param num 当前值
     * @param len 原数组的长度
     * @return 可以确保 至少存在一个空桶，可以确保 minimum 在第一个桶中，确保 maximum 在最后一个桶中
     */
    private int mapToBucket(long min, long max, long num, int len) {
        return (int) ((num - min) * len / (max - min));
        // return (int)Math.floor((num - min) * len / (max - min)); 调用函数慢个几毫秒
    }
}

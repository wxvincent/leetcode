package cn.itwx.leetcode41_50;

public class Leetcode42 {

    public int trap(int[] height) {
        int water = 0;
        int leftPtr = 0, rightPtr = height.length - 1;
        if (rightPtr < 2) return 0;

        int lower = Math.min(height[leftPtr], height[rightPtr]);
        while (leftPtr < rightPtr - 1) {
            if (height[leftPtr] < height[rightPtr]) {
                if (lower > height[++leftPtr]) {
                    water += lower - height[leftPtr];
                } else {
                    lower = Math.min(height[leftPtr], height[rightPtr]);
                }
            } else {
                if (lower > height[--rightPtr]) {
                    water += lower - height[rightPtr];
                } else {
                    lower = Math.min(height[leftPtr], height[rightPtr]);
                }
            }
        }
        return water;
    }
}

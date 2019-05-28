package cn.itwx.leetcode161_170;

public class Leetcode167 {

    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 2) return null;

        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int temp = numbers[left] + numbers[right];
            if (temp == target) {
                return new int[]{left + 1, right + 1};
            } else if (temp < target) {
                left++;
            } else {
                right--;
            }
        }

        return null;
    }
}

package cn.itwx.leetcode51_60;

import java.util.ArrayList;
import java.util.List;

public class Leetcode52 {

    public int totalNQueens(int n) {
        List<String> list = new ArrayList<>();
        int[] arr = new int[n];
        putQueen(list, 0, n, arr);
        return list.size();
    }

    // 尝试放置：递归+回溯
    public void putQueen(List<String> list, int row, int n, int[] arr) {
        if (row == n) {
            list.add("1");//和51题的区别就在这里，其他都一样
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[row] = i;
            if (check(arr, row)) {
                putQueen(list, row + 1, n, arr);
            }
        }
    }

    // 检测放置的皇后是否有问题
    public boolean check(int[] arr, int row) {
        for (int i = 0; i < row; i++) {
            if (arr[i] == arr[row] || Math.abs(row - i) == Math.abs(arr[row] - arr[i]))
                return false;
        }
        return true;
    }
}

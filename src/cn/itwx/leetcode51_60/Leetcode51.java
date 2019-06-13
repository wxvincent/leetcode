package cn.itwx.leetcode51_60;

import java.util.ArrayList;
import java.util.List;

public class Leetcode51 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        //arr数组用来存放每个皇后的位置
        int[] arr = new int[n];
        putQueen(list, 0, n, arr);
        return list;
    }

    // 尝试放置：递归+回溯
    public void putQueen(List<List<String>> list, int row, int n, int[] arr) {
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (arr[i] == j) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                temp.add(sb.toString());
            }
            list.add(temp);
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[row] = i;//这个值在不断的变化，相当于是进行了回溯
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

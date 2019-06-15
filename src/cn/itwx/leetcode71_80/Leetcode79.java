package cn.itwx.leetcode71_80;

public class Leetcode79 {

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null || word.length() == 0) return false;

        int[][] flag = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (isExist(board, flag, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isExist(char[][] board, int[][] flag, String word, int i, int j, int index) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length ||
                board[i][j] != word.charAt(index) || flag[i][j] == 1)
            return false;

        if (index == word.length() - 1) return true;

        flag[i][j] = 1;
        if (isExist(board, flag, word, i + 1, j, index + 1) ||
                isExist(board, flag, word, i - 1, j, index + 1) ||
                isExist(board, flag, word, i, j + 1, index + 1) ||
                isExist(board, flag, word, i, j - 1, index + 1)) {
            return true;
        }
        flag[i][j] = 0;

        return false;
    }
}

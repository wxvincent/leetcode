package cn.itwx.leetcode31_40;

public class Leetcode37 {

    public void solveSudoku(char[][] board) {
        check(board);
    }

    private boolean check(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        board[i][j] = k;
                        if (isValid(board, i, j) && check(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col) {
        if (board[row][col] == '.') return true;
        for (int i = 0; i < board.length; i++) {
            if (i != row && board[i][col] == board[row][col]) {
                return false;
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            if (i != col && board[row][i] == board[row][col]) {
                return false;
            }
        }

        int rowOfB = row / 3;
        int colOfB = col / 3;
        for (int i = rowOfB * 3; i < rowOfB * 3 + 3; i++) {
            for (int j = colOfB * 3; j < colOfB * 3 + 3; j++) {
                if (i != row && j != col && board[i][j] == board[row][col]) {
                    return false;
                }
            }
        }

        return true;
    }
}

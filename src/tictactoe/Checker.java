package tictactoe;

public class Checker {

    public static int checkWinner(char[][] board) {
        //  2: X win
        // -2: O win
        //  0: Tie
        //  1: No one win

        // check rows
        for (char[] chars : board) {
            if (equality(chars[0], chars[1], chars[2])) {
                return chars[0] == 'X' ? 2 : -2;
            }
        }
        // check columns
        for (int j = 0; j < board.length; ++j) {
            if (equality(board[0][j], board[1][j], board[2][j])) {
                return board[0][j] == 'X' ? 2 : -2;
            }
        }
        // check diagonal
        if (equality(board[0][0], board[1][1], board[2][2])
                || equality(board[0][2], board[1][1], board[2][0])) {
            return board[1][1] == 'X' ? 2 : -2;
        }

        // Tie
        for (char[] row : board) {
            for (char x : row) {
                if (x == ' ') {
                    return 1;
                }
            }
        }

        return 0;
    }

    private static boolean equality(char a, char b, char c) {
        return a == b && b == c && a != ' ';
    }
}

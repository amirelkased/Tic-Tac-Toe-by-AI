package levels;

import static levels.Easy_level.*;
import static tictactoe.CommonMethod.checkAIBoard;
import static tictactoe.TicTacToe.board;

public class Medium_level {
    public static void AutoSetXMediumUser() {
        int cnt = 50;
        while (cnt > 0) {
            AutoSetXOEasyUser(board, 'O');
            if (checkAIBoard() == 'O' || count('O') <= 1) {
                board[x][y] = 'X';
                break;
            }
            board[x][y] = 'X';
            if (checkAIBoard() == 'X') {
                break;
            }
            board[x][y] = ' ';
            --cnt;
        }
        if (cnt == 0) AutoSetXOEasyUser(board, 'X');
    }


    public static void AutoSetOMediumUser() {
        int cnt = 50;
        while (cnt > 0) {
            AutoSetXOEasyUser(board, 'X');
            if (checkAIBoard() == 'X' || count('X') <= 1) {
                board[x][y] = 'O';
                break;
            }
            board[x][y] = 'O';
            if (checkAIBoard() == 'O') {
                break;
            }
            board[x][y] = ' ';
            --cnt;
        }
        if (cnt == 0) AutoSetXOEasyUser(board, 'O');
    }

    private static int count(char some) {
        int cnt = 0;
        for (char[] row : board) {
            for (char it : row) {
                if (it == some) {
                    ++cnt;
                }
            }
        }
        return cnt;
    }
}

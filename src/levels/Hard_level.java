package levels;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static tictactoe.Checker.checkWinner;

public class Hard_level {
    private static char maximizeChar = ' ';

    public static int minimax(char[][] board, int depth, boolean isMaximize, boolean firstVisit) {
        int check_board = checkWinner(board);
        if (check_board != 1 || depth == 0) {
            return check_board;
        }
        if (isMaximize) {
            int finalScore = Integer.MIN_VALUE;
            int finalI = 0;
            int finalJ = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = 'X';  // Do
                        int currentState = minimax(board, depth - 1, false, false); // Recursive
                        board[i][j] = ' ';  // Undo
                        if (finalScore < currentState) {
                            finalScore = currentState;
                            finalI = i;
                            finalJ = j;
                        }
                    }
                }
            }
            if (firstVisit) {
                board[finalI][finalJ] = maximizeChar;
            }
            return finalScore;
        } else {
            int finalScore = Integer.MAX_VALUE;
            int finalI = 0;
            int finalJ = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = 'O'; // Do
                        int currentState = minimax(board, depth - 1, true, false); // Recursive
                        board[i][j] = ' '; // Undo
                        if (finalScore > currentState) {
                            finalScore = currentState;
                            finalI = i;
                            finalJ = j;
                        }
                    }
                }
            }
            if (firstVisit) {
                board[finalI][finalJ] = maximizeChar;
            }
            return finalScore;
        }
    }

    public static void setMaximizeChar(char maximizeChar) {
        Hard_level.maximizeChar = maximizeChar;
    }
}
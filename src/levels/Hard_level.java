package levels;

import static tictactoe.Checker.checkWinner;

public class Hard_level {
    private static char maximizeChar = ' ';

    public static int minimax(char[][] board, int depth, boolean isMaximize, boolean firstVisit) {
        int check_board = checkWinner(board);
        // While Game not over if statement it is working
        if (check_board != 1 || depth == 0) {
            return check_board;
        }
        int finalScore;
        int finalI = 0;
        int finalJ = 0;
        if (isMaximize) {
            finalScore = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        // Do
                        board[i][j] = 'X';
                        // Recursive
                        int currentState = minimax(board, depth - 1, false, false);
                        // Undo
                        board[i][j] = ' ';
                        if (finalScore < currentState) {
                            finalScore = currentState;
                            finalI = i;
                            finalJ = j;
                        }
                    }
                }
            }
        } else {
            finalScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        // Do
                        board[i][j] = 'O';
                        // Recursive
                        int currentState = minimax(board, depth - 1, true, false);
                        // Undo
                        board[i][j] = ' ';
                        if (finalScore > currentState) {
                            finalScore = currentState;
                            finalI = i;
                            finalJ = j;
                        }
                    }
                }
            }
        }
        if (firstVisit) {
            board[finalI][finalJ] = maximizeChar;
        }
        return finalScore;
    }

    public static void setMaximizeChar(char maximizeChar) {
        Hard_level.maximizeChar = maximizeChar;
    }
}
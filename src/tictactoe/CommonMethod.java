package tictactoe;


public class CommonMethod extends TicTacToe {

    public static boolean checkOccupied(int x, int y) {
        return board[x][y] != ' ';
    }

    public static void displayBoard() {
        System.out.println("---------");
        for (char[] chars : board) {
            System.out.print("|");
            for (int j = 0; j < board.length; j++) {
                System.out.printf(" %c", chars[j]);
            }
            System.out.println(" |");
        }
        System.out.println("---------");
    }

    public static boolean checkBoard() {
        //  2: X win
        // -2: O win
        //  0: Tie
        //  1: No one win
        int checked_value = Checker.checkWinner(board);
        switch (checked_value) {
            case 2 -> System.out.println("X wins");
            case -2 -> System.out.println("O wins");
            case 0 -> System.out.println("Draw");
        }
        return checked_value != 1;
    }

    public static char checkAIBoard() {
        int checked_value = Checker.checkWinner(board);
        switch (checked_value) {
            case 2 -> {
                return 'X';
            }
            case -2 -> {
                return 'O';
            }
            case 0 -> {
                return 'D';
            }
        }
        return 'N';
    }

    public static int countSpace() {
        int cnt = 0;
        for (char[] row : board) {
            for (char it : row) {
                if (it == ' ') {
                    ++cnt;
                }
            }
        }
        return cnt;
    }
}
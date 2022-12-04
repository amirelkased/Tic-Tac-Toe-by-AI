package levels;

public class User_level {

    public static void setXUser(char[][] board, int x, int y) {
        board[x - 1][y - 1] = 'X';
    }

    public static void setOUser(char[][] board, int x, int y) {
        board[x - 1][y - 1] = 'O';
    }
}

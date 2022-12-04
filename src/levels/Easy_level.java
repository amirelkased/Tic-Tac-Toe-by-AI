package levels;

import java.util.Random;

import static tictactoe.CommonMethod.checkOccupied;

public class Easy_level {
    protected static int x;
    protected static int y;

    public static void AutoSetXOEasyUser(char[][] board, char user) {
        do {
            x = easyLevel();
            y = easyLevel();
        } while (checkOccupied(x, y));
        board[x][y] = user;
    }

    public static int easyLevel() {
        return new Random().nextInt(3);
    }
}

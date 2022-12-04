package tictactoe;

import static tictactoe.CommonMethod.*;

import levels.Easy_level;
import levels.Hard_level;
import levels.Medium_level;

import static tictactoe.Main.*;

public interface Modes {
    void operation(String level);

    default void selectLevel(String level, char piece) {
        switch (level) {
            case "easy" -> Easy_level.AutoSetXOEasyUser(board, piece);
            case "medium" -> {
                switch (piece) {
                    case 'X' -> Medium_level.AutoSetXMediumUser();
                    case 'O' -> Medium_level.AutoSetOMediumUser();
                }
            }
            case "hard" -> {
                switch (piece) {
                    case 'X' -> {
                        Hard_level.setMaximizeChar('X');
                        Hard_level.minimax(board, 100, true, true);
                    }
                    case 'O' -> {
                        Hard_level.setMaximizeChar('O');
                        Hard_level.minimax(board, 100, false, true);
                    }
                }
            }
        }
    }
}

class AIxAI implements Modes {
    @Override
    public void operation(String level) {
        displayBoard();
        while (true) {
            System.out.printf("Making move level \"%s\"\n", level);
            selectLevel(level, 'X');
            displayBoard();
            if (checkBoard()) break;
            System.out.printf("Making move level \"%s\"\n", level);
            selectLevel(level, 'O');
            displayBoard();
            if (checkBoard()) break;
        }
    }
}

class UserAI implements Modes {

    @Override
    public void operation(String level) {

        displayBoard();
        while (true) {
            takeInput('X');
            displayBoard();
            if (checkBoard()) break;
            System.out.printf("Making move level \"%s\"\n", level);
            selectLevel(level, 'O');
            displayBoard();
            if (checkBoard()) break;
        }
    }
}

class AIUser implements Modes {

    @Override
    public void operation(String level) {
//        displayBoard();
        while (true) {
            System.out.printf("Making move level \"%s\"\n", level);
            selectLevel(level, 'X');
            displayBoard();
            if (checkBoard()) break;
            takeInput('O');
            displayBoard();
            if (checkBoard()) break;
        }
    }
}

class UserUser implements Modes {
    @Override
    public void operation(String level) {
        displayBoard();
        while (true) {
            takeInput('X');
            displayBoard();
            if (checkBoard()) break;
            takeInput('O');
            displayBoard();
            if (checkBoard()) break;
        }
    }
}

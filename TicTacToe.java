import java.io.*;
import java.util.Random;

public class TicTacToe {
    // grid array
    private char[][] board;

    public TicTacToe () {
        // constructor
        System.out.println("***********************************************************");
        System.out.println("  _______         ______              ______         ");
        System.out.println(" /_  __(_)____   /_  __/___ ______   /_  __/___  ___ ");
        System.out.println("  / / / / ___/    / / / __ `/ ___/    / / / __ \\/ _ \\");
        System.out.println(" / / / / /__     / / / /_/ / /__     / / / /_/ /  __/");
        System.out.println("/_/ /_/\\___/    /_/  \\__,_/\\___/    /_/  \\____/\\___/ ");
        System.out.println("***********************************************************");
        // set initial board to empty
        board = new char[3][3];
        // initialize board
        initializeBoard();
    }

    // set/reset board to empty
    public void initializeBoard () {
        for (int i=0; i < board.length; i++) {
            for (int j=0; j < board.length; j++) {
                board[i][j] = '-';
            }
        }
    }

    // draw board method
    public void drawBoard () {
        System.out.println("-------------");
        for (int i=0; i < board.length; i++) {
            //System.out.println("col " + i);
            
            System.out.println(board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            System.out.println("___________");
            /* for (int j=0; j < board.length; j++) {
                System.out.println(board[i][j] + " | ");
            }
            */
        }
        System.out.println("-------------");
    }

    // check if board is full (tie)
    public boolean isBoardFull () {
        for (int i=0; i < board.length; i++) {
            for (int j=0; j < board.length; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        System.out.println("Looks like we have a draaaaaw.");
        return true;
    }

    // check for winner
    public boolean checkWinner () {
        if (colsWin() || rowsWin() || diagWin()) {
            System.out.println("Looks like we have a winner!!");
            return true;
        }
        return false;
    }

    // check cols
    private boolean colsWin () {
        for (int i=0; i<board.length; i++) {
            if(board[0][i] != '-' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                System.out.println("The vert winner is: " + board[0][i]);
                return true;
            }
        }
        return false;
    }

    // check rows
    private boolean rowsWin () {
        for (int i=0; i<board.length; i++) {
            if(board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                System.out.println("The horiz winner is: " + board[i][0]);
                return true;
            }
        }
        return false;
    }

    // check diags
    private boolean diagWin () {
        if (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            System.out.println("The diag winner is: " + board[0][0]);return true;
        }
        else if (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            System.out.println("The diag winner is: " + board[0][2]);return true;
        }
        else {
            return false;
        }
    }

    // user response
    public void userResponse () {
        boolean INvalidLoc = true;
        
        while (INvalidLoc) {
            System.out.println("What row?");
            String rowStr = System.console().readLine();
            int rowInt = Integer.parseInt(rowStr);
            
            System.out.println("What column?");
            String colStr = System.console().readLine();
            int colInt = Integer.parseInt(colStr);

            if (board[rowInt][colInt] == '-') {
                board[rowInt][colInt] = 'x';
                INvalidLoc = false;
            }
        }
    }

    // computer generated response (random to start)
    public void compResponse () {
        boolean INvalidLoc = true;

        while (INvalidLoc) {
            Random rand1 = new Random();
            Random rand2 = new Random();
            int intRandRow = rand1.nextInt(3);
            int intRandCol = rand2.nextInt(3);

            if (board[intRandRow][intRandCol] == '-') {
                board[intRandRow][intRandCol] = 'o';
                INvalidLoc = false;
            }
            if (isBoardFull()) {
                break;
            }
        }
    }
}
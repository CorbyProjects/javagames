import java.io.*;
import java.util.Random;

public class Games {
    // game state vars
    static int HowManyRounds;

    public static void main (String args[]) {        
        System.out.println("How many rounds would you like to play?");
        String response = System.console().readLine();
        HowManyRounds = Integer.parseInt(response);
       
        while (HowManyRounds > 0) {
            // figure out what game they want to play for this round
            System.out.println("Would you like to play a game?\nChoose one:\n1) Guess A Number\n2) Tic Tac Toe\n3) Mazes and Monsters");
            String game = System.console().readLine();
            // confirm game choice
            game = game.toLowerCase();
            System.out.println("You chose: " + game);
            // start up the game they chose
            if (game.equals("1") || game.equals("guess a number")) {
               GuessANumber currentGame = new GuessANumber();
               int user = currentGame.GetUserNumber();
               int comp = currentGame.GetCompNumber();
               currentGame.TestNums(user, comp);
            } 
            else if (game.equals("2") || game.equals("tic tac toe")) {
                TicTacToe currentGame = new TicTacToe();
                // draw board
                // game play loop
                boolean keepPlaying = true;
                while (keepPlaying) {
                    // get user response
                    currentGame.userResponse();
                    // get computer response
                    currentGame.compResponse();
                    // draw board
                    currentGame.drawBoard();
                    // check winners
                    // if winner or tie, set keepPlaying to false
                    if (currentGame.checkWinner() || currentGame.isBoardFull()) {
                        keepPlaying = false;
                    }
                }
            }
            else if (game.equals("3") || game.equals("mazes and monsters")) {
                MnM currentGame = new MnM();
            }
			else if (game.equals("4") || game.equals("2d tic tac toe")) {
                2DTicTacToe currentGame = new 2DTicTacToe();
				boolean keepPlaying = true;
                while (keepPlaying) {
                    // get user response
                    currentGame.userResponse();
                    // get computer response
                    currentGame.compResponse();
                    // draw board
                    currentGame.drawBoard();
                    // check winners
                    // if winner or tie, set keepPlaying to false
                    if (currentGame.checkWinner() || currentGame.isBoardFull()) {
                        keepPlaying = false;
                    }
                }
            }
            else { // otherwise let them know it doesn't exist yet
                System.out.println("Sorry we don't have that game right now");
            }
            HowManyRounds -=1;
        }
        System.out.println("***********************************************************\n   ______                        ____                 \n  / ____/___ _____ ___  ___     / __ \\_   _____  _____\n / / __/ __ `/ __ `__ \\/ _ \\   / / / / | / / _ \\/ ___/\n/ /_/ / /_/ / / / / / /  __/  / /_/ /| |/ /  __/ /    \n\\____/\\__,_/_/ /_/ /_/\\___/   \\____/ |___/\\___/_/     \n***********************************************************");
    }
}
import java.io.*;
import java.util.Random;

public class GuessANumber {
    // constructor
    public GuessANumber () {
        
        System.out.println("************************************************************************************");
        System.out.println("   ______                        ___       _   __                __             ");
        System.out.println("  / ____/_  _____  __________   /   |     / | / /_  ______ ___  / /_  ___  _____");
        System.out.println(" / / __/ / / / _ \\/ ___/ ___/  / /| |    /  |/ / / / / __ `__ \\/ __ \\/ _ \\/ ___/");
        System.out.println("/ /_/ / /_/ /  __(__  |__  )  / ___ |   / /|  / /_/ / / / / / / /_/ /  __/ /    ");
        System.out.println("\\____/\\__,_/\\___/____/____/  /_/  |_|  /_/ |_/\\__,_/_/ /_/ /_/_.___/\\___/_/     ");
        System.out.println("*************************************************************************************");
    }

    public int GetUserNumber () {
        // get user's number
        boolean INvalidNum = true;
        int userNumber = -1;
        while (INvalidNum) {
            System.out.println("Guess a number between 0 and 100:");
            String userGuess = System.console().readLine();
            userNumber = Integer.parseInt(userGuess);
            if (userNumber > 0 && userNumber <= 100) {
                INvalidNum = false;
            }
        }
        return userNumber;
    }

    public int GetCompNumber () {
        // generate random number
        Random rand = new Random();
        int compNumber = rand.nextInt(101);
        return compNumber;
    }

    public void TestNums (int user, int computer) {
        int userNumber = user;
        int compNumber = computer;
        String message;

        // compare & give message
      if (userNumber > compNumber) {
            message = "User wins! " + userNumber + " vs " + compNumber;
        }
        else if (userNumber < compNumber) {
            message = "Computer wins! " + userNumber + " vs " + compNumber;
        }
        else {
            message = "It's a tie! " + userNumber + " vs " + compNumber;
        }
        
        System.out.println(message);
    }
}
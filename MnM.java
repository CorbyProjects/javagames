import java.io.*;
import java.util.Random;

public class MnM {
    int baseLevel;
    PlayerChar player;
    Monster monster;
    boolean roomKey;

    
    public MnM () {
        System.out.println("******************************************************************************************\n    __  ___                         ___        __  ___                 __                \n   /  |/  /___ _____  ___  _____   ( _ )      /  |/  /___  ____  _____/ /____  __________\n  / /|_/ / __ `/_  / / _ \\/ ___/  / __ \\/|   / /|_/ / __ \\/ __ \\/ ___/ __/ _ \\/ ___/ ___/\n / /  / / /_/ / / /_/  __(__  )  / /_/  <   / /  / / /_/ / / / (__  ) /_/  __/ /  (__  ) \n/_/  /_/\\__,_/ /___/\\___/____/   \\____/\\/  /_/  /_/\\____/_/ /_/____/\\__/\\___/_/  /____/  \n******************************************************************************************");
        // figure out base level for game()
        setBaseLevel();
        // initialize player character()
        player = new PlayerChar(baseLevel);
        // initialize 1st room()
        initializeRoom();
    }

    // figure out base level for game()
    public void setBaseLevel () {
        boolean INvalidBase = true;

        while (INvalidBase) {
            System.out.println("At what level would you start?\nA higher level should mean a longer game.");
            
            String baseLevelStr = System.console().readLine();
            // make sure it's a number
            try {
                baseLevel = Integer.parseInt(baseLevelStr);
            } catch (NumberFormatException e) {
                System.out.println("Please choose a number character less than or equal to 100");
            }
            // make sure the number is between 1 & 100
            if (baseLevel >=1 && baseLevel <= 100) {
                INvalidBase = false;
            }
        }
    }
    
    // initialize room
    public void initializeRoom () {
        // generate monster()
        monster = new Monster(baseLevel);

        // does this room drop a key?
        // might need to adjust odds later
        // maybe ask player what odds/difficulty level?
        Random rand1 = new Random();

        if (rand1.nextInt(101) < 33 ) {
            roomKey = true;
        }
        else {
            roomKey = false;
        }
    }
        
    
    // get/process user decision
        // options based on stats

    // evaluate consequences
        // results based on stats comparisons & random modifiers

    // end of turn
        // check if alive
        // if still fighting monster 
        // else get key
        // end of game() or go to next room()

    // next room
        // ask what room next
        // initialize room()

    // end of game
        // if end of turn() && has 3 keys
        // big boss? win?

} // close class
import java.io.*;
import java.util.Random;

public class MnM {
    int baseLevel;
    PlayerChar player;
    Monster monster;
    boolean roomKey;
	boolean playerAlive;
	boolean monsterAlive;

    public MnM () {
        System.out.println("******************************************************************************************\n    __  ___                         ___        __  ___                 __                \n   /  |/  /___ _____  ___  _____   ( _ )      /  |/  /___  ____  _____/ /____  __________\n  / /|_/ / __ `/_  / / _ \\/ ___/  / __ \\/|   / /|_/ / __ \\/ __ \\/ ___/ __/ _ \\/ ___/ ___/\n / /  / / /_/ / / /_/  __(__  )  / /_/  <   / /  / / /_/ / / / (__  ) /_/  __/ /  (__  ) \n/_/  /_/\\__,_/ /___/\\___/____/   \\____/\\/  /_/  /_/\\____/_/ /_/____/\\__/\\___/_/  /____/  \n******************************************************************************************");
		// you start off alive 
		playerAlive = true;
        // figure out base level for game()
        setBaseLevel();
        // initialize player character()
        player = new PlayerChar(baseLevel);
		
		// as long as you're alive, keep taking turns
		mainTurnLoop();
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
		monsterAlive = true;
        // does this room drop a key?
        // might need to adjust odds later
        // maybe ask player what odds/difficulty level?
        Random rand1 = new Random();

        if (rand1.nextInt(101) < 25 ) {
            roomKey = true;
        }
        else {
            roomKey = false;
        }
		System.out.println("Room key: " + roomKey);
    }
	
    public void mainTurnLoop () {
		while (playerAlive) {
			// initialize room
			initializeRoom();
		
			// inner turn loop
			innerTurnLoop();
		
			// check if alive
			// else get key
			if (roomKey) {
				player.keys++;
			}
			// end of game() or go to next room()
			if (player.keys >= 3) {
				endGame(true); 
			}
		}
		// end game here, but use if for win/lose??
	}        
    
	public void innerTurnLoop () {
		// while player && monster alive 
		while (playerAlive && monsterAlive) {
			// if player not alive
			if (player.hitPoints < 0) {
				playerAlive = false;
			}
			else {
				// get player action
			
				// evaluate player action 
			}
			
			// if monster not alive
			if (monster.hitPoints < 0) {
				monsterAlive = false;
			}
			else {
				// evaluate & display monster action
			}
		}	
	}
    
    // end of game
	public void endGame (Boolean winArg) {
        if (winArg) {
			// big boss? win message?
			System.out.println("You are victorious!!");
		}
		else {
			System.out.println("Sad trombone sound. You lose.");
		}
	}
} // close class
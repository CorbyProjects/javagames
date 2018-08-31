import java.io.*;
import java.util.Random;

public class MnM {
    int baseLevel;
    PlayerChar player;
    Monster monster;
    boolean roomKey;
	boolean playerAlive;
	//boolean monsterAlive;

    public MnM () {
        System.out.println("******************************************************************************************\n    __  ___                         ___        __  ___                 __                \n   /  |/  /___ _____  ___  _____   ( _ )      /  |/  /___  ____  _____/ /____  __________\n  / /|_/ / __ `/_  / / _ \\/ ___/  / __ \\/|   / /|_/ / __ \\/ __ \\/ ___/ __/ _ \\/ ___/ ___/\n / /  / / /_/ / / /_/  __(__  )  / /_/  <   / /  / / /_/ / / / (__  ) /_/  __/ /  (__  ) \n/_/  /_/\\__,_/ /___/\\___/____/   \\____/\\/  /_/  /_/\\____/_/ /_/____/\\__/\\___/_/  /____/  \n******************************************************************************************");
		
		System.out.println("******************************************************************************************\n    ____           __                  __  _                 \n   /  _/___  _____/ /________  _______/ /_(_)___  ____  _____\n   / // __ \\/ ___/ __/ ___/ / / / ___/ __/ / __ \\/ __ \\/ ___/\n _/ // / / (__  ) /_/ /  / /_/ / /__/ /_/ / /_/ / / / (__  ) \n/___/_/ /_/____/\\__/_/   \\__,_/\\___/\\__/_/\\____/_/ /_/____/  \n******************************************************************************************\n1. You choose a level, which is used to set your & monster stats, and key drop rate.\n2. Collect 3 keys to win & survive the maze.\n3. Defeat the monsters or die!\n4. When fighting:\n   a. Whoever has the highest number for the matching stats wins that round.\n   b. So if you have an Int that is higher than the monster's Int, you would want to fight using that stat.\n   c. Con (constitution) mitigates damage for you and the monster, but only a little bit.\n5. After you defeat a monster, you'll be notified if you found a key, and your health is always restored back to its original value.6. Best of luck, adventurer!");
		
		// you start off alive 
		playerAlive = true;
        // figure out base level for game()
        setBaseLevel();
        // initialize player character()
        player = new PlayerChar(baseLevel);
		
		// as long as you're alive, keep taking turns
		mainTurnLoop();
		
		if (playerAlive) {
			// big boss? win message?
			System.out.println("***********************************************************\n   ______                             __        __      __  _                 \n  / ____/___  ____  ____ __________ _/ /___  __/ /___ _/ /_(_)___  ____  _____\n / /   / __ \\/ __ \\/ __ `/ ___/ __ `/ __/ / / / / __ `/ __/ / __ \\/ __ \\/ ___/\n/ /___/ /_/ / / / / /_/ / /  / /_/ / /_/ /_/ / / /_/ / /_/ / /_/ / / / (__  ) \n\\____/\\____/_/ /_/\\__, /_/   \\__,_/\\__/\\__,_/_/\\__,_/\\__/_/\\____/_/ /_/____/  \n  ____  ____     //__//____  __  _______                                      \n / __ \\/ __ \\   / / / / __ \\/ / / / ___/                                      \n/ /_/ / / / /  / /_/ / /_/ / /_/ / /                                          \n\\____/_/ /_/   \\__, /\\____/\\__,_/_/                                           \n _    ___     /____/                __                                        \n| |  / (_)____/ /_____  _______  __/ /                                        \n| | / / / ___/ __/ __ \\/ ___/ / / / /                                         \n| |/ / / /__/ /_/ /_/ / /  / /_/ /_/                                          \n|___/_/\\___/\\__/\\____/_/   \\__, (_)                                           \n                          /____/\n***********************************************************\n");
		}
		else {
			System.out.println("***********************************************************\n _       __                         _       __                    \n| |     / /___ _____ ___  ____     | |     / /___ _____ ___  ____ \n| | /| / / __ `/ __ `__ \\/ __ \\    | | /| / / __ `/ __ `__ \\/ __ \\\n| |/ |/ / /_/ / / / / / / /_/ /    | |/ |/ / /_/ / / / / / / /_/ /\n|__/|__/\\__,_/_/ /_/ /_/ .___/     |__/|__/\\__,_/_/ /_/ /_/ .___/ \n__  __               _///  _          __                 /_/      \n\\ \\/ /___  __  __   / __ \\(_)__  ____/ /                          \n \\  / __ \\/ / / /  / / / / / _ \\/ __  /\n / / /_/ / /_/ /  / /_/ / /  __/ /_/ /\n/_/\\____/\\__,_/  /_____/_/\\___/\\__,_/\n***********************************************************\n");
		}
    }

    // figure out base level for game()
    public void setBaseLevel () {
        boolean INvalidBase = true;

        while (INvalidBase) {
            System.out.println("At what level would you start between 1 and 20?\nA higher level should mean a longer game.");
            
            String baseLevelStr = System.console().readLine();
            // make sure it's a number
            try {
                baseLevel = Integer.parseInt(baseLevelStr);
            } catch (NumberFormatException e) {
                System.out.println("Please choose a number character less than or equal to 20");
            }
            // make sure the number is between 1 & 20
            if (baseLevel >=1 && baseLevel <= 20) {
                INvalidBase = false;
            }
        }
    }
    
	// initialize room
    public void initializeRoom () {
        // generate monster()
        monster = new Monster(baseLevel);
		//monsterAlive = true;
        // does this room drop a key?
        // odds lower if higher base level
		int odds = 30 - baseLevel;
        Random rand1 = new Random();
		
        if (rand1.nextInt(101) < odds ) {
            roomKey = true;
        }
        else {
            roomKey = false;
        }
    }
	
    public void mainTurnLoop () {
		while (playerAlive) {
			// player starts with full health at the beginning of each room
			player.resetPlayerHealth();
			// initialize room
			initializeRoom();
			boolean inRoom = true;
			
			while (inRoom) {
				String playerAction;
				String monsterAction;
				// show stats
				showStatsTable();
				// if player alive
				if (player.hitPoints > 0) {
					// get player action
					playerAction = player.getPlayerAction();
				
					// evaluate action results
					evaluateAction(playerAction);
				}
				else {
					inRoom = false;
					playerAlive = false;
					return;
				}
				
				// if monster alive
				if (playerAlive && monster.hitPoints > 0) {
					// get monster action
					monsterAction = monster.getMonsterAction(player);
					
					// evaluate action results
					evaluateAction(monsterAction);
				}
				else {
					inRoom = false;
				}
			}
			
			// else get key
			if (playerAlive && roomKey) {
				player.keys++;
				System.out.println("Amongst the carnage you see a glistening shine.\nYou reach down and retrieve a large key. Congratulations!");
			}
			// end of game() or go to next room()
			if (player.keys < 3) {
				System.out.println("The monster is dead, and you progress on to the next room!");
			}
			else {
				System.out.println("Congratulations! You found all 3 keys!");
				return;
			}
		}
	}    

	public void showStatsTable () {
		System.out.println("--- | P1 | Mon\nHPs | " + player.hitPoints + " | " + monster.hitPoints + "\nCha | " + player.charisma + " | " + monster.charisma + "\nCon | " + player.constitution + " | " + monster.constitution + "\nDex | " + player.dexterity + " | " + monster.dexterity + "\nInt | " + player.intelligence + " | " + monster.intelligence + "\nStr | " + player.strength + " | " + monster.strength + "\nWis | " + player.wisdom + " | " + monster.wisdom);
	}
	
	public void evaluateAction (String choiceArg) {
		Random randObj = new Random();
		
		int playerStat = player.getPlayerStat(choiceArg);
		int monsterStat = monster.getMonsterStat(choiceArg);
		
		if (playerStat >= monsterStat) {
			monster.hitPoints -= (randObj.nextInt(playerStat) - randObj.nextInt((monster.constitution/4)));
			System.out.println("Your attack does some damage! Monster's HP is now at " + monster.hitPoints);
		}
		else {
			player.hitPoints -= (randObj.nextInt(monsterStat) - randObj.nextInt((player.constitution/4)));
			System.out.println("The monster's attack does some damage! Your HP is now at " + player.hitPoints);
		}
	}
} // close class
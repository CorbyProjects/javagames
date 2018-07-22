import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class Monster {
    int hitPoints, charisma, intelligence, dexterity, constitution, strength, wisdom; 
    String currentMonster;
    String[] possibleMonsters = {"Dalek", "Doll", "Dragon", "Kobold", "Lich", "Marching Band", "Mirror", "Orc", "rodents of unusal size", "Siren", "Troll", "Vampire", "Vardigg", "Weeping Angel"};

    public Monster (int baseLevelArg) {
        // randomly choose a monster from array
        // set to currentMonster
        Random randVar = new Random();
        int monsterIdx = randVar.nextInt(possibleMonsters.length);
        currentMonster = possibleMonsters[monsterIdx];

        int baseLvl = baseLevelArg;
        // set stats based on level + random modifier
        // set a minimum baseLvl so there are more interesting numbers
        baseLvl+=5;
        Random randObj = new Random();

        hitPoints = 10 + (baseLvl * randObj.nextInt((baseLvl/2)));
        charisma = 10 + randObj.nextInt(baseLvl);
        intelligence = 10 + randObj.nextInt(baseLvl);
        dexterity = 10 + randObj.nextInt(baseLvl);
        constitution = 10 + randObj.nextInt(baseLvl);
        strength = 10 + randObj.nextInt(baseLvl);
        wisdom = 10 + randObj.nextInt(baseLvl);

        // display character stats()
        displayMonsterStats();
    }

    // display character stats
    public void displayMonsterStats () {
        // describe monster to user
        // load description from file

        try {
            String filePath = new File("").getAbsolutePath();
            BufferedReader reader = new BufferedReader(new FileReader(filePath + "/monsters/" + currentMonster + ".txt"));

            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (IOException x) {
            x.printStackTrace();
        }
    }

    // set hp
    public void setMonsterHP (String gainOrLose, int howMany) {
        if (gainOrLose.equals("gain")) {
            hitPoints += howMany;
        }
        else {
            hitPoints -= howMany;
        }
        System.out.println("Monster hit Points are now: " + hitPoints);
    }

    // get hp
    public int getMonsterHP () {
        System.out.println("Monster hit Points are currently: " + hitPoints);
        return hitPoints;
    }

	public String getMonsterAction (PlayerChar playerArg) {
		// need to find where monster stats will beat player equivalent
		String action = "";
		if (this.strength > playerArg.strength) {
			System.out.println("They charge directly at you!");
			action = "strength";
		}
		else if (this.intelligence > playerArg.intelligence) {
			System.out.println("They begin muttering in some strange tongue, and their hands begin to glow with a blue-white light.");
			action =  "intelligence";
		}
		else if (this.wisdom > playerArg.wisdom) {
			System.out.println("Their eyes glaze in concentration. Their hands and fingers slowly twirl in the air in your direction. Sparks start shooting out of their fingertips.");
			action =  "wisdom";
		}
		else if (this.charisma > playerArg.charisma) {
			System.out.println("Bowing and dripping with politeness, they offer to share some tea and cake with you.");
			action =  "charisma";
		}
		else if (this.dexterity > playerArg.dexterity) {
			System.out.println("They decide you're no longer worth the trouble, and try to escape out of a secret door under one of the floor tiles.");
			action =  "dexterity";
		}
		else {
			// berserker rage!!
			System.out.println("They see you're superior in every way. This sends them into a berserker rage!");
			this.strength = playerArg.strength + 5;
			action =  "strength";			
		}
		return action;
	}
	
	public int getMonsterStat (String attr) {
		int stat = 0;
		
		if (attr == "strength") {
			stat = this.strength;
		}
		else if (attr == "intelligence") {
			stat = this.intelligence;
		}
		else if (attr == "wisdom") {
			stat = this.wisdom;
		}
		else if (attr == "charisma") {
			stat = this.charisma;
		}
		else if (attr == "dexterity") {
			stat = this.dexterity;
		}
		return stat;
	}
}
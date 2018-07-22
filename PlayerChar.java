import java.io.*;
import java.util.Random;

public class PlayerChar {
    int hitPoints, charisma, intelligence, dexterity, constitution, strength, wisdom, keys, startHitPoints;    

    public PlayerChar (int baseLvlArg) {
        int baseLvl = baseLvlArg;
        // set stats based on level + random modifier
        // set a minimum baseLvl so there are more interesting numbers
        baseLvl+=5;
        Random randObj = new Random();

        hitPoints = 10 + (baseLvl * randObj.nextInt(baseLvl));
		startHitPoints = hitPoints;
        charisma = 10 + randObj.nextInt(baseLvl);
        intelligence = 10 + randObj.nextInt(baseLvl);
        dexterity = 10 + randObj.nextInt(baseLvl);
        constitution = 10 + randObj.nextInt(baseLvl);
        strength = 10 + randObj.nextInt(baseLvl);
        wisdom = 10 + randObj.nextInt(baseLvl);
        keys = 0;
    }
	
	public String getPlayerAction () {
		boolean INvalid = true;
		String action = "";
		
		while (INvalid) {
			System.out.println("What do you do:\n1) Try to charm them into being BFFs (Cha)\n2) Run away, run away! But try to steal anything of value on the way out. (Dex)\n3) Cast Maaaaagic Missles!! (Int)\n4) Ataaaaaaaaaack!! (Str)\n5) Heh heh. Fire! Yeah! Fire! (Wis)");
			
			String responseStr = System.console().readLine();
			int responseInt = Integer.parseInt(responseStr);
			
			if (responseInt == 1) {
				action = "charisma";
				INvalid = false;
			}
			else if (responseInt == 2) {
				action = "dexterity";
				INvalid = false;
			}
			else if (responseInt == 3) {
				action = "intelligence";
				INvalid = false;
			}
			else if (responseInt == 4) {
				action = "strength";
				INvalid = false;
			}
			else if (responseInt == 5) {
				action = "wisdom";
				INvalid = false;
			}
		}
		return action;
	}
	
	public int getPlayerStat (String attr) {
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
	
	public void resetPlayerHealth () {
		this.hitPoints = this.startHitPoints;
		System.out.println("You feel refreshed and restored.");
	}	
}
import java.io.*;
import java.util.Random;

public class PlayerChar {
    int hitPoints, charisma, intelligence, dexterity, constitution, strength, wisdom, keys;    

    public PlayerChar (int baseLvlArg) {
        int baseLvl = baseLvlArg;
        // set stats based on level + random modifier
        // set a minimum baseLvl so there are more interesting numbers
        baseLvl+=5;
        Random randObj = new Random();
        //int rand1 = randObj.nextInt(baseLvl);

        hitPoints = 10 + (baseLvl * randObj.nextInt(baseLvl));
        charisma = 10 + randObj.nextInt(baseLvl);
        intelligence = 10 + randObj.nextInt(baseLvl);
        dexterity = 10 + randObj.nextInt(baseLvl);
        constitution = 10 + randObj.nextInt(baseLvl);
        strength = 10 + randObj.nextInt(baseLvl);
        wisdom = 10 + randObj.nextInt(baseLvl);
        keys = 0;

        // display character stats()
        displayPlayerStats();
    }

    // display character stats
    public void displayPlayerStats () {
        System.out.println("Hit Points: " + hitPoints + "\nCharisma: " + charisma + "\nIntelligence: " + intelligence + "\nDexterity: " + dexterity + "\nConstitution: " + constitution + "\nStrength: " + strength + "\nWisdom: " + wisdom + "\nKeys: " + keys);
    }

    // set hp
    public void setPlayerHP (String gainOrLose, int howMany) {
        if (gainOrLose.equals("gain")) {
            hitPoints += howMany;
        }
        else {
            hitPoints -= howMany;
        }
        System.out.println("Player hit Points are now: " + hitPoints);
    }

    // get hp
    public int getPlayerHP () {
        System.out.println("Player hit Points are currently: " + hitPoints);
        return hitPoints;
    }

    // take key
    public void takeKey (boolean key) {
        if (key) {
            keys++;
            System.out.println("Congrats, you've earned a key!");
        }
    }

    // get keys
    public int getKeys () {
        System.out.println("Number of keys: " + keys);
        return keys;
    }

    // attack (str)

    // cast spell (int)

    // run/dodge (dex)

    // charm them (cha)

    // use the undead  (con)

}
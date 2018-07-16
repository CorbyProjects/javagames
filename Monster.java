import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class Monster {
    int hitPoints, charisma, intelligence, dexterity, constitution, strength, wisdom; 
    String currentMonster;
    /* String[] possibleMonsters = {"Dalek", "Doll", "Dragon", "Kobold", "Lich", "Marching Band", "Mirror", "Orc", "Rodents of Unusual Size", "Siren", "Troll", "Vampire", "Vardigg", "Weeping Angel"};
    */
    String[] possibleMonsters = {"Dalek", "Doll", "Dragon", "Kobold", "Lich", "Mirror", "Siren", "Vardigg"};

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

        hitPoints = 10 * randObj.nextInt(baseLvl);
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
        
        System.out.println("Hit Points: " + hitPoints + "\nCharisma: " + charisma + "\nIntelligence: " + intelligence + "\nDexterity: " + dexterity + "\nConstitution: " + constitution + "\nStrength: " + strength + "\nWisdom: " + wisdom);
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

    // attack
    // different attacks for different monsters

}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * chArray : this is a char array
 * dashesUp : this is also a char array which will have dashes
 * score this : will store the score for the palyer
 *
 */
public class Game {
        static char [] chArray = null;
        static char [] dashesUp = null;
        static int score = 0;
        static ArrayList<String> stringArray = new ArrayList<String>();
        static ArrayList<Movies> eachMovie = new ArrayList<Movies>();
        static ArrayList<Player> eachPlayer= new ArrayList<Player>();

    /**
     * this is a GameStart method which will read the file from
     * system and stored in an arraylist
     */
    public static void GameStart() {
        try {
            Scanner scanner = new Scanner(new File("E:/Java/OOP_2019501004/words"));
            while (scanner.hasNextLine()) {
                stringArray.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i <= stringArray.size() - 5; i = i + 5) {
            Movies movie = new Movies(stringArray.get(i).toLowerCase(), stringArray.get(i + 1), stringArray.get(i + 2),
                    stringArray.get(i + 3));
            eachMovie.add(movie);
            //  System.out.println;
        }
        Movie_db obj = new Movie_db(eachMovie);
        // System.out.println(obj.easyMovie.toString());

        System.out.println("Enter number of players ");
        int number = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            if (scanner.hasNext() && !scanner.hasNextInt()) {
                scanner.next();
                System.out.println("Please enter a number");
            }
            //catch(InputMismatchException e){
            //Do Nothing
            //}
        } while (!scanner.hasNextInt());
        if (scanner.hasNextInt()) {
            number = scanner.nextInt();
        }

        for (int i = 1; i < number + 1; i++) {
            System.out.println("Enter the name for player " + i + " and it's level ");
            Player p = new Player(scanner.next(), scanner.nextInt(), score);
            eachPlayer.add(p);
        }
        for (Player p : eachPlayer) {
            System.out.println("Turn for Player " + p.getName());
            play(p);
            System.out.println("Player " + p.getName() + " turn ends.");
        }

        System.out.println("LeaderBoard :\n" + eachPlayer);

    }


    /**.
     * Actual game will be started from here
     * for this p will be input, p is a player
     * @param p player
     * @param bonus this variable is for bonus to the player.
     * @param hint this will store the no of hints available
     * @param guess this will hold the guess count for the palyer
     */

    public static void play(Player p) {


        int guess = 8;
        int bonus = 2;
        int hint = 2;
        Movies m = new Movies();
        switch (p.getLevel()){
            case 1 :
            System.out.println(Movie_db.easyMovie.size());
            m = Movie_db.easyMovie.get((int)(Math.random()*(Movie_db.easyMovie.size() - 1)));
            break;
            case 2 :
            m = Movie_db.mediumMovie.get((int)(Math.random()*(Movie_db.mediumMovie.size() - 1)));
            break;
            case 3 :
            m = Movie_db.hardMovie.get((int)(Math.random()*(Movie_db.hardMovie.size() - 1)));
            break;
            default :
            m =Game.eachMovie.get((int)(Math.random()*(Game.eachMovie.size() - 1)));

        }
        chArray = m.getName().toCharArray();
        dashesUp = new char[chArray.length];


        score = m.getName().length();
        for(int i = 0; i < (m.getName().length()); i ++){
            if(chArray[i] == ' '){
                dashesUp[i] = ' ';
            }
            else
                dashesUp[i] = '-';
        }

        while(true){ //guess > 0 && guessedword --> bool

            System.out.println("Movie to be guessed is :" );
            for(int i = 0; i < dashesUp.length; i++){
                System.out.print(dashesUp[i]);
            }
            System.out.println("\nEnter your guess. Press ? for hint ");
            Scanner scanner = new Scanner(System.in);
            char c = ' ';
            if(scanner.hasNext()){
                c = scanner.next().charAt(0);
            }
            if(c == '?'){
                if(hint == 2){
                    System.out.println("Hint : "+m.getHint1());
                    System.out.println("\nYou have 1 hint left");
                }
                else if(hint == 1){
                    System.out.println("Hint : "+m.getHint2());
                    System.out.println("\nYou have no hint left");
                }
                else{
                    System.out.println("\nNo hints available");
                }
                hint--;
                bonus = 0;
            }
            else {
                if(!isWordGuessed(c)){
                    guess--;
                    bonus=0;
                    score--;
                }
            }

            if(guess == 0 || String.valueOf(chArray).equals(String.valueOf(dashesUp))){
                //System.out.println(guess);
                //System.out.println(Arrays.equals(chArray, dashesUp));
                System.out.println(dashesUp);
                break;
            }
        }
        System.out.println("Score ;" + score);
        p.setScore(score,bonus);
        System.out.println(p.getScore());

    }
/**
 *
 * @param ch ch is input to this function
 * @return this will return true if the word guessed is correct
 */
    public static boolean isWordGuessed(char ch) {

        boolean check = false;
        for(int i = 0; i < chArray.length; i++){
            if(chArray[i] == ch){
                dashesUp[i] = ch;

                check = true;
            }
        }
        return check;
    }
/**
 * This is a main function from which the game will be loaded.
 * @param args will take input from the console
 */
	public static void main(String[] args) {
        GameStart();

    }

}


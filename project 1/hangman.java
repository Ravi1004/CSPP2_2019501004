
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class hangman {

	public static void main(String[] args) {
        ArrayList<String> stringArray = new ArrayList<String>();
        ArrayList<Word> words = new ArrayList<Word>();

		try {
			Scanner scanner = new Scanner(new File("E:/Java/OOP_2019501004/words"));
			while (scanner.hasNextLine()) {
                    stringArray.add(scanner.nextLine());
            }scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
        }
        System.out.println(stringArray.toString());
        for (int i = 0; i<= stringArray.length; i = i+4){
            Movies movie = new Movies(stringArray.get(i), stringArray.get(i+1), stringArray.get(i+2));
            words.add(movie);
            
        }
    }
}



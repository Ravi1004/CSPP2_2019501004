import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
    /**
     * This method adds movie object to the movies ArrayList
     * 
     * @param movie
     */
    public void addMovie(Movie movie) {
        movies[count++] = movie;
    }

    /**
     * This method categorizes the movies into easy,medium,hard
     * 
     * @param movieDetails
     */
    public void category(String[] movieDetails) {
        for (String eachMovie : movieDetails) {
            String movie = eachMovie.split("\n")[0];
            String level = eachMovie.split("\n")[1];
            String hints[] = new String[2];
            hints[0] = eachMovie.split("\n")[2];
            hints[1] = eachMovie.split("\n")[3];
            addMovie(new Movie(movie, level, hints));
            if (eachMovie.split("\n")[1].equals("Easy")) {
                easy += eachMovie.split("\n")[0] + "\n";
            }
            if (eachMovie.split("\n")[1].equals("Medium")) {
                medium += eachMovie.split("\n")[0] + "\n";
            }
            if (eachMovie.split("\n")[1].equals("Hard")) {
                hard += eachMovie.split("\n")[0] + "\n";
            }
            // System.out.println(eachMovie.split("\n")[0]);
        }
        easyMovies = easy.split("\n");
        mediumMovies = medium.split("\n");
        hardMovies = hard.split("\n");
    }

    /**
     * Thiis method provides hints to the user when he enters '?'
     * 
     * @param hintCount
     * @param movie
     */
    public void giveHints(int hintCount, String movie) {
        if (hintCount == 1) {
            for (int i = 0; i < count; i++) {
                if (movies[i].getMovieName().equals(movie)) {
                    System.out.println(movies[i].getHints()[0]);
                }
            }
        } else if (hintCount == 2) {
            for (int i = 0; i < count; i++) {
                if (movies[i].getMovieName().equals(movie)) {
                    System.out.println(movies[i].getHints()[1]);
                }
            }
        } else {
            System.out.println("You ran out of hints!!!");
        }
    }

    /**
     * This method sets the players and the players will be added to the playersList
     */
    public void setPlayers() {
        System.out.println("Enter number of players");
        int noOfPlayers = scanner.nextInt();
        for (int i = 0; i < noOfPlayers; i++) {
            playersList.add(new Player());
        }
        startPlay(playersList);
    }

    /**
     * This method displays the final leaderboard
     * 
     * @param playersList
     */
    public void leaderBoard(ArrayList<Player> playersList) {
        System.out.println("============= LEADERBOARD =============");
        System.out.println("\t" + "Player" + "\t" + "level" + "\t" + "Score");
        for (int i = 0; i < playersList.size(); i++) {
            System.out.println("\t" + playersList.get(i).getName() + "\t" + playersList.get(i).getLevel() + "\t"
                    + playersList.get(i).getScore());
        }
    }

    /**
     * This method starts the actual game
     * 
     * @param playersList
     */
    public void startPlay(ArrayList<Player> playersList) {
        // System.out.println("Select level of difficulty 1 - 3");
        // int enteredLevel = scanner.nextInt();
        for (Player player : playersList) {
            System.out.println("=============== Player " + player.getName() + " ================");
            Movie movie = new Movie();
            String s = movie.getRandomMovie(player.getLevel());
            // System.out.println(movie.getRandomMovie(2));
            // System.out.println(s);
            String d = s.replaceAll("[a-zA-z]", "-");
            System.out.println(d);
            int guesses = s.replace(" ", "").length();
            System.out.println("Guess " + guesses + " letters movie name ");
            ArrayList<Character> al = new ArrayList<Character>();
            String alphabets = "abcdefghijklmnopqrstuvwxyz";
            int hcount = 1;
            while (guesses > 0) {
                System.out.println("===================================================");
                System.out.println("You have " + guesses + " guesses left");
                System.out.println("Guess a letter (or) Enter ? for hints");
                // Scanner letter = new Scanner(System.in);
                char scannedChar = scanner.next().charAt(0);
                // System.out.println(movie.guessedLetters(scannedChar, s));
                if (scannedChar == '?') {
                    giveHints(hcount, s);
                    hcount++;
                }
                if (!al.contains(scannedChar)) {
                    if (scannedChar != '?') {
                        al.add(scannedChar);
                    }
                } else {
                    System.out.println("You have already guessed the letter!!");
                    // alphabets = alphabets.replace(String.valueOf(scannedChar), "");
                    // System.out.println("Available letters : " + alphabets);//
                    // .replace(String.valueOf(scannedChar), ""));
                }
                System.out.println("Guessed letters : " + al);
                alphabets = alphabets.replace(String.valueOf(scannedChar), "");
                System.out.println("Available letters : " + alphabets);// .replace(String.valueOf(scannedChar), ""));
                if (s.indexOf(scannedChar) >= 0) {
                    d = movie.displayMovie(scannedChar, s, d);
                    if (d.equals(s)) {
                        System.out.println("You won!!!");
                        System.out.println("The movie is : " + s);
                        // System.out.println("Your score : " + (guesses * 2));
                        break;
                    } else {
                        System.out.println(movie.displayMovie(scannedChar, s, d));
                        // System.out.println("You have " + guesses + " guesses left");
                    }
                } else if (scannedChar != '?') {
                    System.out.println("Wrong Guess!!" + "\n");
                    System.out.println(movie.displayMovie(scannedChar, s, d));
                    guesses--;
                    // System.out.println("You have " + guesses + " left");
                }
            }
            if (guesses == 0) {
                System.out.println("You ran out of guesses !!! ");
                System.out.println("The movie is : " + s);
            }
            player.setScore(guesses, hcount, player.getLevel());
        }
        leaderBoard(playersList);
    }

    public static void main(String[] args) {
        Hangman h = new Hangman();
        h.category(movieDetails);
        // System.out.println(h.count);
        h.setPlayers();
        // h.startPlay();
        // System.out.println("Select level of difficulty 1 - 3");
        // Scanner scan = new Scanner(System.in);
        // int enteredLevel = scan.nextInt();
        // Movie movie = new Movie();
        // String s = movie.getRandomMovie(enteredLevel);
        // // System.out.println(movie.getRandomMovie(2));
        // System.out.println(s);
        // String d = s.replaceAll("[a-zA-z]", "-");
        // System.out.println(d);
        // int guesses = s.replace(" ", "").length();
        // System.out.println(guesses);
        // ArrayList<Character> al = new ArrayList<>();
        // String alphabets = "abcdefghijklmnopqrstuvwxyz";
        // int hcount = 1;
        // while (guesses > 0) {
        // System.out.println("===================================================");
        // System.out.println("You have " + guesses + " guesses left");
        // System.out.println("Guess a letter or Enter ? for hint");
        // // Scanner letter = new Scanner(System.in);
        // char scannedChar = scan.next().charAt(0);
        // // System.out.println(movie.guessedLetters(scannedChar, s));
        // if (scannedChar == '?') {
        // h.giveHints(hcount, s);
        // hcount++;
        // }
        // if (!al.contains(scannedChar)) {
        // if (scannedChar != '?') {
        // al.add(scannedChar);
        // }
        // } else {
        // System.out.println("You have already guessed the letter!!");
        // // alphabets = alphabets.replace(String.valueOf(scannedChar), "");
        // // System.out.println("Available letters : " + alphabets);//
        // // .replace(String.valueOf(scannedChar), ""));
        // }
        // System.out.println("Guessed letters : " + al);
        // alphabets = alphabets.replace(String.valueOf(scannedChar), "");
        // System.out.println("Available letters : " + alphabets);//
        // .replace(String.valueOf(scannedChar), ""));
        // if (s.indexOf(scannedChar) >= 0) {
        // d = movie.displayMovie(scannedChar, s, d);
        // if (d.equals(s)) {
        // System.out.println("You won!!!");
        // System.out.println("Your score : " + (guesses * 2));
        // break;
        // } else {
        // System.out.println(movie.displayMovie(scannedChar, s, d));
        // // System.out.println("You have " + guesses + " guesses left");
        // }
        // } else if (scannedChar != '?') {
        // System.out.println("Wrong Guess!!" + "\n");
        // System.out.println(movie.displayMovie(scannedChar, s, d));
        // guesses--;
        // // System.out.println("You have " + guesses + " left");
        // }
        // }

    }

}
import java.util.ArrayList;
/**
 * this is a movie database which will seperate movies based on dificulty level
 * and stored in arraylist
 * @author Ravi
 *
 */
public class Movie_db {

    static ArrayList<Movies> easyMovie = new ArrayList<Movies>();
    static ArrayList<Movies> mediumMovie = new ArrayList<Movies>();
    static ArrayList<Movies> hardMovie = new ArrayList<Movies>();

    public Movie_db(ArrayList<Movies> eachMovie) {
        for (int i = 0; i < eachMovie.size(); i++){
           if( eachMovie.get(i).getLevel().equals("Easy")){
               easyMovie.add(eachMovie.get(i));

           } else if(eachMovie.get(i).getLevel().equals("Medium")){
               mediumMovie.add(eachMovie.get(i));

           }else{
               hardMovie.add(eachMovie.get(i));
           }
        }

    }

}
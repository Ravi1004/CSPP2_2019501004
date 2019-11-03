/**
 * @author Ravi
 */


class Movies {

    /*
        * . This class stores the infromation about the movie
        *
        * @param name holds the name of the movie
        *
        * @param level holds the level of the movie
        *
        * @param hint1 holds the hint 1
        *
        * @param hint2 holds the hint 2
        */
    private String name;
    private String level;
    private String hint1;
    private String hint2;

    public Movies(String name, String level, String hint1, String hint2) {

        this.name = name;
        this.level = level;
        this.hint1 = hint1;
        this.hint2 = hint2;
    }

    public Movies(){
    }
/**
 *
 * @return get the name of movie
 */
    public String getName() {
        return name;
    }
/**
 *
 * @param name will set the name
 */
    public void setName(String name) {
        this.name = name;
    }
/**
 *
 * @return get the level of the level
 */
    public String getLevel() {
        return level;
    }
/**
 *
 * @param level will set the level for the movie
 */
    public void setLevel(String level) {
        this.level = level;
    }
/**
 *
 * @return this will give the hint
 */
    public String getHint1() {
        return hint1;
    }

    /**
     *  this will set the hint
     */
    public void setHint1(String hint1) {
        this.hint1 = hint1;
    }
/**
 *
 * @return this will get the hint
 */
    public String getHint2() {
        return hint2;
    }
/**
 *
 * @param hint2 will set the hint2 for the movie
 */
    public void setHint2(String hint2) {
        this.hint2 = hint2;
    }

    /**
     *this is a to string method
     */
    @Override
    public String toString() {
        return "name= " + name + ",level= " + level + ",hint1= " + hint1 + ",hint2= " + hint2 ;
    }


}
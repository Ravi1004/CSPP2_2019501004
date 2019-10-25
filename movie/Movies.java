/**
 * This  class stores the infromation about the movie 
 * @param name holds the name of the movie
 * @param level holds the level of the movie
 * @param hint1 holds the hint 1
 * @param hint2 holds the hint 2
 * @author Ravi
 */


class Movies{
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getHint1() {
        return hint1;
    }

    public void setHint1(String hint1) {
        this.hint1 = hint1;
    }

    public String getHint2() {
        return hint2;
    }

    public void setHint2(String hint2) {
        this.hint2 = hint2;
    }

    @Override
    public String toString() {
        return "name= " + name + ",level= " + level + ",hint1= " + hint1 + ",hint2= " + hint2 ;
    }
    
    
}
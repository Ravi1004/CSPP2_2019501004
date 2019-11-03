/**
 * . Player
 *
 * @author Ravi Viswanadhula
 */

class Player implements Comparable<Player> {

    /**
     * . this will take name of the player
     */
    private String name;

    /**
     * . this will take the score
     */
    private int score;

    /**
     * . this will take the level of the
     */
    private int level;

    /**
     * . Constructor
     *
     * @param name1  player name
     * @param level1 player level
     * @param score1 player score
     */
    Player(final String name1, final int level1, final int score1) {
        this.name = name1;
        this.level = level1;
        this.score = score1;

    }

    /**
     * .
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * .
     *
     * @return the level
     */
    public int getLevel() {
        return this.level;
    }

    /**
     * .
     *
     * @return the score
     */

    public int getScore() {
        return this.score;
    }

    /**
     * .
     *
     * will set the name
     *
     * @param name2 .
     */

    public void setName(final String name2) {
        this.name = name2;
    }

    /**
     * . will set the score
     *
     * @param score2 the score
     * @param bonus the bonus
     */
    public void setScore(final int score2, final int bonus) {
        this.score = score2 + bonus;
    }

    /**
     * .
     *
     * this is a compare method
     *
     * @param p player object
     *
     * @return integer value
     */

    public int compareTo(final Player p) {
        return p.score - this.score;
    }

    /**
     * .
     *
     * this is a tostring
     *
     * @return in string format
     */

    public String toString() {
        return "Player\t Name : " + this.name
                        + "\t Score : " + this.score + " ";
    }
}

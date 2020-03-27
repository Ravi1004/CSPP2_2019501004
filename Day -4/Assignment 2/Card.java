public class Card {
    private String titleOfTheBook;
    private String authorOfTheBook;
    private String subjectOfTheBook;

    public Card() {

    }
   /**
    * 
    * @param titleOfTheBook
    * @param authorOftheBook
    * @param subjectOfTheBook
    */ 
    public Card(final String titleOfTheBook, final String authorOftheBook, final String subjectOfTheBook) {
        this.titleOfTheBook = titleOfTheBook;
        this.authorOfTheBook = authorOftheBook;
        this.subjectOfTheBook = subjectOfTheBook;
    }
    /**
     * 
     * 
     * @param titleOftheBook
     */
    public void setTitleOfTheBook(final String titleOftheBook) {
        this.titleOfTheBook = titleOftheBook;
    }
    /**
     * 
     * @return
     *
     */
    public String getTitleOfTheBook() {
        return this.titleOfTheBook;
    }
    /**
     * 
     * @param authorOftheBook
     */
    public void setAuthorOfTheBook(final String authorOftheBook) {
        this.authorOfTheBook = authorOftheBook;
    }
    /**
     * 
     * @return
     */
    public String getAuthorOfTheBook() {
        return this.authorOfTheBook;
    }
    /**
     * 
     * @param subjectOftheBook
     */
    public void setSubjectOfTheBook(final String subjectOftheBook) {
        this.subjectOfTheBook = subjectOftheBook;
    }
    /**
     * 
     * @return
     */
    public String getSubjectOfTheBook() {
        return this.subjectOfTheBook;
    }

    public String toString() {
        String output = "Name = " + this.titleOfTheBook + "," + " Author = "
        + this.authorOfTheBook + "," + " Subject = " + this.subjectOfTheBook ;
        return output;
    }
}

import java.util.*;

// this is a class
public class List extends AbstractList{
    /**
     * This is an add method 
     * @param item
     */
    public void add(int item) {
        //Inserts the specified element at the end of the list.
        if (size <= list.length) {
            list[size++] = item;
        }
    }

  
}

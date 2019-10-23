import java.util.*;
import java.lang.*;

public class OrderedList extends AbstractList{
    
    public void add(int item) {
        //Inserts the specified element at the end of the list.
        if (size <= list.length) {
            list[size++] = item;
        }
        Arrays.sort(list);
    }

}
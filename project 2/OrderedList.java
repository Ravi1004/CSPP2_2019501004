import java.util.Arrays;

public class OrderedSet extends AbstractSet {
    /*
     * The add method does what the name suggests.
     * Add an int item to the list.
     * The assumption is to store the item at the end of the list
     * What is the end of the list?
     * Is it the same as the end of the array?
     * Think about how you can use the size variable to add item
     * to the list.
     * 
     * The method returns void (nothing)
     */
    public void add(int item) {
        //Inserts the specified element at the end of the list.
        // TODO
        // Your code goes here....
        if (size >= set.length) {
            resize();
        }
        set[size++] = item;
        Arrays.sort(set);
    }

    public int rank(int item) {
        int lo = 0, hi = size-1; 
        while (lo <= hi) { 
            int mid = lo + (hi - lo) / 2;
            if      (item < set[hi]) hi = mid - 1; 
            else if (item > set[lo]) lo = mid + 1; 
            else return mid; 
        } 
        return lo;
    } 

    public static void main(String[] args) {
        AbstractSet lst = new OrderedSet();
        lst.add(1, 1);
    }
    
}
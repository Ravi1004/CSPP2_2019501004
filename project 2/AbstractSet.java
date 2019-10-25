
import java.util.*;
import java.util.List;
import java.lang.*;

public abstract class AbstractSet implements SetInterface  {
    

    public int[] set;
    public int size;

    public AbstractSet() {

        set = new int[10];
        size = 0;
    }
    
   
    public AbstractSet(int capacity) {
        size = 0;
        set = new int[capacity];
    }
    
   
    public void add(int item) {
        //Inserts the specified element at the end of the list.
        // TODO
        // Your code goes here.
        if (size >= set.length) {
            resize();
        }
        set[size++] = item;
    }

    
    public final void add(int index, int item) {
        // TODO
        // Your code goes here.
        if(index > 0 && index > size){
            resize();
            set[index] = item;
        }else if(index > 0 && index < size){
            for (int i = size; i > index; i--){
                set[i] = set[i-1];
            }
            set[index] = item;
        }
    }

   
    public void addAll(Set lst) {
        // TODO
        // Your code goes here.
        resize();
        int index = size;
        for(int i = 0; i < lst.length; i++){
            set[index++] = this.lst[i];
        }
    }

   
    public void addAll(int[] arr ){
        // TODO
        // Your code goes here.
        if((set.length - size) < arr.length){
            resize();
            int index = size;
            for(int i = 0; i < arr.length; i++){
                set[index++] = arr[i];
            }
        }else{
            int index = size;
            for(int i = 0; i < arr.length; i++){
                set[index++] = arr[i];
            }
        }
    }

   
    public int size() {
        // replace the code below to implement the size method
        // TODO
        // Your code goes here.
        return size;
    }

   
    public void resize() {
        // TODO
        // Your code goes here.
        set = Arrays.copyOf(set, 2 * size);
    }

   
    public void remove(int index) {
        // write the logic for remove here.
        // Think about what to do to the size variable.list
        // TODO
        // Your code goes here.
        if (index < size) {
            int i;
            for(i = index; i < size; i++) {
                set[i] = set[i+1];
            }
            set[i] = 0;
            size--;
        }
    }

   
    public int get(int index) {
        // Replace the code below to write the code for get
        // TODO
        // Your code goes here.
        if (index >= 0 && index < size) {
            return set[index];
        }
        return -1;
    }

  
    public String toString() {
        // Replace the code below
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for(int i=0; i<size-1; i++)
            sb.append(set[i] + ",");
        sb.append(set[size-1]);
        sb.append("]");
        return sb.toString();
    } 
    
   
    public boolean contains(int item) {
        // TODO
        // Your code goes here.
        // for(int i = 0; i < size; i++){
        //     if (list[i] == item){
        //         return true;
        //     }
        // }
        // return false;
        return indexOf(item) != -1;
    }

    
    public int indexOf(int item) {
        // TODO
        // Your code goes here.
        for(int i = 0; i < size; i++) {
            if(item == set[i]){
                return i;
            }
        }
        return -1;
    }

    
    public int lastIndexOf(int item) {
        // TODO
        // Your code goes here.
        for(int i = size ; i >= 0; i--){
            if (set[i] == item){
                return i;
            }
        }
        return -1;
    }

    
    public int count(int item) {
        // TODO
        // Your code goes here.
        int count = 0;
        for (int i = 0; i < size; i++){
            if(set[i] == item){
                count++;
            }
        }
        return count;
    } 

    
    public Set subSet(int fromIndex, int toIndex) {
        // TODO
        // Your code goes here.
        Set [] subSet = new Set[toIndex - fromIndex + 1];
        int index = 0;
        if (fromIndex >= 0 && fromIndex < toIndex){
            for (int i = fromIndex; i <= toIndex; i++){
                subSet[index] = set[i];
                index++;
            }
            return subSet;
        }
    }

    
    public void set(int index, int item) {
        // TODO
        // Your code goes here.list
        if(index >= 0){
            set[index] = item;
        }
    }
}
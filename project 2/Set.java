public class Set extends AbstractSet {
    
    public final void add(int index, int item) {
        // TODO
        // Your code goes here.
        if(index > 0 && index > size){
            resize();
            set[size] = item;
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
        // Your code goes here.list
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
}
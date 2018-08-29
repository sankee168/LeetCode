public class ArrayList<T> implements Iterable<T>{

    private T[] arr;
    private int size;
    private int MAX_SIZE = 10;

    public ArrayList(){
        arr = (T[]) new Object[MAX_SIZE];
        size = 0;
    }

    //adds element to the end
    public void add(T e){
        if(size*2 > MAX_SIZE){
            modifyArray();
        }
        arr[size] = e;
        size++;
    }

    private void modifyArray(){
        T[] temp = (T[])new Object[2*MAX_SIZE];
        MAX_SIZE = 2*MAX_SIZE;
        for(int i = 0; i < arr.length; i++){
            temp[i] = arr[i];
        }
        arr = temp;
    }

    //removes element from the beginning
    public void remove(){
        arr[size-1] = null;
        size--;
    }

    //returns size of the list
    public int size(){
        return size;
    }

    //returns true if list contains e
    public boolean contains(T e){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == e) return true;
        }

        return false;
    }

    public T get(int i){
        if(size <= i) throw new IndexOutOfBoundsException(" index out of bounds ");
        return arr[i];
    }



    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements  Iterator<T>{

        int nexIndex = 0;

        @Override
        public boolean hasNext() {
            if(nexIndex < size) return true;
            return false;
        }

        @Override
        public T next() {
            if(!hasNext()) throw new IndexOutOfBoundsException("index is out of bounds");
            T temp = arr[nexIndex];
            nexIndex++;
            return temp;
        }

        @Override
        public void remove() {
            return;
        }
    }

}

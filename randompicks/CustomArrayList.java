public class CustomArrayList<K> {
	
	private static final int THRESHOLD_SIZE = 5;
	private K k;
	Object[] array;
	int size;
	int MAX_SIZE = 10;

	public CustomArrayList(){
		array = new (K[]) Object[MAX_SIZE];
	}

	public void add(K obj){
		if(size == MAX_SIZE-THRESHOLD_SIZE){
			moveToBiggerArray();
		}
		array[size++] = obj;
	}

	public K get(int index){
		if(index >= size) throw new IndexOutOfBoundsException();
		return array[index];
	}


	private void moveToBiggerArray(){
		Object[] temp = new Object[MAX_SIZE*2];
		MAX_SIZE *= 2;
		for(int i = 0; i < size; i++){
			temp[i] = array[i];
		}

		array = temp;
	}
}
public class SuperArray{
    private String[] data;
    private int size;
  
    //constructor make an empty superArray should make size 0, 
    //but the data capacity 10.

    public SuperArray() {
	data = new String[10];
	size = 0;
    }

    public SuperArray(int initCapacity) {
	if (initCapacity < 0) {
	    throw new IllegalArgumentException("The specified initial capacity is negative.");
	}
	data = new String[initCapacity];
	size = 0;
    }

    public SuperArray(String[]ary, int initCapacity) {
	if (initCapacity < 0) {
	    throw new IllegalArgumentException();
	}
	data = ary;
	size = ary.length;
    }
    
    //returns size of the array.
    public int size(){
	return size;
    }

    //returns the element in the specified index.
    public String get(int index) {
	if (index < 0 || index >= size()) {
	    throw new IndexOutOfBoundsException("The index is out of range.");
	}
	return data[index];
    }

    //Appends the specified element to the end of this list. It returns true.
    public boolean add(String n){
	if (data.length > size()) {
	    data[size] = n;
	    size++;
	}
	else{
	    grow(1);
	    data[size] = n;
	    size++;
	}
	return true;
    }

    //Resizes the arrray by the given number.
    private void grow(){
	String[]tData = new String[size * 2];
	for (int u = 0;u < data.length;u++) {
	    tData[u] = data[u];
	}
	data = tData;
    }

    private void grow(int n){
	String[]tData = new String[size + n];
	for (int u = 0;u < size();u++) {
	    tData[u] = data[u];
	}
	data = tData;
    }


    
    /**format the super array like this :   [ 1, 3, 6, 8, 23, 99, -4, 5] 
     *commas between... square bracket start/end and no comma at end. */
    public String toString(){
	if (size() <= 0) {return "[ ]";} 
	String ans = "[";
	for (int n = 0;n < size() - 1;n++) {
	    ans += data[n] + ", ";
	}
	ans += data[size - 1] + "]";
	return ans;
    }

    //format the super array like this :   [ 1, 8, 23, 99, -4, 5, _, _, _, _]
    public String toStringDebug(){
	String ans = "[";
	if (size() < data.length) {
	    for (int n = 0;n < size();n++) {
		ans += data[n] + ", ";
	    }
	    for (int u = size();u < data.length;u++) {
		ans += "_, ";
	    }
	    ans += "_]";
	}
	else {toString();}
	return ans;
    }

    //Clears all elements in the array.
    public void clear() {
	String[]tData = new String[10];
	data = tData;
	size = 0;
    }

    //Tests if the array is empty.
    public boolean isEmpty() {
	return size == 0;
    }

    //Replaces the element at the specified position in this list with the specified element. Returns the value of the element replaced.
    public String set(int index, String element) {
	if (index < 0 || index >= size()) {
	    throw new IndexOutOfBoundsException("The index is out of range.");
	}
	String deletedElement = data[index];
	data[index] = element;
	return deletedElement;
    }

    //Inserts the specified element at the specified position in this list. Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
    public void add(int index, String element){
	if (index < 0 || index > size()) {
	    throw new IndexOutOfBoundsException("The index is out of range.");
	}
	size = size() + 1;
	String[] tData = new String[size];
	for (int n = 0; n < index; n++) {
	    tData[n] = data[n];
	}
	for(int x = index + 1; x < size; x++) {
	    tData[x] = data[x - 1];
	}
	tData[index] = element;
	data = tData;
    }

    //Removes the element at the specified position in this list. Shifts any subsequent elements to the left (subtracts one from their indices). The value returned is the value of the element removed.
    public String remove(int index){
	if (index < 0 || index >= size()) {
	    throw new IndexOutOfBoundsException("The index is out of range.");
	}
	String removedElement = data[index];
	for (int x = index; x < size() - 1; x++){
	    set(x, data[x + 1]);
	}
	size = size() - 1;
	return removedElement;
    }

    //Returns an array containing all of the elements in this list in proper sequence (from first to last element).
    public String[] toArray(){
	String[] temp = new String[size];
	for (int x = 0; x < size; x++){
	    temp[x] = data[x];
	}
	return temp;
    }

    //Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
    public int indexOf(String str){
	for(int x = 0; x < size; x++){
	    if(data[x] == str){
		return x;
	    }
	}
	return -1;
    }

    //Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.
    public int lastIndexOf(String str){
	for(int x = size - 1; x >= 0; x = x - 1){
	    if(data[x] == str){
		return x;
	    }
	}
	return -1;
    }
}

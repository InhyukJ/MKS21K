public class Sorts{
    /**EDIT THIS METHOD TO MATCH YOUR NAME 
     */
    public static String name(){
	return "09.Jun.Inhyuk"; 
    }
    
    /**Selection sort of an int array. 
     *Upon completion, the elements of the array will be in increasing order.
     *@param data  the elements to be sorted.
     */
    public static void selectionSort(int[] data){
	int min = data[0]; //initialized mininum and its position
	int pos = 0;
	for (int n = 0;n < data.length - 1;n++) { //loops through without last
	    for (int m = n;m < data.length;m++) { //loops through to right of n
		if (min > data[m]) { //if a value to min's right is smaller
		    min = data[m]; //becomes a new minimum
		    pos = m; //records its position
		}
		else {
		    min = data[n]; //if all else is bigger, minimum is value at n
		    pos = n; //position of the minimum is n
		}
	    }
	    int temp = data[n]; //temporary variable to store original value
	    data[n] = min; //original value is replaced with minimum
	    data[pos] = temp; //original value is recorded at the place of minimum
	}
    }
    
    public static void main(String[]arg) {
	int[]a = {3,6,4,8,5};
	selectionSort(a);
	System.out.println(a[0]);	
	System.out.println(a[1]);
	System.out.println(a[2]);
	System.out.println(a[3]);
	System.out.println(a[4]);
    }
}

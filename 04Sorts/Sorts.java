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
	for (int n = 0;n < data.length - 1;n++) { //loops through without last
	    int min = data[n];
	    int pos = n;
	    for (int m = n + 1;m < data.length;m++) { //loops through to right of n
		if (min > data[m]) { //if a value to min's right is smaller
		    min = data[m]; //becomes a new minimum
		    pos = m; //records its position
		}
	    }
	    data[pos] = data[n];
	    data[n] = min;
	}
    }

    public static void insertionSort(int[] data) {
	int startPoint = 0;
	int n = 0;
	while (data[n] < data[n+1] && n < data.length - 1) {
	    startPoint++;
	    n++;
	}
	for (int u = startPoint;u < data.length;u++) {
	    for (int m = 0;m < data.length - 1;m++) {
		if (data[u] < data [m]) {
			int temp = data[u];
			data[u] = data[m];
			data[m] = temp;
		}
	    }
	}
    }

    public static void bubbleSort(int[] data) {
	int end = data.length;
	for (int x = 0;x < data.length;x++) {
	    for (int n = 1; n < end;n++) {
		if (data[n] < data[n - 1]) {
		    int temp = data[n];
		    data[n] = data[n - 1];
		    data[n-1] = temp;
		}
	    }
	    end--;
	}
    }
    
    public static void main(String[]arg) {
	int[]a = {3,6,4,2,5};
	bubbleSort(a);
	System.out.println(a[0]);	
	System.out.println(a[1]);
	System.out.println(a[2]);
	System.out.println(a[3]);
	System.out.println(a[4]);
    }
}

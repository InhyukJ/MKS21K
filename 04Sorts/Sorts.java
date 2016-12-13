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
	int min = data[0];
	for (int n = 0;n < data.length - 1;n++) {
	    for (int m = n;m < data.length;m++) {
		if (min > data[m]) {
		    min = data[m];
		    int temp = data[n]; //These should go in the first loop
		    data[n] = min;
		    data[m] = temp;
		}
	    }
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

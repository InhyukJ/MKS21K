public abstract class LibraryBook extends Book implements Comparable<LibraryBook> {
    private String callNumber;
    public LibraryBook (String author, String title, String ISBN, String callNumber) {
        super(author,title,ISBN);
	callNumber = callnumber;
    }

    public String getCallNumber() {
	String x = "";
	x += callNumber;
	return x;
    }

     public void setCallNumber(String callnumber) {
	callNumber = callnumber;
    }

    abstract void checkout(String patron, String due);
    
    abstract void returned();

    abstract String circulationStatus();

    public int compareTo(LibraryBook o) {
	return callNumber.compareTo(o.getCallNumber());
    }
    

    public String toString() {
	String a = super.toString();
	return a + ", " + circulationStatus() + ", " + callNumber;
    }
}

public class  CirculatingBook extends LibraryBook {
    private String currentHolder;
    private String dueDate;
    
     public CirculatingBook (String author, String title, String isbn, String callnumber) {
	 super(author,title,ISBN,callnumber);
	 currentHolder = "";
	 dueDate = "";
     }
    
    public String getCurrentHolder(){
	return currentHolder;
    }
    
    public String getDueDate() {
	return dueDate;
    }

    public void setCurrentHolder(String holder) {
	currentHolder = holder;
    }
    
    public void setDueDate(String duedate) {
	dueDate = duedate;
    }

    public void checkout(String patron, String date) {
	currentHolder = patron;
	dueDate = date;
    
    }

    public void returned() {
	currentHolder = "";
	dueDate = "";
    }
    
    public String circulationStatus() {
	if (currentHolder.equals("")) {
	    return "Book available on shelves";
	}
	else {
	    return ", " + currentHolder + ", " + dueDate;
	}

    }
    public String toString() {
	String a = super.toString();
	return a + ", " + currentHolder + ", " + dueDate;

    }
}

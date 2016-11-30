public class Books {
    private String author;
    private String title;
    private String ISBN;

    public Books() {
	author = "John Doe";
	title = "Untitled";
	ISBN = "1-2345-6789-0";
    }

    public Books(String name,String head,String code) {
	author = name;
	title = head;
	ISBN = code;
    }

    public String getAuthor() {
	return author;
    }
    public String getTitle() {
	return title;
    }
    public String getISBN() {
	return ISBN;
    }

    public void setAuthor(String name) {
	author = name;
    }
    public void setTitle(String head) {
	title = head;
    }
    public void setISBN(String code) {
	ISBN = code;
    }

    public String toString() {
	return "The book '" + getTitle() + "' by " + getAuthor() + " has ISBN of: " + getISBN() + ".";
    }

    public static void main(String[]args) {
	Books a = new Books();
	System.out.println(a);
    }
}

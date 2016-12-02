import java.util.Iterator;

public class superArrayIterator extends superArray implements Iterator<String> {
    superArray data;
    int size;

    public superArrayIterator() {
	super();
    }	

    public boolean hasNext() {
	

import java.util.Iterator;

public class superArrayIterator implements Iterator<String>  {

    private superArray ary;
    private int elementToLook;

    public superArrayIterator (superArray array){
	ary  = array;
	elementToLook = 0;
    }
    
    public boolean hasNext() {
	return elementToLook < ary.size();
    }

    public String next() {
	elementToLook++;
	return ary.get(elementToLook - 1);
	
    }

    public void remove() {
	throw new UnsupportedOperationException();
    }

}

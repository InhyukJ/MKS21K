import java.util.*;

public class Barcode implements Comparable<Barcode>{
    // instance variables
    private static String _zip;
    private static int _checkDigit;
    
    // constructors
    //precondtion: _zip.length() = 5 and zip contains only digits.
    //postcondition: throws a runtime exception zip is not the correct length
    //               or zip contains a non digit
    //               _zip and _checkDigit are initialized.
    public Barcode(String zip) {
	if (zip.length() != 5 || !digitCheck(zip)) {
	    throw new RuntimeException("Error: zip is too long, too short, or contains noninteger values.");
	}
	else {
	    _zip = zip;
	    _checkDigit = checkSum();
	}
    }

    private static boolean digitCheck(String zip) {
	boolean allNumbers = true;
	String digits = "0123456789";

	for (int n = 0;n < zip.length();n++) { //check from digits in zip instead
	    char digit = zip.charAt(n);
	    if (digits.indexOf(digit) == -1) {
		allNumbers = false;
	    }
	}
	return allNumbers;
    }
    
    // postcondition: Creates a copy of a bar code.
    public Barcode clone(){
	Barcode nBarcode = new Barcode(_zip);
	return nBarcode;
    }
    
    // postcondition: computes and returns the check sum for _zip
    private static int checkSum(){
	int sumZip = 0;
	int num = Integer.parseInt(_zip);
	while (num > 0) {
	    sumZip += num % 10;
	    num /= 10;
	}
	return sumZip % 10;
    }
    
    public static String toCode(String zip) {
	if (zip.length() != 5 || !digitCheck(zip)) {
	    throw new IllegalArgumentException("The zip is too long, too short, or contains nondigit characters.");
	}
	String[]reference = new String[10];
	reference[0] = "||:::"; //0
	reference[1] = ":::||"; //1
	reference[2] = "::|:|"; //2
	reference[3] = "::||:"; //3
	reference[4] = ":|::|"; //4
	reference[5] = ":|:|:"; //5
	reference[6] = ":||::"; //6
	reference[7] = "|:::|"; //7
	reference[8] = "|::|:"; //8
	reference[9] = "|:|::"; //9

	String code = "";
	for (int n = 0;n < zip.length();n++) {
	    int numAt = Integer.parseInt(zip.charAt(n) + "");
	    code += reference[numAt];
	}
	code += reference[_checkDigit];
	return "|" + code + "|";
    }

    public static String toZip(String code) {
	if (checkSum() < 0 || checkSum() > 10) {
	    throw new IllegalArgumentException("The sum of the digits are invalid.");
	}
	if (code.length() != 32) {
	    throw new IllegalArgumentException("The length of the barcode is not 32.");
	}
	if (code.charAt(0) != '|' || code.charAt(32) != '|') {
	    throw new IllegalArgumentException("The left and rightmost characters are not '|'.");
	}
	String[]reference = new String[10];
	reference[0] = "||:::"; //0
	reference[1] = ":::||"; //1
	reference[2] = "::|:|"; //2
	reference[3] = "::||:"; //3
	reference[4] = ":|::|"; //4
	reference[5] = ":|:|:"; //5
	reference[6] = ":||::"; //6
	reference[7] = "|:::|"; //7
	reference[8] = "|::|:"; //8
	reference[9] = "|:|::"; //9

	String zip = "";
	code = code.substring(1,code.length());
	for (int n = 0;n < 25;n += 5 ) {
	    for (int u = 0;u < 10;u++) {
		if (code.substring(n,n+5) == reference[u]) {
		    zip += u;
		}
		else {
		    throw new IllegalArgumentException("The encoded ints are invalid or non-barcode characters are used.");
		}
	    }
	}
	return zip;
    }
	
    //postcondition: format zip + check digit + Barcode 
    //ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
    public String toString(){
	return "The bar code of " + _zip + " with the check digit of " + _checkDigit + " is: " + toCode(_zip) + ".";
    }
    
    
    // postcondition: compares the zip + checkdigit, in numerical order. 
    public int compareTo(Barcode other){
	return _zip.compareTo(other._zip);
    }    
}

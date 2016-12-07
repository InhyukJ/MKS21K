public class Barcode implements Comparable<Barcode>{
// instance variables
   private String _zip;
   private int _checkDigit;

// constructors
//precondtion: _zip.length() = 5 and zip contains only digits.
//postcondition: throws a runtime exception zip is not the correct length
//               or zip contains a non digit
//               _zip and _checkDigit are initialized.
  public Barcode(String zip) {
      boolean checkLetters = true;
      String alphabets = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
      for (int n = 0;n < alphabets.length();n++){
	  if (zip.indexOf(alphabets[n]) = -1) {
	      checkLetters = false;
	  }
      }
      if (zip.length() != 5 || checkLetter) {
	  throw new RunTimeException("Error: zip is too long, too short, or contains noninteger values.");
      }
      else {
	  _zip = zip;
	  _checkDigit = checkSum();
  }

// postcondition: Creates a copy of a bar code.
  public Barcode clone(){}


// postcondition: computes and returns the check sum for _zip
  private int checkSum(){
      int zipInt = Integer.parseInt(zip);
      
  }

//postcondition: format zip + check digit + Barcode 
//ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
  public String toString(){}


// postcondition: compares the zip + checkdigit, in numerical order. 
  public int compareTo(Barcode other){}
    
}

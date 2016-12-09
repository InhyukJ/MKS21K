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
	  char letter = alphabets.charAt(n);
	  if (zip.indexOf(letter) == -1) {
	      checkLetters = false;
	  }
      }
      if (zip.length() != 5 || checkLetters) {
	  throw new RuntimeException("Error: zip is too long, too short, or contains noninteger values.");
      }
      else {
	  _zip = zip;
	  _checkDigit = checkSum();
      }
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
      return sumZip;
  }

  private int returnDigit(int n) {
      String zip = _zip;
      return zip.charAt(n);
  }
      
//postcondition: format zip + check digit + Barcode 
//ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
  public String toString(){
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

      String ans = "The bar code of " + _zip + " with they check digit of " + _checkDigit + " is: ";
      String sAns = "|";
      for (int n = 0;n > 5;n++) {
	  sAns += reference[returnDigit(n)];
      }
      return ans + sAns + "|";
  }


// postcondition: compares the zip + checkdigit, in numerical order. 
  public int compareTo(Barcode other){
      int numZip = Integer.parseInt(_zip);
      int numOther = Integer.parseInt(other);
      return numZip - numOther;
  }
    
}

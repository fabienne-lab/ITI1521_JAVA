public class Rational {

  private int numerator;
  private int denominator;

  // constructors

  public Rational(int numerator) {
    // Your code here
	  this(numerator,1);
	  reduce();
  }

  public Rational(int numerator, int denominator) {
    // Your code here
	  this.numerator=numerator;
	  this.denominator=denominator;
	  reduce();
  }

  // getters

  public int getNumerator() {
	  
     return  this.numerator;
  }

  public int getDenominator() {
	  
     return this.denominator;
  }

  // instance methods

  public Rational plus(Rational other) {
    // Your code here
	 Rational r;
	 r = new Rational ((this.numerator * other.denominator + other.numerator * this.denominator),(this.denominator*other.denominator));
  return r;
  }
  

  public static Rational plus(Rational a, Rational b) {
    // Your code here
	  // une ligne seulement
Rational t;
t = new Rational (( b.denominator*a.numerator + b.numerator * a.denominator),(a.denominator*b.denominator));
return t;
	 
  }

  // Transforms this number into its reduced form

  private void reduce()
  {
	  if (numerator==0) {
		  denominator=1;
	  }
	  else {
	  
	  int gc = gcd(Math.abs(numerator),Math.abs(denominator));
     numerator = numerator / gc;
      denominator =denominator / gc;}
  }


  // Euclid's algorithm for calculating the greatest common divisor
  private int gcd(int a, int b) {
    // Note that the loop below, as-is, will time out on negative inputs.
    // The gcd should always be a positive number.
    // Add code here to pre-process the inputs so this doesn't happen.
// verifier sil est negatif et * par -1
    while (a != b) {
      if (a > b) {
         a = a - b;
      } else {
         b = b - a;
      }
    }
    return a;
  }

  public int compareTo(Rational other) {
	 int retour;
	  if (((this.numerator * other.denominator  - this.denominator *other.numerator)/this.denominator*other.denominator)<0) {
retour=-1;
		 }
	  else if (((this.numerator * other.denominator -this.denominator *other.numerator)/other.denominator)==0) {
retour=0;
	  }
	  else {
retour =1;
	  }
	  
return retour;
  }

  public boolean equals(Rational other) { 
    // Your code here
	  boolean i =false;
	 
if(((this.numerator/this.denominator)-(other.numerator/other.denominator ))==0) {
		  i= true;
	  }
	 return i; 
  }

  public String toString() {
    String result = null;
    if (denominator == 1) {
        // Your code here
    	result+= numerator;
    } else {
        // Your code here
    	result+= numerator + "/" + denominator;
    }
    return result;
  }

public static void main (String [] args) {
	
	 Rational x = new Rational(1,2);
     Rational y = new Rational(3,4);
    
}
}
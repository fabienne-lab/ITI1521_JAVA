
class Combination {
	

	// Instance variables.
    // Remove this comment and declare your instance variables here

    // Constructor
	int first1;
	int second2;
	int third3;
    public Combination( int first, int second, int third ) {
        // Your code here
    	first1=first;
    	second2= second;
    	third3=  third;
    	
    			
 
    }

    // An instance method that compares this object
    // to other.
    // Always check that other is not null, i)
    // an error would occur if you tried to
    // access other.first if other was null, ii)
    // null is a valid argument, the method should
    // simply return false.

    public boolean equals( Combination other ) {
        // Put your code here and remove the line below
    	boolean truth=true;
    	if (first1==other.first1 && second2==other.second2 &&third3==other.third3){
        truth=true;	
    	}
    	else {
    		truth=false;
    	}
    	return truth;
    	
        
    }

    // Returns a String representation of this Combination.

    public String toString() {
        // Put your code here and remove the line below
    	String message;
    	message="";
    	message+=first1;
    	message+=':';
    	message+=second2;
    	message+=':';
    	message+=third3;
        return message;
    }
 


public static void main(String[]args) {
	Combination c1, c2, c3;
     
	 c1 = new Combination(1, 2, 3);
	 c2 = new Combination(1, 2, 3);
	 c3 = new Combination(3, 2, 1);
	 System.out.println(c1);
	 System.out.println(c1.equals(c2)) ;
	 System.out.println(c1.equals(c3));
}
}

import java.util.Arrays;

public class Utils {

  /**
   * Returns a copy of the array 'in' where each word occurring in the array
   * 'what' has been replaced by the word occurring in the same position
   * in the array 'with'.
   *
   * @param in an array of Strings;
   * @param what an array of words to be replaced;
   * @param with an array of replacement words;
   * @return a new array idententical to 'in' except that all the occurrences of words
   * found in 'what' have been replaced by the corresponding word from 'with'.
   */
  public static String[] findAndReplace(String[] in, String[] what, String[] with) {
    String[] out = null;
   
    // The new array to be returned
    boolean valid = true; // True if the pre-conditions are satistified

  	// Testing pre-conditions

  	if ( in == null || what == null || with == null ) {
  	    valid = false;
  	} 
  	    // more or less 16 lines missing
  	else if (with.length!=what.length || what==null  ) {
  			valid=false;}
  	else if ( what[0]==null || with[0]==null ) {
  		valid=false;
  	}
  	else {
  			valid=true;	
  	}
  	if ( valid ) {
  		out=new String [in.length];
  		out= new String [] {""};
  	    out = new String[ in.length ];
  	     for ( int i=0; i<in.length; i++ ) {
  	    	 int comper=0;
  		      //more or less 10 lines missing
  	    	for ( int j=0; j<what.length; j++ ) { 
  	    		if (in[i]==what[j]) {
  	  				 what[j]=with[j];
  	  				 out[i]=what[j];}	
  	    		else if (in[i]!=what[j]) {
  	    			comper+=1;
  	    			if (comper==what.length) {
  	    			out[i]=in[i];
  	    			
  	    		}
  	    	}

  	    }
  
  } 
  	}
  	
    // Returning a reference to the newly created array that
    // contains the same entries as 'in' except that all the
    // occurrences of words from 'what' have been replaced by
    // their corresponding occurrence from 'with'.

    return out;
  }

public static void main(String[]args) {

	 String[] in = { "hi" };
     String[] what = { null };
     String[] with = { null };
     String[] expected = null;
     String[] result = Utils.findAndReplace( in, what, with );
System.out.println("cest le result " +Arrays.toString(result));
}
}
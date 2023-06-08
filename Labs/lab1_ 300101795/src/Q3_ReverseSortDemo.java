import java.util.ArrayList;
public class Q3_ReverseSortDemo {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		char[] unorderedLetters;
	    unorderedLetters = new char[]{'b', 'm', 'z', 'a', 'u'};
	    reverseSort(unorderedLetters);
	    for (int i = 0 ; i < unorderedLetters.length; i++ )
	      System.out.print(unorderedLetters[i]);
	  }

	  //method that sorts a char array into its reverse alphabetical order
	  public static void reverseSort(char[] values){
		 
		 
		  int i;
		  int j;
		  int maximum;
		  char fin;
		  //on va set un maximum
		  //quand on parcours la boucle si ya un maximum plus grand alors sa valeur change
		  
		  
		        for (i = 0; i < values.length - 1; i++) {
		          maximum = i;
		          for (j = i + 1; j < values.length; j++) {
		           if (values[j]  >values[maximum]) {
		             maximum = j;
		           }
		         }
		  
		         fin = values[maximum];
		         values[maximum] = values[i];
		         values[i] = fin;
		  }

		 }        
	  }
			  	  
		  


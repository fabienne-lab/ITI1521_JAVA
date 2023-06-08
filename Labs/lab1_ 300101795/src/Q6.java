
import java.util.Arrays;
import java.util.Scanner;

public class Q6 {
	 

	public static void main(String[] args){

		    //your code here
		//on va scanner un par un les entree de lutilisateur pour les mettre dans un tableau 
		//cette metthode fait appelles aux autres fonctions et affiche le resutat.
		
		double [] lesNotes =new double [10];
		for (int i =0; i<lesNotes.length;i++) {
			System.out.println("entre la "+(i+1)+"eme notes");
			Scanner scan =new Scanner (System.in);
			lesNotes[i]=scan.nextDouble();
		}
	
	     System.out.println ( "la moyenne de la classe est:   "  +  calculateAverage( lesNotes));
	     System.out.println ( "la medianne de la classe est:   "  +  calculateMedian( lesNotes));
	     System.out.println("le nombre de personne qui ont echouer:  "  +  calculateNumberFailed(lesNotes) );
	     System.out.println("le nombre de personne qui ont reussi :  "  +  calculateNumberPassed(lesNotes) );
		 
}
		  

		  public static double calculateAverage(double[] notes){
		    //your code here
			  //on traverse la biucle on additionne les element de la liste puis on divise par la longeure de la liste
			
			  double total=0.0;
			  for (int i =0; i<notes.length; i++) {
				 total+=notes[i];
				 
			  }
			  double moyenne;
			  moyenne=(double) total/(notes.length);
			  
			  return (double) moyenne;
	  
			  
		  }

		  public static double calculateMedian(double[] notes){
		    //your code here
			  //pour ca on commence par ordonner la liste 
			  double medianne=0.0;
			  double fin;
			 
			  
			 
			  for (int i = 0; i < notes.length - 1; i++) {
				  int max=i;
		          
		          for (int j = i + 1; j < notes.length; j++) {
		           if (notes[j]  < notes[max]) {
		             max =j;
		           }
		         }
			  
		         fin = notes[max];
		         notes[max] = notes[i];
		         notes[i] = fin;}
			  //si la liste est paires on prendra les deux elements du milieux
			  if (notes.length%2==0) {
				  System.out.println("a liste est paire");
				  int pos=notes.length/2;
				  medianne=(notes[pos-1]+notes[pos])/2;
			  }
			  //si elle est impaire on prendra le seule element qui est au milieux de tout les nombres
			  else {
				  System.out.println("a liste est impaire");
				  int pos=notes.length/2;
				  System.out.println("a liste est impaire" + pos );
				  medianne=notes[pos];
			  }
			 
			  
			  
			  return medianne;}
		 

		  public static int calculateNumberFailed(double[] notes){
		    //your code here
			  //on initialise un compter pour compter le nombre detudiants qui ont reussi ou pas.
			  int compter;
			  compter=0;
			 
			  for (int i = 0; i < notes.length; i++) {
				  if (notes[i] < 50) {
					  compter+=1;
					  
					  
				  }
			  }
			  return compter;
		  }

		  public static int calculateNumberPassed(double[] notes){
			//your code here
			//on initialise un compter pour compter le nombre detudiants qui ont reussi ou pas.
			  int compter;
			  compter=0;
			 
			  for (int i = 0; i < notes.length; i++) {
				  if (notes[i] >= 50) {
					  compter+=1;
					  
					  
				  }
			  }
			  return compter;
		    
		  }

}


public class Q3_AverageDemo {
	
	
	public static void main(String[]args) {
		double []valuesArray;
		valuesArray = new double [] {100.0, 34.0, 72.0, 56.0,82.0, 67.0, 94.0};
		

		

		System.out.println("The average is: " + calculateAverage(valuesArray));
	}
	public static double calculateAverage(double[] array){
		
	    //your code here
	    double somme=0.0;
	    //la somme est zero par defaut en traversant la liste on ajoute chaque element sucessivement.
	    for(int i = 0; i < array.length; i++){
	         somme += array[i];
	      }
	     double result = (double) somme / array.length;
	    return result;
	  }
}


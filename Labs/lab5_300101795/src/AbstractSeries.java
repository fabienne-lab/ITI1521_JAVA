/*Donnez l'implémentation d'une classe abstraite nommée AbstractSeries.
 *  Elle doit réaliser l'interface Series. La classe implémente la méthode 
 *  take qui retourne un tableau contenant les prochaines k sommes partielles
 *  de cette série, où k est le paramètre formel de la méthode take.
 */

public abstract class AbstractSeries implements Series {

    public double[] take(int k) {

        // implement the method
    	double [] tableau=new double [k];
    	
       for (int i =0; i<k;i++) {
    	  tableau[i]= next();
    	   
       }
    return tableau;}
   
}
/*Donnez l'impl�mentation d'une classe abstraite nomm�e AbstractSeries.
 *  Elle doit r�aliser l'interface Series. La classe impl�mente la m�thode 
 *  take qui retourne un tableau contenant les prochaines k sommes partielles
 *  de cette s�rie, o� k est le param�tre formel de la m�thode take.
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
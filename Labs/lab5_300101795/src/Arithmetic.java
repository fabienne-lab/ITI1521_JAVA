public class Arithmetic extends AbstractSeries {

    // instance variables
	double r=1.0;
	double retour1=0.0;
	

    public   double next() {

        // implement the method
    	double retour;
    	retour=retour1+r;
    r+=1;
    retour1=retour;
   
        return retour;
    }
}

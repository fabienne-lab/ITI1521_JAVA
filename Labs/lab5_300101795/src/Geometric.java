public class Geometric extends AbstractSeries {

    // instance variables
	double r =0.5;
	int n=0;
	
	
	
    
    public double next() {

        // implement the method
    	double rtourG=0;
    	
    	rtourG=(1-Math.pow(r, n+1))/(1-r);
    	n+=1;
   return rtourG;
    
}}
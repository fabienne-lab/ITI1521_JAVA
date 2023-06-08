 class DoorLock {
	// Constant.
    public static final int MAX_NUMBER_OF_ATTEMPTS = 3;

    // Instance variables.
    private Combination combination;
    private boolean open;
    public boolean activated;
    private int numberOfAttempts;
    private Combination secret=new Combination(1,2,3);
   
    // Constructor.
    public DoorLock( Combination combination ) {
        // Your code here
    	int numberOfAttempts =0;
    	activated=true;
    	open=false;
    	Combination secret;
    	
    }

    // Access methods.

    public boolean isOpen() {
    	
    	if (open==true){
    		return true;
    	}else if (open==false){
    		return false;
    	}
    	
        return true;
    }

    public  boolean isActivated() {
    	
    	if (activated==false){
    		return false;
    	}else if   (activated==true) {
    		return true;}
    		
    	
    	
        return true;
    
    }
    // Notice that numberOfAttempts is compared to
    // MAX_NUMBER_OF_ATTEMPTS only when its value has been
    // incremented, Also, numberOfAttempts should be set to zero when
    // activated is false.  Problems related to the combined action of
    // these two variables have caused problems for some students.

    public boolean open( Combination combination ) {

        // Put your code here, then remove the line below.
    	
    	
    	Boolean openn;
    	
    	
    	
    		if(secret.equals(combination)==true&& isActivated()==true) {
    			System.out.println("la combinaison entree est corecte");
    			openn =true;
    			open =true;
    			numberOfAttempts=0;
    		}else {
    			System.out.println("la combinaison entree est incorecte");
    			openn=false;
    			numberOfAttempts+=1;
    			open=false;
    			activated=false;
    			
    		}
    	
    	if( numberOfAttempts==MAX_NUMBER_OF_ATTEMPTS) {
    		System.out.println("vous avez depasser le nombre limite de tentatative ");
    		open=false;
    		System.out.println("la bonne combinaison est   " + secret);
    	}
    	
        return openn;
    }

    public void activate( Combination c ) {
        // Put your code here, then remove this comment.
    	
    	for (int i=0; i<MAX_NUMBER_OF_ATTEMPTS; i++) {
    		if (secret.equals(c)==true) {
    			
    			activated=true;
    			
             
    		}else {
    			activated=false;
    		}
    		}
    			
    }
    

public static void main(String[]args) {
	 Combination c1 = new Combination(1, 2, 3);
     DoorLock lock = new DoorLock(c1);
     Combination c2 = new Combination(3, 2, 1);
     lock.open(c2);
     lock.open(c2);
     lock.open(c1);
     lock.activate(c1);
     boolean expected = true;
     boolean actual = lock.isActivated();
	  System.out.println("letat actuel du verro est activer?   "  +  lock.isActivated());
	
	
}
}
 
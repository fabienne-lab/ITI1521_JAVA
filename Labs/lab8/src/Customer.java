
public class Customer {
	private final int MAX_NUM_ITEMS=25;
	   private int arrivalTime;
	  public int numberOfItems;
	   private int initialNumberOfItem;
	   
	   public Customer(int arrivalTime ) {
		   this.arrivalTime=arrivalTime;
		   numberOfItems=(int)(Math.random()*MAX_NUM_ITEMS+1);
		   initialNumberOfItem=numberOfItems;
		  
		   
		  
	   }
	   /*int getArrivalTime() retourne l'heure d'arrivée ;
	int getNumberOfItems() retourne le nombre d'articles à traiter ;
	int getNumberOfServedItems() retourne le nombre total d'articles traités ;
	serve() décrémente de 1 le nombre d'articles de ce client.*/
	   public int getArrivalTime() {
		   return arrivalTime;
		   
	   }
	   
	   public int getNumberOfItems() {
		   return numberOfItems;
		 
	   }
	   
	   public int getNumberOfServedItems() {
		   return -(this.numberOfItems -this.initialNumberOfItem);
		   
	   }
	   
	   public void serve() {
		   this.numberOfItems=this.numberOfItems-1;
	
		   
	   }public static void main(String []args ) {
		   Customer someGuy = new Customer(5);
	        int beforeItems = someGuy.getNumberOfItems();
	        System.out.println(beforeItems);
	        someGuy.serve();
	   }
}

//sawadogo Marie Fabienne 
//300101795

public class Cashier {
   private Queue<Customer> queue;
  private  Customer currentCustomer;
  private  int totalCustomerWaitTime;
  private  int customersServed;
  private  int totalItemsServed;
   
   
   public Cashier ( ) {
	   this.customersServed=0;
	   this.totalItemsServed=0;
	   this.totalCustomerWaitTime=0;
	   queue = new ArrayQueue<Customer>();
	 
   }
   public void addCustomer (Customer c) {
	  //enqueue pour lajouter a la suite de la queue
	   queue.enqueue(c);
	   System.out.println("wdfghjkl");
   }
   public int getQueueSize() {
	   return queue.size();
	   
   }
   public void serveCustomers(int currentTime) {
	  
	   if (queue.isEmpty()&&currentCustomer==null) {
         return ;
       }if ( currentCustomer == null ){
    	   System.out.println("deuxieme if");
           currentCustomer = queue.dequeue();
           totalCustomerWaitTime += - currentCustomer.getArrivalTime()+currentTime;

           customersServed+=1;

       }
       System.out.println(currentCustomer);

       currentCustomer.serve();

       // apres scanner les article le currentCustomer est initialiser a null

       if ( currentCustomer.getNumberOfItems() == 0 ) {
    	   System.out.println("toiseieme if");
           totalItemsServed += currentCustomer.getNumberOfServedItems();
           currentCustomer = null;    
          
       }
   
   }
   public int getTotalCustomerWaitTime() {
	   return totalCustomerWaitTime;
   }
   public int getTotalItemsServed() {

	   return totalItemsServed ;
   }
   public int getTotalCustomersServed() {
	   return  customersServed;
   } public String toString() {

       String statistque = new String();

       statistque+="le total des client servis est  :  ";
       statistque+=( customersServed );
       statistque+=( "Le temps d'attente moyen est de : " );
       statistque+= ( totalCustomerWaitTime / customersServed );
       
       statistque+=( "La moyenne d'items scanner est de :  " );
       statistque+=( totalItemsServed / customersServed );
      

      

       return statistque.toString();
   }
   
 
}

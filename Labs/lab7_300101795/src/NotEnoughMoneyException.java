
public class NotEnoughMoneyException extends IllegalStateException {
	public  NotEnoughMoneyException	(){
		super("Cannot us a negative ya pas de voila  ");
		double f= getMissingAmount();
		 System.out.println("pas assez dargent");
	}
	
 public double getAmount () {
	 
	 
	 double e=Account.montant;
	 return e;
 }
 public double  getMissingAmount() {
	 System.out.println("la balance " + Account.balance);
	 System.out.println("le retrait  " + Account.getBalance());
	 double f=( Account.getBalance()-Account.montant);
	 if (f<Account.balance) {
	 try {
		 
	 }catch(Exception e) {
		 System.out.println("pas assez dargent");
	 }}System.out.println(-1*f);
	 return -1*f;
	 
 }
 /*getBalance qui retourne le montant du compte au moment de création de l’exception;
  * */

  public double getBalance() {
	  return Account.balance;
	  
  }
  /*L’exception devrait aussi invoquer son super constructeur afin que la méthode
   *  getMessage puisse donner un message
   *   indiquant que le montant ne peut pas être retiré.
   */
 
}

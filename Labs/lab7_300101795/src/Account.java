
public class Account   {
	static double balance;
	 static double montant;
	
	public Account() {
		
		balance =0.0000000000;
	}
	public double deposit(double montant) {
		balance =  balance +montant;
		System.out.println("votre balance est de "+ balance);
return balance;	}
	public double withdraw (double montantw) {
		 System.out.println(montantw);
		
		if (balance>montantw) {
		montant=montantw;
		balance =  (balance - montantw);
		System.out.println("votre balance est de "+ balance);
		return balance;}
		if(balance<montantw) {
		  montant=montantw;
			System.out.println("cest le else");
			throw new  NotEnoughMoneyException();
			
		}
		return 0.0;
	}
	public static double getBalance () {
		if (balance<=montant) {
			System.out.println("cest le else gete");
			
			
		}
		return balance;
		
		}
	

}

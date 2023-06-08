import static org.junit.Assert.assertEquals;

public class Exercise2{

    public static void main(String args[]) {
    	 Account account = new Account();
         account.deposit(10.37);
         try {
             account.withdraw(15.37);
         } catch(NotEnoughMoneyException e){
             assertEquals("Amount saved by the exception", 15.37, e.getAmount(),0.0001);
         }
         

}}
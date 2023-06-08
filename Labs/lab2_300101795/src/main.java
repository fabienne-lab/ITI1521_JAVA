
public class main {


  public static void  main(String[]args) {
	  SecutityAgency bob = new SecutityAgency();
	 Combination secret,f = null;
	int  MAX_NUMBER_OF_ATTEMPTS = 3;
	 Combination c1 = new Combination(1, 2, 3);
     DoorLock lock = new DoorLock(c1);
     Combination c2 = new Combination(3, 2, 1);
     lock.open(c2);
     DoorLock aLock = bob.getDoorLock();

     
     
  }

}

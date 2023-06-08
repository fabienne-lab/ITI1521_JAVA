import java.time.Duration;
import java.time.Instant;
import org.junit.Test;
import java.util.*;


public class devoir1 {
	String[] strings = adding() ;
	int Maximum = 1000000;
	String [] array= new String[Maximum];

	
	@Test
	public void linkedListAdd() throws Exception {
		   Watch watch = new Watch(); 	
		 
		  List<String> linkedList = new LinkedList<String>();
	        watch.start();
	        for (String string : strings)
	            linkedList.add(string);
	        watch.totalTime("Linked List add() = ");
        
        
        
     
    }
	 @Test
	 public void arrayAdd() {
	        Watch watch = new Watch();
	        for (int i = 0; i < Maximum; i++) {
	            array[i] = "ab";
	        }
	        watch.totalTime(" Array add() = ");
	        }
	 
	 @Test
	    public void arrayListAdd() {
	        Watch watch = new Watch();
	        List<String> arrayList = new ArrayList<String>(Maximum);

	        watch.start();
	        for (String string : strings)
	            arrayList.add(string);
	        watch.totalTime("Array List add() = ");
	        }
	
	 
	 
	 class Watch {
	        private long startTime;
	        private long endTime;

	        public void start() {
	            startTime =  System.nanoTime();
	        }

	        private void stop() {
	            endTime =  System.nanoTime();
	        }

	        public void totalTime(String s) {
	            stop();
	            System.out.println(s + (endTime - startTime));
	        }
	    }


	    
	
	    private String[] adding() {
	        String[] strings = new String[Maximum];
	        Boolean result = Boolean.TRUE;
	        for (int i = 0; i < Maximum; i++) {
	            strings[i] = getString(result, i);
	            result = !result;
	        }
	        return strings;
	    }

	    private String getString(Boolean result, int i) {
	        return String.valueOf(result) + i + String.valueOf(!result);
	    }

	 public  void main(String args[]) throws Exception{
		 linkedListAdd();
		 
	      LinkedList<String> list=new LinkedList<String>();

	      //Adding elements to the Linked list
	      list.add("Steve");
	      list.add("Carl");
	      list.add("Raj");
	      list.add("Negan");
	      list.add("Rick");

}
}


@SuppressWarnings("serial")
public class FullStackException extends Exception {
  public FullStackException() {
    super("Full stack.");
    if (ArrayStack.top==1) {
   	 try {
   		 
   	 }catch(Exception e) {
   		 System.out.println("pas assez dargent");
   	 }}
  }}
import static org.junit.Assert.assertEquals;

import java.util.EmptyStackException;

public class DynamicArrayStack<E> implements Stack<E> {

  // Instance variables

  private E[] elems;  // Used to store the elements of this ArrayStack
  private int top;    // Designates the first free cell
  private static final int DEFAULT_INC = 25;   //Used to store default increment / decrement

  @SuppressWarnings( "unchecked" )

  // Constructor
  public DynamicArrayStack( int capacity ) {
    // Your code here.
	  if (capacity<DEFAULT_INC ) {
		  capacity=DEFAULT_INC;
	  }
	  
	  elems = (E[]) new Object[ capacity ];
      top = 0;
      }
      

  // Gets current capacity of the array
  public int getCapacity() {
    return elems.length;
  }

  // Returns true if this DynamicArrayStack is empty
  public boolean isEmpty() {
    return ( top == 0 );
  }

  // Returns the top element of this ArrayStack without removing it
  public E peek() {
	  if (top==0) {
  		throw new EmptyStackException();
  	}
    return elems[ top-1 ];
  }

  @SuppressWarnings( "unchecked" )

  // Removes and returns the top element of this stack
  public E pop() {
    // Your code here.
	  if(top==0) {
  		throw new EmptyStackException();	
  	}
	  E saved = elems[ --top ];

      elems[ top ] = null;

      if(top<=getCapacity()-25 && (getCapacity()-25)>=DEFAULT_INC){
    		 E[] newElems= (E[]) new Object [getCapacity()-25];
    	        for(int i=0; i<top;i++){
    	          newElems[i]= elems[i];
    	        }
    	        elems=newElems;
      }
      return saved;
  }

  @SuppressWarnings( "unchecked" )

  // Puts the element onto the top of this stack.
  public void push( E element ) {
    // Your code here.
	  if(top<getCapacity()){
		  elems[ top++ ] = element;
	  }
	  
	  else {
		  E [] newElems= (E[]) new Object [getCapacity()+25];
		  for(int i=0; i<getCapacity(); i++) {
			  newElems[i]=elems[i];
		  }
		  elems=newElems;
		  elems[top++]=element;
		  
	  }
  }

  @SuppressWarnings( "unchecked" )

  public void clear() {
    // Your code here.
	  elems= (E[]) new Object[DEFAULT_INC];
	  this.top=0;
	  
  }
  public static void main (String[] args) {
      DynamicArrayStack<Integer> myStack = new DynamicArrayStack<Integer>(25);
      for (int i = 0; i < 5; i++) {
        myStack.push(i);
      }
      myStack.clear();
      
  }
}
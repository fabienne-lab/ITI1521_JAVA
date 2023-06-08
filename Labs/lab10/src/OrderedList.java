import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.LinkedList;

public class OrderedList implements OrderedStructure {

    // Implementation of the doubly linked nodes (nested-class)

    private static class Node {

      	private Comparable<String> value;
      	private Node previous;
      	private Node next;

       private Node ( Comparable<String> value, Node previous, Node next ) {
      	    this.value = value;
      	    this.previous = previous;
      	    this.next = next;
      	}

		
    }

    // Instance variables

    private Node head;
    private Node header;
    private Node tail;
  
    int c;
   
    
    // Representation of the empty list.
    
   
    //LinkedList<LinkedList<TicTacToe>> allGames

    public OrderedList() {
    	 
    	 head = new Node(null, null, null);
    	 header=new Node(null, null, null);
    	 tail=new Node(null, null, null);
         head.next=head;
         head.previous=head;
         c=0;
         
        
         
    	
    
    	
        // Your code here.
    }
    

    // Calculates the size of the list

    public int size() {
    	 
    	    return c;
    }


    public Object get( int pos ) {
        // Remove line below and add your implementation.
    	  Node found = head.next;
    	  Node tmp=head;

          if(size()==0)
          {
        	  throw new IndexOutOfBoundsException();
          }
          if(pos<0) {
        	  throw new IndexOutOfBoundsException();
          }

          if(pos == 0) {
              return head.next.value;}
         

          for(int i = 1; i <= c; i++)
          { 
              if(i != pos) {
            	 
                
                  found = found.next;
                 
                 
              }if(i==pos) {
            	 
            	  found = found.next;
            	  
            	 break;
              }
          }

          return found.value;
       
    }

    // Adding an element while preserving the order

    public boolean add( Comparable<String> o ) {
        // Remove line below and add your implementation.
    	 Node current;
    	 String oj=(String)o;
    	
    	Node newNode = new Node(oj,null,null);
    	
    	if(o==null) {
    		throw new IllegalArgumentException();
    	}
   	if (head.next==head) {
    		
    		
    		  //the next of the one is now the head
    		  //make the previous node null
    		  head.next=newNode;
    		  head.next.value=newNode.value;
    		  header=head.next;
    		 c++;
    		  return true;
    		
    		  } 
    	    else if( head.next.value.compareTo( (String) oj) >=0) {
    			
    	    	          
    			  newNode.next = head.next; 
                  newNode.next.previous = newNode; 
                
                  head.next = newNode; 
                  head.next.value=newNode.value;
                 
                 
    	                 c++;
    	                 return true;
    	             } 

    	             else 
    	             { 
    	            	 c++;
    	            	
    	                 current = head.next;
    	               

    	                 // locate the node after which the new node  
    	                 // is to be inserted  
    	                 while ( current.next!=null && current.next.value.compareTo(oj)<0)  
    	                     current = current.next;
    	                
    	                   newNode.next = current.next;

    	                 // if the new node is not inserted  
    	                 // at the end of the list 
    	                 if (current.next != null) { 
    	                	newNode.next.value= current.next.value;
    	                     newNode.next.previous = newNode; 
    	                    
    	                    
    	                   
    	                     current.next = newNode;  
    	                     newNode.previous = current; 
    	                     this.tail=newNode;
    
    	                 return true;
    	               
    	             } else {
    	            	 this.tail=newNode;
    	            	 head.next.next=newNode;
    	            	 newNode.next=head.next;
    	            	 }
    	             }
  
      return false;
    }

    //Removes one item from the position pos.

    public void remove( int pos ) {
      // Remove line below and add your implementation.
    	if (pos > size() || pos< 0||size()==0) {
    		
    	     throw new IndexOutOfBoundsException();
    	    }
    	if (this.head.next.value.equals((String)get(pos))) {
    		
    		Node save=head.next;// removing head
    		
            this.head = this.head.next;
            this.head.next.previous=(this.tail);
            c--;            
    
            return;}
    	 if (this.tail.value.equals((String)get(pos))) { 
    		// removing tail
    	        this.tail = this.tail.previous;
    	        this.head.next.next=(null);
    	        c--;
    	       
    	        return;
    	    }

    	    for (Node current = this.head; current != null; current = current.next) {
    	        if (current.value.equals(get(pos))) {
    	            Node previous = current.previous;
    	            Node next = current.next;
    	            previous.next=(next);
    	            next.previous=(previous);
    	           
    	            return;
    	        }}
    
    }
 
    public void merge( OrderedList other ) {
      // Remove line below and add your implementation.
    	Node ci=tail;
    	
    	 while(true)  
    	    { 
    	          
    	        /* if either list runs out,  
    	        use the other list */
    	        if(this.head.next == null) 
    	        { 
    	            tail.next = other.head.next; 
    	            break; 
    	        } 
    	        if(other.head.next == null) 
    	        { 
    	            tail.next =this.head.next; 
    	            break; 
    	        } 
    	          
    	        /* Compare the data of the two 
    	        lists whichever lists' data is  
    	        smaller, append it into tail and 
    	        advance the head to the next Node 
    	        
    	        
    	        */
    	        this.tail=head.next.next;
     	       other.tail=other.head.next.next;
     	      Node fa=other.tail;
    	        
    	        
    	        Node cu=head.next;
    	        if(head.next.value.compareTo((String) other.head.next.value) <= 0) {
    	        	other.head.next.next=this.tail;
    	        	this.head.next.next.next=this.head.next;
    	        	
    	            this.head.next.next = other.head.next;
    	        
    	        }  
    	        else
    	        { 
    	            this.tail.next = other.head.next; 
    	            other.head.next= other.head.next.next	; 
    	        } 
    	        
    	        ci = cu.next; 
    	        cu=cu.next;
    	        this.tail=cu;
    	        if(cu.value==other.head.next.value) {
    	        	
    	        	this.tail=fa;
    	        	this.head.next.next.next.next=fa;
    	        	break;
    	        }
    	    } 
          
          c+=other.size();
    }public static void main (String[]args){
int grade=0;
 try{
            OrderedList list1 = new OrderedList();
            OrderedList list2 = new OrderedList();

            list1.add("C");
            list1.add("A");
           System.out.println("position de A"+ list1.get(0));
           System.out.println("position de C"+ list1.get(1));

            list2.add("D");
            list2.add("B");
            System.out.println("position de B"+ list2.get(0));
            System.out.println("position de D"+ list2.get(1));

            list1.merge(list2);

            System.out.println("Incorrect size of the list after merging list " + list1.size());
            grade += 0.5;

            System.out.println("The merged list should not change size "+ list2.size());
            grade += 0.5;

            System.out.println("First element in the ordered list after merging  " + list1.get(0));
            grade += 0.5;

            System.out.println("Second element in the ordered list after merging (should be from the merged list)B" + list1.get(1));
            grade += 0.5;

            System.out.println("Third element in the ordered list after merging (should be from the first list) C " +  list1.get(2));
            grade += 0.5;

            System.out.println("Forth element in the ordered list after merging (should be from the merged list)" + list1.get(3));
            grade += 0.5;
        } catch (Exception e){
            e.printStackTrace();
            fail(e.toString());
        }
    }
    

}
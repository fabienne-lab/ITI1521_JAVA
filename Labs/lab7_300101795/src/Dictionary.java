import static org.junit.Assert.fail;

import java.util.NoSuchElementException;

public class Dictionary implements Map<String, Integer> {

    private final static int INITIAL_CAPACITY = 10;
    private final static int INCREMENT = 5;
    private int count;

    private Pair[] elems;

    public int getCount() {
      return count;
    }

    public int getCapacity() {
      return elems.length;
    }

    public Dictionary() {
        /* Your code here */
    	elems =new Pair[INITIAL_CAPACITY] ;
    	this.count=0;
    }

    @Override
    public void put(String key, Integer value) {
    	
        /* Your code here */

    	  if (key == null || value==null) {
    	    throw new NullPointerException("the key is null");
    	  }

    	  if (count == elems.length) {
    	    increaseCapacity();
    	  }

    	  // Similarly to the array-based implementation
    	  // of a stack, adding elements at the end
    	  elems[count] = new Pair(key, value);
    	  count++;
    	
    }

    private void increaseCapacity() {
        /* Your code here.  Use this in put() where necessary. */
    	if(count==getCapacity()) {
    		Pair [] elems1=new Pair [getCapacity()+INCREMENT];
    		for (int i=0;i<getCapacity();i++) {
    			elems1 [i]=elems[i];
    		}
    		elems=elems1;
    		
    	}
    	
    }

    @Override
    public boolean contains(String key) {
        /* Your code here. */
    	if(key==null) {
    		throw new NullPointerException();
    	 }
    	 if(this.count==0) {
    		 return false; 
    	 }
    	for(int i =0; i<count ;i++) {
    		if (key==null) {
    			throw new NullPointerException() ;
    			
    		}else if (elems[i].getKey().equals(key))  {
    			
    			return true;
    		}
    	}
    	return false;
    }

    @Override
    public Integer get(String key) {
        /* Your code here. */
    	if(key==null) {
    		throw new NullPointerException();
    	}
    	
    	if(this.count==0) {
    	throw new NoSuchElementException();	
    	}
    	for(int i =count-1; i>=0 ;i--) {
    		if (elems[i].getKey().equals(key)) {
    			return elems[i].getValue();}
    		
    		}int c=0;
    		int k=0;
    		for(int j =count-1; j>=0 ;j--) {
    			if (elems[j].getKey()!=key) {
    				c+=1;
    			}
    			else if (elems[j].getKey()==null) {
    				k+=1;
    			}
    		}if (c==this.count) {
    			throw new NoSuchElementException();
    		}else if (k==this.count) {
    			throw new NoSuchElementException();
    		}
    	
    	return null;
    	
    }

    @Override
    public void replace(String key, Integer value) {
        /* Your code here. */
    	 System.out.println("sdfghjk");
    	
    	 if( key==null) {
    		 throw new NullPointerException(); 
    	 } if( value==null) {
  			throw new NullPointerException();
  		} if(this.count==0) {
   		 throw new NoSuchElementException(); 
   	 }int c = 0;
    	for(int i =count-1; i>=0 ;i--) {
    		System.out.println(key+ getCapacity()+elems[i]);
    		if(elems[i].getKey()!=key) {
    			c+=1;
    		}
     	
    		 if (elems[i].getKey().equals(key)) {
    			elems[i].setValue(value);
    			break;
    		}
    }if(c==count) {
    	throw new NoSuchElementException();
    }
    	}

    @Override
    public Integer remove(String key) {
        /* Your code here. */
    	if(key==null) {
    		throw new NullPointerException();
    	}
    	 if(this.count==0) {
    		 throw new NoSuchElementException(); 
    	 }
    	int i;
    	int k=0;
    	for(i =count-1; i>=0 ;i--) {
    		if (elems[i].getKey().equals(key)) {
    			break;
    		}if(elems[i].getKey()!=key) {
    			k+=1;
    			
    		}
    	}if(k==count) {
    		throw new NoSuchElementException();
    	}
    	Integer saved= elems[i].getValue();
    	elems[i]=null;
    	for(int y=i;y<count-1;y++) {
    		elems[y]=elems[y+1];
    	}
    	count--;
    	return saved;
    }

    @Override
    public String toString() {
      String res;
      res = "Dictionary: {elems = [";
      for (int i = count-1; i >= 0 ; i--) {
          res += elems[i];
          if(i > 0) {
              res += ", ";
          }
      }
      return res +"]}";
    }
    public static void main (String []args) {
    	
    	 Dictionary dict = new Dictionary();
         try{
             dict.replace("V", 1);
            System.out.println("Replacing an inexistent key should raise NoSuchElementException");
         } catch (NoSuchElementException e){
        	 System.out.println("atrttg");
         } catch(Exception e){
        	 System.out.println("Exception raised during test: " + e.toString());
         }
     }

}
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
    	Pair premier = new Pair(key, value);
    	increaseCapacity();
    	elems [count++]=premier;}

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
    	for(int i =0; i<count ;i++) {
    		if (elems[i].getKey().equals(key)) {
    			return true;
    			
    		}
    	}
    	return false;
    }

    @Override
    public Integer get(String key) {
        /* Your code here. */
    	for(int i =count-1; i>=0 ;i--) {
    		if (elems[i].getKey().equals(key)) {
    			return elems[i].getValue();
    		}
    	}
    	return null;
    	
    }

    @Override
    public void replace(String key, Integer value) {
        /* Your code here. */
    	for(int i =count-1; i>=0 ;i--) {
    		if (elems[i].getKey().equals(key)) {
    			elems[i].setValue(value);
    			break;
    		}
    }}

    @Override
    public Integer remove(String key) {
        /* Your code here. */
    	int i;
    	for(i =count-1; i>=0 ;i--) {
    		if (elems[i].getKey().equals(key)) {
    			break;
    		}
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

}
public interface Map< K, V> {
	 	public abstract void put(String key, Integer value) ;
	   
	    public abstract boolean  contains(String key) ;
	   
	    public abstract Integer get(String key) ;
	   
	    public abstract void replace (String key, Integer value);
	  
	    public abstract Integer remove(String key) ;
	   

}
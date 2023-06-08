import java.util.Calendar;
import java.util.Date;



public class Post implements Likeable, Comparable<Post> {

    protected int likes;
    private Date timeStamp;
    private String userName;

    public Post(String userName) {

      // YOUR CODE HERE
    	this.userName=userName;
    	this.likes=0;
    	timeStamp =java.util.Calendar.getInstance().getTime();

    }

    public String getUserName() {
	     return userName;
    }

    public Date getTimeStamp() {
     
	     return timeStamp;
    }
   
    public void like() {
    	this.likes++;
    	
    }
    public int  getLikes() {
    	return likes;
    }

    // Implement the methods required by the interface Likeable.
    // This file will not compile unless they are present with the correct name and signature.

    public String toString() {
    	String str = new String();
    	str = getClass().getName() + ": " + timeStamp + ", " + userName + ", likes = " + likes;
    	return  str;
    }

  	public int compareTo(Post other) {

  		// YOUR CODE HERE
  	
  	    if (this.timeStamp.before(other.timeStamp)) {
  	  	
  	    	return -1;
  	    	
  	    }
  	    else if (this.timeStamp.equals(other.timeStamp)) {
  	  	
  	    	return 0;
  	    }
  		
  		return 1;

  	}


	public boolean isPopular() {

  		// YOUR CODE HERE
  		if( likes<100) {
  			return false;  		}
  		else if( likes>=100) {
  			return true;
  		}
  		
return true;
  	}

}

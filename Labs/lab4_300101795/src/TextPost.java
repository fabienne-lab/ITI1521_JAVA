
public class TextPost extends Post {

  private String message;

  public TextPost(String userName, String message) {

    // YOUR CODE HERE
	  super(userName);
	  this.message=message;

  }

  public String getMessage() {
    return message;
  }

  public String toString() {
    String str = new String();
    str = super.toString() + ", " + message;
    return  str;
  }

  public boolean isPopular() {

    // YOUR CODE HERE
	  if( likes<50) {
			return false;  		}
		else if( likes>=50) {
			return true;
		}
		
return true;

  }

}
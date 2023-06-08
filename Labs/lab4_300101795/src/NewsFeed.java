import static org.junit.Assert.assertEquals;

/* *
 * Use static array for NewsFeed
 * with constant MAX_SIZE
 * */

public class NewsFeed {

  private Post[] messages;
  private int size;
  public static final int MAX_SIZE = 25;



  public NewsFeed() {

    // YOUR CODE HERE
	messages=new Post[MAX_SIZE];
	size=0;

  }

  public void add(Post message) {
	

    // YOUR CODE HERE
	  if (size<25) {
	  this.messages[size]=message;
	  this.size++;}

  }

  public Post get(int index) {
    return messages[index];
  }

  public int size() {
    return size;
  }

  public void sort(){
    int i, j, argMin;
    Post tmp;
    for (i = 0; i < size - 1; i++) {
      argMin = i;
      for (j = i + 1; j < size(); j++) {
        if (messages[j].compareTo(messages[argMin]) < 0) {
          argMin = j;
        }
      }

      tmp = messages[argMin];
      messages[argMin] = messages[i];
      messages[i] = tmp;
    }

  }

  public NewsFeed getPhotoPost(){

    // YOUR CODE HERE
	 
	
	
	 NewsFeed te = new NewsFeed();

	 
	
	 
	  for (int i =0; i<size; i++) {
		 
		if (this.messages[i].getClass().getName().equals("PhotoPost")) {
			
			te.add(messages[i]);
	
		;}
	  }

	  return te;

  }

  public NewsFeed plus(NewsFeed other){

    // YOUR CODE HERE
	  NewsFeed toi= new NewsFeed();
	  
	 
	 if((this.size)+(other.size)<=MAX_SIZE){
	 for(int i =0; i<this.size; i++) {
		 toi.add(this.messages[i]);

	 }
	 for(int j =0; j<other.size; j++) {
		 toi.add(other.messages[j]);}}
	 toi.sort();
	return toi;  

  }
 

}
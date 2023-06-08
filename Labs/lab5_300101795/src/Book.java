import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Book {

    /* Your variables declaration here
     * Une variable d'instance author de type String;
Une variable d'instance title de type String;
Une variable d'instance year de type int (l'année de publication du livre);
Un contructeur Book(String author, String title, int year), qui reçoit en paramètre l'auteur, le titre, l'année de publication;
Une méthode toString(), qui retourne une chaîne de caractère ayant le format suivant: «author: title (year);
Une méthode equals(Object o).
     */
	private String author;
	private int year;
	private String title;

    public Book (String author, String title, int year) {
        // Your code here
    	this.author=author;
    	this.year=year;
    	this.title=title;
    }

    public String getAuthor() {
        // Your code here
    	return author;
    }

    public String getTitle() {
        // Your code here
    	return title;
    }

    public int getYear() {
        // Your code here
    	return year;
    }

    public boolean equals(Object other) {
        // Your code here
    	 if(other==null) {
    		 
   		  return false;
   	  }
   	  if(this.getClass()!=other.getClass()) {
   		
   		return false;  
   	  }
   	 Book other1 = (Book)other;
   	if(this.title==(other1.title)&&this.author==(other1.author)&&this.year==(other1.year)) {
   		return true;
   	}else if(this.title==null&&(other1.title!=null)||this.author==null&&(other1.author!=null)) {
   		return false;
   	}
 
   	if((title.equals(other1.title)||this.title==(other1.title) )&&  (this.author==(other1.author)||author.equals(other1.author)) && this.year==(other1.year)){
   		return true;
   	}else if (this.title!=(other1.title)) {
   		return false;
   	}
   	
	   
	   	 
	   	 
	   	 
   	 return false;
    }

    public String toString() {
        // Your code here
    	String informationDuLivre="";
    	informationDuLivre+=" auteur : ";
    	informationDuLivre+=this.author;
    	informationDuLivre+="titre : ";
    	informationDuLivre+=this.title;
    	informationDuLivre+="a ete publier en ";
    	informationDuLivre+=this.year;
    	return informationDuLivre;
    	
    }
    public static  void main(String [] args) { 
    	  Book myBook = new Book("Shakespeare", "Hamlet", 1600);
          Book myBook2 = new Book("Shakespeare", null, 1600);
          System.out.println( myBook2.equals(myBook));

       
      }
}
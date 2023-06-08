import java.util.Comparator;

public  class BookComparator implements Comparator<Book> {

    // Implement the comparator method for books.

	
	 public int compare(Book b1, Book b2) {
		 
		int prnomComp = b1.getAuthor().compareTo(b2.getAuthor());
		if (prnomComp == 0) {
			
		     prnomComp= b1.getTitle().compareTo(b2.getTitle());
		     if(prnomComp == 0) {
			       prnomComp= Integer.compare(b1.getYear(),b2.getYear());}}
		
		return  prnomComp ; }
	}
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*void addBook (Book b): 
 * ajoute un livre à la bibliothèque (ajout d'un objet de la classe Book à l'aide de 
 * la méthode addBook de l'objet de la classe Library);
void sort(): trie les éléments à l'aide d'un objet Comparator;
void printLibrary(): affiche tous les livres dans l'ordre actuel de la liste.*/

public class Library {

  ArrayList<Book> library = new ArrayList<Book>();
   
    public Book getBook(int i) {
      return library.get(i);
    }

    public int getSize() {
      return library.size();
    }

    public void addBook (Book b) {
        // Your code here
    	library.add(b);
    	
    }

    public void sort() {
        // Your code here
    	
    	printLibrary();
    	
    	library.sort(new BookComparator());
    	
    	
    	
    	
}


    public void printLibrary() {
        // Your code here
    	for(int i=0; i<library.size();i++) {
    		System.out.println(library.get(i));
    	}
    }
    public static  void main(String [] args) { 
    	  Book myBook = new Book("Shakespeare", "Hamlet", 1600);
          Book myBook2 = new Book("Shakespeare", "A Midsummer Night's Dream", 1600);
          Book myBook3 = new Book("Shakespeare", "Hamlet", 1599);
          Book myBook4 = new Book("Ienaga", "The Pacific War", 1968);
          Book myBook5 = new Book("Coutu", "Le québécois en 10 leçons", 2014);

          Library myLibrary = new Library();
          myLibrary.addBook(myBook);
          myLibrary.addBook(myBook2);
          myLibrary.addBook(myBook3);
          myLibrary.addBook(myBook4);
          myLibrary.addBook(myBook5);

          myLibrary.sort();
    }
}
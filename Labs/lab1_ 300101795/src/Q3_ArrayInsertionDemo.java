

import java.util.ArrayList;
import java.util.Arrays;
public class Q3_ArrayInsertionDemo {
	 public static int[] insertIntoArray(int[] beforeArray, int indexToInsert, int valueToInsert){
		    // Your code here
		 //on va cree un afterArray qui sera une liste de longueure plus 1
		 //on cree une autre liste Array qui aura les meme valeure que beforeArray
		int []array;
		array=new int[beforeArray.length];
		int [] afterArray;
		afterArray= new int [beforeArray.length +1];
		 for(int i = 0; i < beforeArray.length; i++){
			 array[i]=beforeArray[i];
		 }
		 
		
		 for(int i = 0; i <= 2; i++){
			 afterArray[i]=beforeArray[i];
		 }
		
		     beforeArray[3] = 7;
		 
			 beforeArray[indexToInsert]=valueToInsert;
			 afterArray[3]=beforeArray[3];

			 for(int i = 4; i <= 6; i++){
				 
				 afterArray[i]=array[i-1];}
		
		 return afterArray;
		 }
		 

		  public static void main(String[] args){ 
		    // Your code here
			 int [] beforeArray;
			 beforeArray= new int [] {1, 5, 4, 7, 9,6 };
			 
			 int indexToInsert;
			 indexToInsert= 3;
			 int valueToInsert;
			 valueToInsert=15;
			 System.out.println("Array before insertion:");
			 Arrays.stream(beforeArray).forEach(System.out::println);
			 
			 System.out.println("Array after insertion of 15 at position 3:");
			 Arrays.stream(insertIntoArray(beforeArray,indexToInsert,valueToInsert)).forEach(System.out::println);
		  }
}
			 

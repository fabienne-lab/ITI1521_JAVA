import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Transformer {

  /**
   * An static enum  for the types of
   * allowable transformations
   */
  public static enum Type {
    UNKNOWN,
    IDENTITY,
    ROTATION,
    VERTICAL_SYMMETRY,
    HORIZONAL_SYMMETRY,
  }

  /**
   * The list of all allowable symmetries for a n (numRows) x m (numColumns) board
   * by applying the following transformations
   * @param numRows The number of rows in your board
   * @param numColumns The number of columns in your board
   * @return All rotations for a symmetric board
   */
  public static Type[] symmetricTransformations(int numRows, int numColumns) {

    // -------------------
    // IMPLEMENT THIS METHOD
    // TODO: Based on the dimensions there are different allowable transformations
    // HINT: This method will help you determine the `allowable` tranformations
    //       in your TicTacToe game
    // -------------------

    // don't forget to delete this line of code!!!
	  Transformation.ID,Transformation.ROT,Transformation.ROT,
 	 Transformation.ROT,Transformation.HSYM,Transformation.ROT,
 	 Transformation.ROT,Transformation.ROT;

    return null;
  }

  /**
   * Applies the transformation specified as parameter
   * to transformedBoard
   *
   * If the transformation was successful return true, if not return false;
   */
  public static boolean transform(Type transformation, int numRows, int numColumns, int[] board) {
	  switch(transformation) {
	   case IDENTITY:
	     return identity(numRows, numColumns, board);
	   case ROTATION:
	     return rotate90(numRows, numColumns, board);
	   case VERTICAL_SYMMETRY:
	     return verticalFlip(numRows, numColumns, board);
	   case HORIZONAL_SYMMETRY:
	     return horizontalFlip(numRows, numColumns, board);
	   default:
	     return false;
	   }
	  }


  /**
   * Create the identity board, which means do not flip the board at all.
   * Here we ignore the current values within the provided board and
   * populate it with its index value.
   *
   * If we consider a 3x3 board, the identity board would be
   *
   * 0 | 1 | 2
   * ----------
   * 3 | 4 | 5
   * ----------
   * 6 | 7 | 8
   *
   *
   * If the transformation was successful return true, if not return false;
   */
  public static boolean identity(int numRows, int numColumns, int[] board) {

	  
		  if(board.length!=(numRows*numColumns)) {
		      return false;}
		  else {
		  for(int i=0;i<board.length;i++) {
		         board[i]=i;
		        
		  }

		    
		   }
		  return true;}
  

  /**
   * Flip a board horizontally based on the n (numRows) x m (numColumns) grid
   * editing the provided board in place.
   *
   * If we consider a 3x3 board
   *
   * 1 | 2 | 3
   * ----------
   * 4 | 5 | 6
   * ----------
   * 7 | 8 | 9
   *
   * The updated horizontally flipped board would be
   *
   * 7 | 8 | 9
   * ----------
   * 4 | 5 | 6
   * ----------
   * 1 | 2 | 3
   *
   * If the transformation was successful return true, if not return false;
   */
  public static boolean horizontalFlip(int numRows, int numColumns, int[] board) {

	  if(board==null) {
		  return false;
	  }
	  if(numRows<1 || numColumns<1) {
		  return false;
	  }
	  if(board.length!=numColumns*numRows) {
		  return false;
	  }
	  for(int i =0; i<numRows/2;i++) {
		for (int j =0 ; j< numColumns; j++)  {
		int sauve = board[(numRows-1-i)*numColumns+j];
		board [(numRows-1-i)*numColumns+j]=board[numColumns*i+j];
		board[numColumns*i+j]=sauve;
		}
	  }
    return true;
  }

 /**
   * Flip a board vertically based on the n (numRows) x m (numColumns) grid
   * editing the provided board in place.
   *
   * If we consider a 3x3 board
   *
   * 1 | 2 | 3
   * ----------
   * 4 | 5 | 6
   * ----------
   * 7 | 8 | 9
   *
   * The updated vertically flipped board would be
   *
   * 3 | 2 | 1
   * ----------
   * 6 | 5 | 4
   * ----------
   * 9 | 8 | 7
   *
   * If the transformation was successful return true, if not return false;
   */
  public static boolean verticalFlip(int numRows, int numColumns, int[] board) {

    // -------------------
    // WRITE CODE HERE
    // TODO: Implement this method
    // -------------------

    // don't forget to delete this line of code!!!
	  if(board==null) {
		  System.out.println("1");
		  return false;
		  
	  }
	  
	  if(numRows<1 || numColumns<1 ) {
		  System.out.println("2");
		  System.out.println(board.length+  " 3");
		  System.out.println(numColumns*numRows);
		  return false;
	  }
	  
	if((numRows< 1) || (numColumns < 1) || (board.length !=numRows*numColumns)) {
		return false;

	}
	  
	  int array[][]= new int [numRows][numColumns];
	  for(int i=0; i<numRows;i++) { 
		  System.out.println(i );
		   for(int j=0;j<numColumns;j++) {
			   array[i][j] = board[ (i*numColumns) + j];
			   System.out.println(j );
			   System.out.println(board[ (i*numColumns) + j] );}}
		       
	  for(int i =0; i<numRows;i++) {
		  int b=0;  
			for (int j =0 ; j< numColumns/2; j++)  {
			    b++;
				int sauve = array[i][j];
				 System.out.println(sauve+" sauve" );
				array[i][j]=array[i][numColumns-b];
				 System.out.println(array[i][numColumns-b] +" array transformed" );
				array[i][numColumns-b]=sauve;
				}}System.out.println( "taille"+ array.length );
				int t,temo=0;
	  for(int i=0; i<array.length;i++) {
		   for(int a=0;a<array[i].length;a++) {
			   System.out.println( i + " cest i");
			   System.out.println( a+" cesr a"+temo);
			   
			   t= array[i][a];
			   System.out.println( "cest "+ t);
               board[temo]= t;
               temo++;
				  
				  

		   }}
    return true;
  }

 /**
   * Rotate a board 90 degrees based on the n x (numRows) x m (numColumns) grid
   * editing the provided board in place.
   *
   * If we consider a 3x3 board
   *
   * 1 | 2 | 3
   * ----------
   * 4 | 5 | 6
   * ----------
   * 7 | 8 | 9
   *
   * The updated 90 rotated board would be
   *
   * 7 | 4 | 1
   * ----------
   * 8 | 5 | 2
   * ----------
   * 9 | 6 | 3
   *
   * You can only rotate n x n boards.
   *
   * If the transformation was successful return true, if not return false;
   */
  public static boolean rotate90(int numRows, int numColumns, int[] board) {

	  if(numRows != numColumns) {
          return false;
  }
  if(board == null) {
      return false;
  }
  if((numRows < 1) || (numColumns < 1) || (board.length != numRows*numColumns)){
      return false;
  }
 int boardR[][]=new int[numRows][numColumns];
 int x=0;
 for(int i=0;i<boardR.length;i++) {
 for(int j=0;j< boardR[0].length;j++) {
 boardR[i][j]=board[x];
 x++;
 
 }
 }
x=0;
if(numRows==1 &&numColumns==1) {
board[x]=boardR[0][0];}

if(!(numRows==1 &&numColumns==1)) {
 for(int j=numRows-1;j>=0;j--) {
 for(int i=numRows-1;i>=0;i--) {
board[x]=boardR[i][j];
x++;

 }
 }
}

   
 horizontalFlip(numColumns,numRows,board);

    return true;
  }
  private static void test(int numRows, int numColumns) {
    int[] test;
    test = new int[numRows*numColumns];

    System.out.println("testing " + numRows + " numRows and " + numColumns + " numColumns.");

    identity(numRows, numColumns, test);
    System.out.println(java.util.Arrays.toString(test));

    horizontalFlip(numRows,numColumns,test);
    System.out.println("HF => " + java.util.Arrays.toString(test));

    horizontalFlip(numRows,numColumns,test);
    System.out.println("HF => " + java.util.Arrays.toString(test));

    verticalFlip(numRows,numColumns,test);
    System.out.println("VF => " + java.util.Arrays.toString(test));

    verticalFlip(numRows,numColumns,test);
    System.out.println("VF => " + java.util.Arrays.toString(test));

    for(int i = 0; i < 4; i++) {
      boolean didTransform = rotate90(numRows,numColumns,test);
      if (didTransform) {
        System.out.println("ROT => " + java.util.Arrays.toString(test));
      }
    }
  }

  public static void main(String[] args) {
	  int[] board = new int[] {
		      98, 99
		    };

		   System.out.println( Transformer.rotate90(1, 2, board));
    	    
  }

}
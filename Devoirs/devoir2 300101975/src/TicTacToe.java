import java.util.Arrays;

/**
 * The class <b>TicTacToe</b> is the
 * class that implements the Tic Tac Toe Game.
 * It contains the grid and tracks its progress.
 * It automatically maintain the current state of
 * the game as players are making moves.
 *
 * Originally written by Guy-Vincent Jourdan, University of Ottawa
 */
public class TicTacToe {

  // FINISH THE VARIABLE DECLARATION
  /**
   * The internal representation of the board
   * as a one dimensional array, but visualized
   * as a 2d board based on the number of rows
   * and number of columns.
   *
   * For example, below is a board of 3 rows
   * and 4 columns.  The board would be an array
   * of size 12 shown below.
   *
   *  1  |  2  | 3  | 4
   * --------------------
   *  5  |  6  | 7  | 8
   * --------------------
   *  9  | 10  | 11 | 12
   *
   */
  CellValue[] board;

  /**
   * The number of rows in your grid.
   */
  int numRows;

  /**
   * The number of columns in your grid.
   */
  int numColumns;

  /**
   * How many rounds have the players played so far.
   */
  int numRounds;

  /**
   * What is the current state of the game
   */
 public GameState gameState;
 

  /**
   * How many cells of the same type must be
   * aligned (vertically, horizontally, or diagonally)
   * to determine a winner of the game
   */
  int sizeToWin;

  /**
   * Who is the current player?
   */
  CellValue currentPlayer;

  /**
   * What was the last played position
   */
  int lastPlayedPosition;

  private static int DEFAULT_ROWS = 3;
  private static int DEFAULT_COLUMNS = 3;
  private static int DEFAULT_SIZETOWIN = 3;

  /**
   * The default empty constructor.  The default game
   * should be a 3x3 grid with 3 cells in a row to win.
   */
  public TicTacToe() {
    this(DEFAULT_ROWS, DEFAULT_COLUMNS, DEFAULT_SIZETOWIN);
  }

  /**
   * A constructor where you can specify the dimensions
   * of your game as rows x coluns grid, and a sizeToWin
   *
   * @param aNumRows the number of lines in the game
   * @param aNumColumns the number of columns in the game
   * @param aSizeToWin the number of cells that must be aligned to win.
   */
  public TicTacToe(int aNumRows, int aNumColumns, int aSizeToWin) {
    numRows = aNumRows;
    numColumns = aNumColumns;
    sizeToWin = aSizeToWin;
    gameState = GameState.PLAYING;
    currentPlayer = CellValue.EMPTY;
    lastPlayedPosition = 0;
    numRounds=0;
    

    int boardSize = numRows * numColumns;
    board = new CellValue[boardSize];
    for (int i=0; i<boardSize; i++) {
      board[i] = CellValue.EMPTY;
    }
  }

  /**
   * Who should play next (X or O).
   *
   * This method does not modify the state of the game.
   * Instead it tells you who should play next.
   *
   * @return The player that should play next.
   */
  public int  getNumRounds() {
		return numRounds;
	}
  public CellValue nextPlayer() {
    switch(currentPlayer) {
      case X:
        return CellValue.O;
      default:
        return CellValue.X;
    }
  }

  /**
   * What is the value at the provided cell based on the
   * grid of numRows x numColumns as illustrated below.
   *
   *  1  |  2  | 3  | 4
   * --------------------
   *  5  |  6  | 7  | 8
   * --------------------
   *  9  | 10  | 11 | 12
   *
   * Note that the input is 1-based (HINT: arrays are 0-based)
   *
   * If the position is invalid, return CellValue.INVALID.
   *
   * @param position The position on the board to look up its current value
   * @return The CellValue at that position
   */
  public CellValue valueAt(int position) {
    int maxPosition = numRows * numColumns;
    if (position < 1 || position > maxPosition) {
      return CellValue.INVALID;
    } else {
      return board[position-1];
    }
  }

  /**
   * What is the value at the provided row and column number.
   *
   *  [1,1]  | [1,2]  | [1,3]  | [1,4]
   * ----------------------------------
   *  [2,1]  | [2,2]  | [2,3]  | [2,4]
   * ----------------------------------
   *  [3,1]  | [3,2]  | [3,3] | [2,4]
   *
   * Note that the input is 1-based (HINT: arrays are 0-based)
   *
   * If the row/column is invalid, return CellValue.INVALID.
   *
   * @param position The position on the board to look up its current value
   * @return The CellValue at that row/column
   */
  public CellValue valueAt(int row, int column) {
    if (row < 1 || row > numRows) {
      return CellValue.INVALID;
    } else if (column < 1 || column > numColumns) {
      return CellValue.INVALID;
    } else {
      return valueAt((row - 1) * numColumns + column);
    }
  }

  /**
   * The next player has decided their move to the
   * provided position.
   *
   *
   *  1  |  2  | 3  | 4
   * --------------------
   *  5  |  6  | 7  | 8
   * --------------------
   *  9  | 10  | 11 | 12
   *
   * A position is invalid if:
   * a) It's off the board (e.g. based on the above < 1 or > 12)
   * b) That cell is not empty (i.e. it's no longer available)
   *
   * If the position is invalid, an error should be printed out.
   *
   * If the position is valid, then
   * a) Update the board
   * b) Update the state of the game
   * c) Allow the next player to play.
   *
   * A game can continue even after a winner is declared.
   * If that is the case, a message should be printed out
   * (that the game is infact over), but the move should
   * still be recorded.
   *
   * The winner of the game is the player who won first.
   * @param position The position that has been selected by the next player.
   * @return A message about the current play (see tests for details)
   */
  public String play(int position) {
	    CellValue playedBy = nextPlayer();
	    CellValue cell = valueAt(position);
	    switch (cell) {
	      case EMPTY:
	        currentPlayer = playedBy;
	        lastPlayedPosition = position;
	        board[position-1 ] = playedBy;
	        numRounds += 1;

	        // Only check for a winner if we were still playing.
	        if (gameState == GameState.PLAYING) {
	          gameState = checkForWinner(position);
	        }
	        return null;
	      case INVALID:
	        return "The value should be between 1 and " + (numRows * numColumns);
	      default:
	        return "Cell "+ position +" has already been played with " + cell;
	    }
	  }
  /**
   * A help method to determine if the game has been won
   * to be called after a player has played
   *
   * This method is called after the board has been updated
   * and provides the last position that was played
   * (to help you analyze the board).
   *
   * @param position The middle position to start our check
   * @return GameState to show if XWIN or OWIN.  If the result was a DRAW, or if
   *         the game is still being played.
   */
  private GameState checkForWinner(int position) {

    if (numRounds == numRows * numColumns) {
      return GameState.DRAW;
    }

    GameState ifWon;
    switch(currentPlayer) {
      case X:
        ifWon = GameState.XWIN;
        break;
      case O:
        ifWon = GameState.OWIN;
        break;
      default:
        ifWon = GameState.PLAYING;
    }

    int currentRow = (position-1)/numColumns + 1;
    int currentColumn = (position-1)%numColumns + 1;

    // Look left and right
    if (checkSizeToWin(currentRow, currentColumn, 1, 0)) {
      return ifWon;
    }

    // Look up and down
    if (checkSizeToWin(currentRow, currentColumn, 0, 1)) {
      return ifWon;
    }

    // Look diagonal down/left and diagonal up/right
    if (checkSizeToWin(currentRow, currentColumn, -1, 1)) {
      return ifWon;
    }

    // Look diagonal down/right and diagonal up/left
    if (checkSizeToWin(currentRow, currentColumn, 1, 1)) {
      return ifWon;
    }

    return GameState.PLAYING;
  }

  /**
   * Starting from a position, look "before" and "after"
   * to see if we have reached the size to win amount
   * to declare a winner.
   * @param row The current row to check
   * @param column The current row to check
   * @param rowOffset Where should we move +1 right, -1 left and 0 for no change.
   * @param columnOffset Where should we move +1 up, -1 down and 0 for no change.
   * @return Boolean True if we have at least the sizeToWin of matching cells
   */
  private boolean checkSizeToWin(int row, int column, int rowOffset, int columnOffset) {
    int numBefore = countMatches(row, column, rowOffset, columnOffset);
    int numAfter = countMatches(row, column, -rowOffset, -columnOffset);
    return (numBefore + numAfter + 1) >= sizeToWin;
  }

  /**
   * Look around the last position played for
   * the number of the same values
   * To look left, the offset is -1
   * To look right, the offsewt is +1
   * To look up, the offset is - numColumns
   * To look down, the offset is + numColumns
   * @param row The current row to check
   * @param column The current row to check
   * @param rowOffset Where should we move +1 right, -1 left and 0 for no change.
   * @param columnOffset Where should we move +1 up, -1 down and 0 for no change.
   * @return The number of similar plays based on the offset
   */
  private int countMatches(int row, int column, int rowOffset, int columnOffset) {
    int numFound = 0;
    int checkRow = row;
    int checkColumn = column;
    while (true) {
      checkRow += rowOffset;
      checkColumn += columnOffset;
      if (valueAt(checkRow, checkColumn) == currentPlayer) {
        numFound += 1;
      } else {
        break;
      }
    }
    return numFound;
  }

  /**
   * A text based representation of the 2D grid, and
   * should include all played Xs and Os.  For example
   * On a 3x3 board.  (HINT: \n for newlines)
   *
   *    | X |
   * -----------
   *  O |   |
   * -----------
   *    |   |
   *
   * @return String representation of the game
   */
  public String toString() {
    StringBuilder b = new StringBuilder();
    int maxRowsIndex = numRows - 1;
    int maxColumnsIndex = numColumns - 1;

    String lineSeparator = repeat("---", numColumns) + repeat("-", numColumns - 1);

    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < this.numColumns; j++) {
        int index = i*numColumns + j;

        b.append(" ");
        b.append(board[index]);
        b.append(" ");

        if (j < maxColumnsIndex) {
          b.append("|");
        }
      }

      // Line separator after each row, except the last
      if (i < maxRowsIndex) {
        b.append("\n");
        b.append(lineSeparator);
        b.append("\n");
      }
    }

    return b.toString();
  }

  /**
   * An array of positions that are empty
   * and available to be played on.
   *
   *    | X |
   * -----------
   *  O |   |
   * -----------
   *    |   |
   *
   * The results are 1-based (not zero), and
   * in the above board the empty positions are
   * [1, 3, 5, 6, 7, 8, 9]
   *
   * Hint: Useful for a computer to know which
   *       positions are available to choose from.
   *       Also useful for generating all game boards.
   *
   * @return All empty positions
   */
  public int[] emptyPositions() {
	 
    // YOUR CODE HERE
	  
	  int compter = 0;
	 
	  for (int i= 1 ; i <= numRows*numColumns; i++) {
		  if (valueAt(i) == CellValue.EMPTY) {
			  compter+=1;
		  }
		
			  
		  }
	  
	  int [] possibiliteDeJouer = new int [compter] ;
	  int c =0;
	  for (int i= 1 ; i <=numRows*numColumns; i++) {
		  if (valueAt(i) == CellValue.EMPTY) {
			  possibiliteDeJouer[c]=i;
			  c+=1;
		  }
		 
	  }System.out.println(Arrays.toString(possibiliteDeJouer));
	  return possibiliteDeJouer ;

  }

  /**
   * Create a copy of the current game with one extra move
   * added.  The new game is a deep copy of this game
   * and then we apply the next move.  If the move
   * is not valid, return null;
   * @param nextMove The desired next move (1 to numRows x numColumns)
   * @return A new TicTacToe game
   */
  public TicTacToe cloneNextPlay(int nextMove) {

    // YOUR CODE HERE
	  if (this.gameState==GameState.PLAYING) {
			  TicTacToe cloneNextPlay = new TicTacToe(this.numRows, this.numColumns,this.sizeToWin);
			 
			  cloneNextPlay.currentPlayer = this.currentPlayer;
			  cloneNextPlay.lastPlayedPosition = nextMove;
			  cloneNextPlay.numRounds=this.numRounds;
			  if(nextMove<0 || nextMove>numRows*numColumns) {
				 return null;
			  }
			  for(int i =0 ; i<numColumns*numRows; i++) {
				  cloneNextPlay.board[i]=this.board[i];
			  } 
			  cloneNextPlay.play(nextMove);
			  return cloneNextPlay;}
			  
			return null;  
			  
	 /* TicTacToe f;
	  String res = "";	 
		for(int i = 0; i < numRows ; i++){
			if(i>0) {
				for(int j = 0; j < 4*numColumns - 1; j++){
					res+="-";
				}
				res+= Utils.NEW_LINE;
			}
			for(int j = 0; j < numColumns ; j++){
				switch(board[i*numColumns + j]){
					case X:
						res+= " X ";
						break;
					case O:
						res+= " O ";
						break;
					default:
						res+=  "  -";
				}
				if(j<numColumns - 1){
					res += "|";
				} else{
					res += Utils.NEW_LINE;
				}
			}
		}
		
		return res ;*/
		
	}


  

  /**
   * Compares this instance of the game with the
   * instance passed as parameter. Return true
   * if and only if the two instance represent
   * the same state of the game including
   * The board dimensions, number of cells to
   * win, and the pieces on the board.
   * @param obj An object we are comparing against
   * @return True if they represent the same state
   */
  public boolean equals(Object obj) {

    // YOUR CODE HERE
	  if(obj==null) {
		  return false;
	  }
	  if(getClass()!=obj.getClass()) {
		return false;  
	  }
	  TicTacToe other = (TicTacToe)obj;
	  if(this.numRows!=other.numRows || this.numColumns!= other.numColumns || this.sizeToWin != other.sizeToWin ){
		  return false;
	  }
	  for (int i =0; i<this.board.length;i++) {
		  if (this.board[i]!=other.board[i] ){
			  return false;
		  }
		  
	  }
	  
	  return true;

  }

  /**
   * Expose all internal data for debugging purposes
   *
   * @return String representation of the game
   */
  public String toDebug() {
    StringBuilder b = new StringBuilder();
    b.append("Grid (rows x columns): " + numRows + " x " + numColumns);
    b.append("\n");
    b.append("Size To Win: " + sizeToWin);
    b.append("\n");
    b.append("Num Rounds: " + numRounds);
    b.append("\n");
    b.append("Game State: " + gameState);
    b.append("\n");
    b.append("Current Player: " + currentPlayer);
    b.append("\n");
    b.append("Next Player: " + nextPlayer());
    b.append("\n");

    b.append("Board (array): [");
    for (int i=0; i<board.length; i++) {
      if (i > 0) {
        b.append(",");
      }
      b.append(board[i]);
    }
    b.append("]\n");

    return b.toString();
  }

  /**
   * The method String repeat is availabe in Java 11+
   * Some students still have Java 8 (or less) so we
   * will implement this method directly for backwards
   * compatibility
   * @param str The string the repeat
   * @param numTimes How often to repeat
   */
  private static String repeat(String str, int numTimes)
  {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < numTimes; i++) {
      sb.append(str);
    }
    return sb.toString();
  }

public GameState getGameState() {
	return gameState;
}

 
}
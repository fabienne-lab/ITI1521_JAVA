/**ComputerInOrderPlayer est une classe qui impl�mente �galement l'interface Player. 
Dans son impl�mentation de la m�thode play,
il v�rifie d'abord que le jeu est jouable (et retourne faux s'il ne l'est pas), 
puis choisit la premi�re cellule disponible.*/
public class ComputerInOrderPlayer implements Player {
	public boolean  play(TicTacToe game) {
		

   if(game.getNumRounds()== game.numColumns*game.numRows){
		
		return false;}
		
   else if(game.gameState==GameState.PLAYING ||game.gameState==GameState.OWIN || game.gameState==GameState.XWIN) {
	  boolean continueDeJouer=true;
  
	  while(continueDeJouer==true) {
			for(int i =1 ; i<=game.numRows*game.numColumns;i++) {
				
			 if (game.valueAt(i) == CellValue.EMPTY) {
				 
				
				 game.currentPlayer=game.valueAt(game.lastPlayedPosition);
				 game.gameState=GameState.PLAYING;
				 game.play(i);
				
				 continueDeJouer=false;
				
				 return true;
			 }
			
			} return true;
			
		      }}
	
		      
		  
		
	return true;
	}
	
}

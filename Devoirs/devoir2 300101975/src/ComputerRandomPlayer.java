/**ComputerRandomPlayer est une classe qui r�alise �galement l�interface Player. 
Dans son impl�mentation de la m�thode play, elle v�rifie d�abord que la partie est effectivement jouable (et renvoie faux si ce n'est pas), 
puis choisit au hasard le cellule suivant,
le joue et passe la main � l�autre joueur. 
Tous les cellules suivants possibles ont une chance �gale d��tre jou�s.*/
public class ComputerRandomPlayer implements Player {
	public boolean  play(TicTacToe game) {
		

		if(game.getNumRounds()== game.numColumns*game.numRows){
			System.out.println("le jeux est deja fini");
			
			return false;
		}
	
		int choice;
		boolean continueDeJouer = true;
		while(continueDeJouer==true) {
		for(int i =0 ; i<game.numRows*game.numColumns;i++) {
		choice = Utils.generator.nextInt(game.numRows*game.numColumns);
		 if (game.valueAt(choice) == CellValue.EMPTY) {
			 game.gameState=GameState.PLAYING;
			 game.play(choice);
			 break;
			}
		} 
		
	      continueDeJouer=false;}
	      
	
  
		 return true ;
	}


}
